package com.avbook.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turbocharger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @ManyToOne
    private Company company;
    @ManyToOne
    private Client client;
    @NotNull
    private String serialNo;
    @Enumerated(EnumType.STRING)
    private TurbochargerStatus status;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String engineType;
    @NotNull
    private Integer volume;
    @NotNull
    private Integer power;
    @NotNull
    private LocalDate producedFrom;
    @NotNull
    private LocalDate producedTo;
    private String position;
    private String comment;
}
