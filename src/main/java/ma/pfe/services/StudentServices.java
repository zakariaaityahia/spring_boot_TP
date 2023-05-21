package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;

import java.util.List;

public interface StudentServices {
    Long create(StudentDto dto);
    boolean update(StudentDto dto);
    boolean delete(Long id);
    List<StudentDto> readAll();
}
