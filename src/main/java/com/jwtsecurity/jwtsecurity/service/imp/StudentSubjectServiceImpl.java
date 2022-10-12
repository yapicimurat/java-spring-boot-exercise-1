package com.jwtsecurity.jwtsecurity.service.imp;


import com.jwtsecurity.jwtsecurity.consts.exception.ResultMessages;
import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.model.Student;
import com.jwtsecurity.jwtsecurity.model.StudentSubject;
import com.jwtsecurity.jwtsecurity.model.Subject;
import com.jwtsecurity.jwtsecurity.model.key.StudentSubjectKey;
import com.jwtsecurity.jwtsecurity.repository.StudentSubjectRepository;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.response.result.SuccessDataResult;
import com.jwtsecurity.jwtsecurity.response.result.SuccessResult;
import com.jwtsecurity.jwtsecurity.service.StudentSubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {


    private StudentSubjectRepository studentSubjectRepository;
    private ModelMapper modelMapper = BaseService.getModelMapperInstance();

    public StudentSubjectServiceImpl(StudentSubjectRepository studentSubjectRepository) {
        this.studentSubjectRepository = studentSubjectRepository;
    }

    @Override
    public Result deleteStudentSubjectByStudentIdAndSubjectId(Long studentId, Long subjectId) {
        final StudentSubject foundedStudentSubject = findStudentSubjectByStudentIdAndSubjectId(studentId, subjectId);

        studentSubjectRepository.delete(foundedStudentSubject);

        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    @Override
    public Result deleteStudentSubjectsByStudentId(Long studentId) {
        final List<StudentSubject> studentSubjects = findStudentSubjectByStudentId(studentId);
        studentSubjectRepository.deleteAll(studentSubjects);
        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    @Override
    public Result deleteStudentSubjectsBySubjectId(Long subjectId) {
        final List<StudentSubject> studentSubjects = findStudentSubjectBySubjectId(subjectId);
        studentSubjectRepository.deleteAll(studentSubjects);
        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    //PRIVATE SPECIAL METHODS

    private StudentSubject findStudentSubjectByStudentIdAndSubjectId(Long studentId, Long subjectId){
        return Optional.ofNullable(studentSubjectRepository.getStudentSubjectByStudentIdAndSubjectId(studentId, subjectId))
                .orElseThrow(() -> new EntityNotFoundException("Ogrenci dersi bulunamadi."));
    }

    private List<StudentSubject> findStudentSubjectByStudentId(Long studentId){
        return Optional.ofNullable(studentSubjectRepository.getStudentSubjectsByStudentId(studentId))
                .orElseThrow(() -> new EntityNotFoundException("Ogrenci dersleri bulunamadi."));
    }

    private List<StudentSubject> findStudentSubjectBySubjectId(Long subjectId){
        return Optional.ofNullable(studentSubjectRepository.getStudentSubjectsBySubjectId(subjectId))
                .orElseThrow(() -> new EntityNotFoundException("Ogrenci dersleri bulunamadi."));
    }

}
