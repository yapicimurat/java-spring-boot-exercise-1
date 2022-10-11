package com.jwtsecurity.jwtsecurity.service.imp;

import com.jwtsecurity.jwtsecurity.consts.exception.ResultMessages;
import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.model.Teacher;
import com.jwtsecurity.jwtsecurity.repository.TeacherRepository;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherCreateRequest;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.TeacherGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.response.result.SuccessDataResult;
import com.jwtsecurity.jwtsecurity.response.result.SuccessResult;
import com.jwtsecurity.jwtsecurity.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper = BaseService.getModelMapperInstance();

    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
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

    private Teacher findTeacherById(Long teacherId){
        return Optional.ofNullable(teacherRepository.getTeacherById(teacherId))
                .orElseThrow(() -> new EntityNotFoundException());
    }
}
