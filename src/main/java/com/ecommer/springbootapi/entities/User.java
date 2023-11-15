package com.ecommer.springbootapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name"}), @UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> cartItems;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    @OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderProducts> orderProducts;

    @OneToOne(mappedBy = "user")
    private Profile user_profile;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
