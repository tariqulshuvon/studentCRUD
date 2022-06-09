package com.crud.studentCRUD.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department")
    private String department;

    @Column(name = "description")
    private String description;

    @Column(name = "credit")
    private int credit;

}
