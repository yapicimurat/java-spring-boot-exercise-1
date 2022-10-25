package com.jwtsecurity.jwtsecurity.service.imp;

import com.jwtsecurity.jwtsecurity.consts.exception.ResultMessages;
import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.model.Subject;
import com.jwtsecurity.jwtsecurity.repository.SubjectRepository;
import com.jwtsecurity.jwtsecurity.request.subject.SubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.subject.SubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.subject.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.response.result.SuccessDataResult;
import com.jwtsecurity.jwtsecurity.response.result.SuccessResult;
import com.jwtsecurity.jwtsecurity.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper = BaseService.getModelMapperInstance();

    public SubjectServiceImpl(SubjectRepository subjectRepository)
    {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public DataResult<List<SubjectGetResponse>> getAllSubjects() {
        List<SubjectGetResponse> subjectGetResponseList = new ArrayList<>();

        subjectRepository.findAll().forEach(subject -> subjectGetResponseList.add(modelMapper.map(subject, SubjectGetResponse.class)));

        return new SuccessDataResult(subjectGetResponseList, ResultMessages.EMPTY);
    }

    @Override
    public DataResult<SubjectGetResponse> getSubjectBySubjectId(Long subjectId) {
        final Subject foundedSubject = findSubjectBySubjectId(subjectId);

        return new SuccessDataResult(modelMapper.map(foundedSubject, SubjectGetResponse.class), ResultMessages.EMPTY);
    }

    @Override
    public DataResult<SubjectGetResponse> createSubject(SubjectCreateRequest subjectCreateRequest) {
        final Subject subject = new Subject();

        subject.setName(subjectCreateRequest.name);

        subjectRepository.save(subject);

        return new SuccessDataResult(modelMapper.map(subject, SubjectGetResponse.class), ResultMessages.SUCCESS_CREATE_ENTITY);
    }

    @Override
    public DataResult<SubjectGetResponse> updateSubject(Long subjectId, SubjectUpdateRequest subjectUpdateRequest) {
        final Subject foundedSubject = findSubjectBySubjectId(subjectId);

        foundedSubject.setName(subjectUpdateRequest.name);

        subjectRepository.save(foundedSubject);

        return new SuccessDataResult(modelMapper.map(foundedSubject, SubjectGetResponse.class), ResultMessages.SUCCESS_UPDATE_ENTITY);
    }

    @Override
    public Result deleteSubject(Long subjectId) {
        final Subject foundedSubject = findSubjectBySubjectId(subjectId);

        subjectRepository.delete(foundedSubject);

        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    private Subject findSubjectBySubjectId(Long subjectId){
        Subject foundedSubject = Optional.ofNullable(subjectRepository.getSubjectById(subjectId))
                .orElseThrow(() -> new EntityNotFoundException());
        return foundedSubject;
    }
}
