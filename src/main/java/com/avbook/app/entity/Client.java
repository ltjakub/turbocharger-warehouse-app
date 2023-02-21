package com.avbook.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    @ManyToOne
    private Address address;
    @ManyToOne
    private Company company;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Turbocharger> turbochargers;

}
