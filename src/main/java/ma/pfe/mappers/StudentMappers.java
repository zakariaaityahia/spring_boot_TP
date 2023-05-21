package ma.pfe.mappers;
import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMappers {

    public StudentDto convertToDto(StudentEntity entity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(entity.getId());
        studentDto.setName(entity.getName());
        return studentDto;
    }

    public StudentEntity convertEntity(StudentDto dto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(dto.getId());
        studentEntity.setName(dto.getName());
        return studentEntity;
    }
    public List<StudentEntity> convertToEntities(List<StudentDto> dtos) {
        return dtos.stream().map(dto -> convertEntity(dto)).collect(Collectors.toList());

    }
    public List<StudentDto> convertToDtos(List<StudentEntity> entities) {
        return entities.stream().map(entity -> convertToDto(entity)).collect(Collectors.toList());
    }
}
