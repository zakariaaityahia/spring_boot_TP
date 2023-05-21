package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.mappers.StudentMappers;
import ma.pfe.repositories.StudentRepository;
import ma.pfe.repositories.StudentRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentServices{

    private final static Logger LOG =  LoggerFactory.getLogger(StudentServicesImpl.class);

    @Autowired
    private StudentRepositoryImpl studentRepository;
    @Autowired
    private StudentMappers studentMappers;

//    public StudentServicesImpl(StudentRepositoryImpl studentRepository, StudentMappers studentMappers) {
//        this.studentRepository = studentRepository;
//        this.studentMappers = studentMappers;
//    }

    @Override
    public Long create(StudentDto dto) {
       LOG.debug("method create running ...");
        studentRepository.create(studentMappers.convertEntity(dto));
       return null;
    }

    @Override
    public boolean update(StudentDto dto) {
        LOG.debug("update method is running ....");
        return (studentRepository.update(studentMappers.convertEntity(dto)) != null);

    }

    @Override
    public boolean delete(Long id) {
        LOG.debug("delete method is running ...");
        return studentRepository.delete(id);
    }

    @Override
    public List<StudentDto> readAll() {
        return studentMappers.convertToDtos(studentRepository.readAll()) ;
    }
}
