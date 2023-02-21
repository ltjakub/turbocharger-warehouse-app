package com.avbook.app.entity;

import com.avbook.app.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    private String name;
    @OneToMany(mappedBy = "company")
    private List<User> employees;
    @OneToMany(mappedBy = "company")
    private List<Turbocharger> turbochargers;
    @OneToMany(mappedBy = "company")
    private List<Part> parts;
    @OneToMany(mappedBy = "company")
    private List<Client> clients;
}
