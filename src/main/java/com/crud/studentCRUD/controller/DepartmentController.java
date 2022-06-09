package com.crud.studentCRUD.controller;


import com.crud.studentCRUD.form.DepartmentForm;
import com.crud.studentCRUD.model.Department;
import com.crud.studentCRUD.studentService.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public String viewDepartment(Model model) {
        List<Department> departmentlist = departmentService.listAll();
        model.addAttribute("departmentlist", departmentlist);
        return "index";
    }

    @GetMapping("/newdepartment")
    public String add(Model model) {
        model.addAttribute("department", new DepartmentForm());
        return "newdepartment";
    }

    @PostMapping(value = "/savedepartment")
    public String saveDepartment(@ModelAttribute("department") DepartmentForm dpt) {

        departmentService.save(Department.builder()
                .id(dpt.getId())
                .department(dpt.getDepartment())
                .description(dpt.getDescription())
                .credit(dpt.getCredit())
                .build());
        return "index";
    }

    @GetMapping("/editdepartment/{id}")
    public ModelAndView showEditDepartmentPage(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("newdepartment");
        Department dpt = departmentService.get(id);
        modelAndView.addObject("department", dpt);
        return modelAndView;
    }


    @RequestMapping("/deletedepartment/{id}")
    public String deletedepartment(@PathVariable(name = "id") int id) {
        departmentService.delete(id);
        return "redirect:/department";
    }


}
