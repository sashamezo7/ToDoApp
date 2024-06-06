package org.example.maxpetapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Sarcina")
public class SarcinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private int id;

    @ManyToOne
    @JoinColumn(name = "username")
    @Getter
    @Setter
    private UsersEntity user;

    @Column(name = "cerinta")
    @Getter
    @Setter
    private String cerinta;

    @Column(name = "activ")
    @Getter
    @Setter
    private int activ;
}
