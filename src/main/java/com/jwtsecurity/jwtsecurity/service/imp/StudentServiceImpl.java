package com.jwtsecurity.jwtsecurity.service.imp;

import com.jwtsecurity.jwtsecurity.consts.exception.ResultMessages;
import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.model.Address;
import com.jwtsecurity.jwtsecurity.model.Student;
import com.jwtsecurity.jwtsecurity.model.Subject;
import com.jwtsecurity.jwtsecurity.repository.AddressRepository;
import com.jwtsecurity.jwtsecurity.repository.StudentRepository;
import com.jwtsecurity.jwtsecurity.repository.SubjectRepository;
import com.jwtsecurity.jwtsecurity.request.address.AddressCreateRequest;
import com.jwtsecurity.jwtsecurity.request.address.AddressUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentCreateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.AddressGetResponse;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.response.result.SuccessDataResult;
import com.jwtsecurity.jwtsecurity.response.result.SuccessResult;
import com.jwtsecurity.jwtsecurity.response.student.StudentGetResponse;
import com.jwtsecurity.jwtsecurity.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final SubjectRepository subjectRepository;

    private final ModelMapper modelMapper = BaseService.getModelMapperInstance();

    public StudentServiceImpl(StudentRepository studentRepository, AddressRepository addressRepository, SubjectRepository subjectRepository){
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public DataResult<List<StudentGetResponse>> getAllStudents() {
        List<StudentGetResponse> studentGetResponseList = new ArrayList<>();

        studentRepository.findAll().forEach(student -> {
            studentGetResponseList.add(modelMapper.map(student, StudentGetResponse.class));
        });

        return new SuccessDataResult(studentGetResponseList, ResultMessages.EMPTY);
    }

    @Override
    public DataResult<StudentGetResponse> getStudentById(Long studentId) {
        Student foundedStudent = findStudentById(studentId);

        StudentGetResponse studentGetResponse = modelMapper.map(foundedStudent, StudentGetResponse.class);

        return new SuccessDataResult(studentGetResponse, ResultMessages.EMPTY);
    }

    @Override
    public DataResult<StudentGetResponse> createStudent(StudentCreateRequest studentCreateRequest) {
        final Student student = new Student();

        student.setName(studentCreateRequest.name);
        student.setSurname(studentCreateRequest.surname);

        studentRepository.save(student);

        return new SuccessDataResult(modelMapper.map(student, StudentGetResponse.class), ResultMessages.SUCCESS_CREATE_ENTITY);
    }

    @Override
    public DataResult<StudentGetResponse> updateStudent(Long studentId, StudentUpdateRequest studentUpdateRequest) {
        final Student foundedStudent = findStudentById(studentId);

        foundedStudent.setName(studentUpdateRequest.name);
        foundedStudent.setSurname(studentUpdateRequest.surname);

        studentRepository.save(foundedStudent);

        return new SuccessDataResult(modelMapper.map(foundedStudent, StudentGetResponse.class), ResultMessages.SUCCESS_UPDATE_ENTITY);
    }

    @Override
    public Result deleteStudent(Long studentId) {
        final Student foundedStudent = findStudentById(studentId);
        studentRepository.delete(foundedStudent);
        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    @Override
    public DataResult<AddressGetResponse> getStudentAddress(Long studentId) {
        final Address studentAddress = getStudentAddressByStudentId(studentId);
        return new SuccessDataResult(modelMapper.map(studentAddress, AddressGetResponse.class), ResultMessages.EMPTY);
    }

    @Override
    public DataResult<AddressGetResponse> addStudentAddress(Long studentId, AddressCreateRequest addressCreateRequest) {
        final Student foundedStudent = findStudentById(studentId);

        Address studentAddress = new Address();

        studentAddress.setStudent(foundedStudent);
        studentAddress.setAddress(addressCreateRequest.address);

        addressRepository.save(studentAddress);

        return new SuccessDataResult(modelMapper.map(studentAddress, AddressGetResponse.class), ResultMessages.SUCCESS_CREATE_ENTITY);
    }

    @Override
    public DataResult<AddressGetResponse> updateStudentAddress(Long studentId, AddressUpdateRequest addressUpdateRequest) {
        final Address studentAddress = getStudentAddressByStudentId(studentId);

        studentAddress.setAddress(addressUpdateRequest.address);
        addressRepository.save(studentAddress);

        return new SuccessDataResult(modelMapper.map(studentAddress, AddressGetResponse.class), ResultMessages.SUCCESS_UPDATE_ENTITY);
    }

    @Override
    public Result deleteAddress(Long studentId) {
        final Address studentAddress = getStudentAddressByStudentId(studentId);

        addressRepository.delete(studentAddress);

        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    @Override
    public DataResult<List<SubjectGetResponse>> getStudentSubjectsByStudentId(Long studentId) {
        final Student foundedStudent = findStudentById(studentId);

        List<SubjectGetResponse> subjectGetResponses = new ArrayList<>();

        foundedStudent.getSubjects().forEach(subject ->
            subjectGetResponses.add(modelMapper.map(subject, SubjectGetResponse.class))
        );

        return new SuccessDataResult(subjectGetResponses, ResultMessages.EMPTY);
    }

    @Override
    public DataResult<SubjectGetResponse> addStudentSubject(StudentSubjectCreateRequest studentSubjectCreateRequest) {
        final Student foundedStudent = findStudentById(studentSubjectCreateRequest.getStudentId());

        final Subject foundedSubject = findSubjectBySubjectId(studentSubjectCreateRequest.getSubjectId());

        foundedStudent.getSubjects().add(foundedSubject);

        studentRepository.save(foundedStudent);

        return new SuccessDataResult(modelMapper.map(foundedSubject, SubjectGetResponse.class), ResultMessages.SUCCESS_CREATE_ENTITY);
    }

    @Override
    @Transactional
    public DataResult<StudentGetResponse> updateStudentSubject(final Long targetSubjectId, final StudentSubjectUpdateRequest studentSubjectUpdateRequest) {
        final Student targetStudent = findStudentById(studentSubjectUpdateRequest.getStudentId());

        final Subject studentTargetSubject = findSubjectBySubjectId(targetSubjectId);

        targetStudent.getSubjects().remove(studentTargetSubject);

        final Subject newSubject = findSubjectBySubjectId(studentSubjectUpdateRequest.getSubjectId());

        targetStudent.getSubjects().add(newSubject);

        studentRepository.save(targetStudent);

        return new SuccessDataResult(modelMapper.map(targetStudent, StudentGetResponse.class), ResultMessages.SUCCESS_UPDATE_ENTITY);
    }

    @Override
    public Result deleteStudentSubject(final Long studentId, final Long subjectId) {
        final Student targetStudent = findStudentById(studentId);

        final Subject targetSubject = findSubjectBySubjectId(subjectId);

        targetStudent.getSubjects().remove(targetSubject);

        studentRepository.save(targetStudent);


        return new SuccessResult(ResultMessages.SUCCESS_DELETE_ENTITY);
    }

    //PRIVATE HELPER METHODS
    private Student findStudentById(Long studentId){
        return Optional.ofNullable(studentRepository.getStudentById(studentId))
                .orElseThrow(() -> new EntityNotFoundException("Ogrenci bulunamadi."));
    }

    private Subject findSubjectBySubjectId(Long subjectId){
        Subject foundedSubject = Optional.ofNullable(subjectRepository.getSubjectById(subjectId))
                .orElseThrow(() -> new EntityNotFoundException("Ders bulunamadi."));
        return foundedSubject;
    }

    private Address getStudentAddressByStudentId(Long studentId){
        Address studentAddress = Optional.ofNullable(findStudentById(studentId).getAddress())
                .orElseThrow(() -> new EntityNotFoundException());

        return studentAddress;
    }

}