package com.ecommer.springbootapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class Profile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
