package com.crud.studentCRUD.form;

import lombok.Data;

@Data
public class StudentForm {
    private Long id;
    private String name;
    private String department;
    private double cgpa;
}
