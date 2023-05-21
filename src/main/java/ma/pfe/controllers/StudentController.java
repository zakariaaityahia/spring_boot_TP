package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.repositories.StudentRepositoryImpl;
import ma.pfe.services.StudentServices;
import ma.pfe.services.StudentServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final static Logger LOG =  LoggerFactory.getLogger(StudentController.class);
    private StudentServicesImpl service;
    StudentController(StudentServicesImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Long  save(@RequestBody StudentDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public boolean update(@RequestBody StudentDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){
        return service.delete(id);
    }
    @GetMapping
    public List<StudentDto> readAll() {
        return service.readAll();
    }

}
