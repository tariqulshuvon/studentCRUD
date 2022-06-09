package com.crud.studentCRUD.form;


import lombok.Data;

@Data
public class DepartmentForm {
    private long id;
    private String department;
    private String description;
    private  int credit;
}
