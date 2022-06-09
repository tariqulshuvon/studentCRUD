package com.crud.studentCRUD.studentService;


import com.crud.studentCRUD.model.Department;
import com.crud.studentCRUD.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> listAll() {
        return departmentRepository.findAll();
    }

    public void save (Department dpt) {
        departmentRepository.save(dpt);
    }
    public Department get(long id) {
        return departmentRepository.findById(id).get();
    }
    public void delete(long id) {
        departmentRepository.deleteById(id);
    }

}
