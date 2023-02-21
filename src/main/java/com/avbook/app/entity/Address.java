package com.avbook.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Size(min = 1, max = 150)
    private String street;
    @NotNull
    @Size(min = 1, max = 150)
    private String city;
    @NotNull
    @Size(min = 1, max = 150)
    private String state;
    @NotNull
    @Size(min = 1, max = 150)
    private String zip;
    @OneToMany(mappedBy = "address")
    private List<Client> clients;
}
