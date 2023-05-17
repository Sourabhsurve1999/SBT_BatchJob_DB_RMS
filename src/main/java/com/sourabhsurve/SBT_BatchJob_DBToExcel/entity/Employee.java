package com.sourabhsurve.SBT_BatchJob_DBToExcel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "empId")
    private String eid;

    @Column(name = "empName")
    private String name;

    private String dateOfJoining;

    private Double experience;

}
