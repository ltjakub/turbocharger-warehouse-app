package com.avbook.app.entity;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Turbocharger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @ManyToOne
    private Company company;
    @NonNull
    private String serialNo;
    @Enumerated(EnumType.STRING)
    private TurbochargerStatus status;
    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String engineType;
    @NonNull
    private Integer volume;
    @NonNull
    private Integer power;
    @NonNull
    private LocalDate producedFrom;
    @NonNull
    private LocalDate producedTo;
}
