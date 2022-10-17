package com.jwtsecurity.jwtsecurity.service.imp;

import com.jwtsecurity.jwtsecurity.consts.exception.ResultMessages;
import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.model.Subject;
import com.jwtsecurity.jwtsecurity.model.Teacher;
import com.jwtsecurity.jwtsecurity.repository.SubjectRepository;
import com.jwtsecurity.jwtsecurity.repository.TeacherRepository;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherCreateRequest;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.teachersubject.TeacherSubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.teachersubject.TeacherSubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.TeacherGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.response.result.SuccessDataResult;
import com.jwtsecurity.jwtsecurity.response.result.SuccessResult;
import com.jwtsecurity.jwtsecurity.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper = BaseService.getModelMapperInstance();

    public TeacherServiceImpl(TeacherRepository teacherRepository, SubjectRepository subjectRepository){
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public DataResult<List<TeacherGetResponse>> getAllTeachers() {
        List<TeacherGetResponse> teacherGetResponseList = new ArrayList<>();

        teacherRepository.findAll().forEach(teacher -> teacherGetResponseList.add(modelMapper.map(teacher, TeacherGetResponse.class)));

        return new SuccessDataResult(teacherGetResponseList, ResultMessages.EMPTY);
    }

    @Override
    public DataResult<TeacherGetResponse> getTeacherById(Long teacherId) throws EntityNotFoundException {
        return new SuccessDataResult(modelMapper.map(findTeacherById(teacherId), TeacherGetResponse.class), ResultMessages.EMPTY);
    }

    @Override
    public DataResult<TeacherGetResponse> createTeacher(TeacherCreateRequest teacherCreateRequest) {
        final Teacher teacher = new Teacher();

        teacher.setName(teacherCreateRequest.name);
        teacher.setSurname(teacherCreateRequest.surname);

        return new SuccessDataResult(modelMapper.map(teacher, TeacherGetResponse.class), ResultMessages.SUCCESS_CREATE_ENTITY);
    }

    @Override
    public DataResult<TeacherGetResponse> updateTeacher(Long teacherId, TeacherUpdateRequest teacherUpdateRequest)
            throws EntityNotFoundException {
        final Teacher foundedTeacher = findTeacherById(teacherId);

        foundedTeacher.setName(teacherUpdateRequest.name);
        foundedTeacher.setSurname(teacherUpdateRequest.surname);

        return new SuccessDataResult(modelMapper.map(foundedTeacher, TeacherGetResponse.class), ResultMessages.SUCCESS_UPDATE_ENTITY);
    }

    @Override
    public Result deleteTeacher(Long teacherId) throws EntityNotFoundException {
        final Teacher foundedTeacher = findTeacherById(teacherId);

        teacherRepository.delete(foundedTeacher);

        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    @Override
    public DataResult<List<SubjectGetResponse>> getTeacherSubjectsByTeacherId(final Long teacherId) {
        final Teacher teacher = findTeacherById(teacherId);
        List<SubjectGetResponse> subjectGetResponses = new ArrayList<>();

        teacher.getSubjects()
                .forEach(subject -> {
                    subjectGetResponses.add(modelMapper.map(subject, SubjectGetResponse.class));
                });

        return new SuccessDataResult(subjectGetResponses, ResultMessages.EMPTY);
    }

    @Override
    public DataResult<SubjectGetResponse> createTeacherSubject(final TeacherSubjectCreateRequest teacherSubjectCreateRequest) {
        final Teacher teacher = findTeacherById(teacherSubjectCreateRequest.getTeacherId());
        final Subject subject = findSubjectBySubjectId(teacherSubjectCreateRequest.getSubjectId());

        teacher.getSubjects()
                        .add(subject);

        teacherRepository.save(teacher);


        return new SuccessDataResult(modelMapper.map(subject, SubjectGetResponse.class), ResultMessages.SUCCESS_CREATE_ENTITY);


    }

    @Override
    @Transactional
    public DataResult<SubjectGetResponse> updateTeacherSubject(final Long targetSubjectId, final TeacherSubjectUpdateRequest teacherSubjectUpdateRequest) {
        final Teacher teacher = findTeacherById(teacherSubjectUpdateRequest.getTeacherId());

        final Subject targetSubject = findSubjectBySubjectId(targetSubjectId);

        teacher.getSubjects().remove(targetSubject);

        final Subject newSubject = findSubjectBySubjectId(teacherSubjectUpdateRequest.getSubjectId());
        teacher.getSubjects().add(newSubject);

        teacherRepository.save(teacher);

        return new SuccessDataResult(modelMapper.map(newSubject, SubjectGetResponse.class), ResultMessages.SUCCESS_UPDATE_ENTITY);
    }

    @Override
    public Result deleteTeacherSubject(final Long teacherId, final Long subjectId) {
        final Teacher targetTeacher = findTeacherById(teacherId);

        targetTeacher.getSubjects()
                .remove(findSubjectBySubjectId(subjectId));

        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    private Teacher findTeacherById(Long teacherId){
        return Optional.ofNullable(teacherRepository.getTeacherById(teacherId))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    private Subject findSubjectBySubjectId(Long subjectId){
        return Optional.ofNullable(subjectRepository.getSubjectById(subjectId))
                .orElseThrow(() -> new EntityNotFoundException());
    }
}
