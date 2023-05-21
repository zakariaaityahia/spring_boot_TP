package ma.pfe.repositories;

import ma.pfe.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private final static Logger LOG =  LoggerFactory.getLogger(StudentRepositoryImpl.class);

    private static final List<StudentEntity> data = new ArrayList<>();

    @Override
    public StudentEntity create(StudentEntity studentEntity) {
        data.add(studentEntity);
        return studentEntity;
    }

    @Override
    public StudentEntity update(StudentEntity e) {
        int indexObject = -1;
        for (int index = 0 ; index < data.size(); index++){
            if(data.get(index).getId() == e.getId()){
                indexObject = index;
            }
        }
        if (indexObject != -1){
            data.remove(indexObject);
            data.add(indexObject, e);
                return e;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        int indexObject = -1;
        for (int index = 0 ; index < data.size(); index++){
            if(data.get(index).getId() == id){
                indexObject = index;
            }
        }
        if (indexObject != -1){
            data.remove(indexObject);
            return true;
        }
     return false;
    }

    @Override
    public List<StudentEntity> readAll() {
        return data;
    }

}
