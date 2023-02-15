package com.avbook.app.entity;

import com.avbook.app.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FlightLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    private String acRegistration;
    @NonNull
    private String instructor;
    @NonNull
    @Column(name = "_from")
    private String from;
    @NonNull
    @Column(name = "_to")
    private String to;
    @NonNull
    private LocalDateTime takeoff;
    @NonNull
    private LocalDateTime landing;
    @NonNull
    private Integer landingQuantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
