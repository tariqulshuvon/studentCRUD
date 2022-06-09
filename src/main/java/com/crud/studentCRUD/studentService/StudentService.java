package com.crud.studentCRUD.studentService;


import com.crud.studentCRUD.model.Student;
import com.crud.studentCRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public void save(Student std) {
        studentRepository.save(std);
    }

    public Student get(long id) {
        return studentRepository.findById(id).get();
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
