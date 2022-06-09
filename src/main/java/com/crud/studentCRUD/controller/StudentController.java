package com.crud.studentCRUD.controller;


import com.crud.studentCRUD.form.StudentForm;
import com.crud.studentCRUD.model.Student;
import com.crud.studentCRUD.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String viewHomePage(Model model) {
        List<Student> liststudent = studentService.listAll();
        model.addAttribute("liststudent", liststudent);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("student", new StudentForm());
        return "new";
    }

    @PostMapping(value = "/save")
    public String saveStudent(@ModelAttribute("student") StudentForm std) {
        studentService.save(Student.builder()
                .id(std.getId())
                .name(std.getName())
                .department(std.getDepartment())
                .cgpa(std.getCgpa())
                .build());
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Student std = studentService.get(id);
        mav.addObject("student", std);
        return mav;

    }

    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        studentService.delete(id);
        return "redirect:/student";
    }
}

