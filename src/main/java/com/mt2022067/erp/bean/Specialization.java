package com.mt2022067.erp.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(unique = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer Year;

    @Column(name = "credits_required", nullable = false)
    private Integer creditsRequired;
}
