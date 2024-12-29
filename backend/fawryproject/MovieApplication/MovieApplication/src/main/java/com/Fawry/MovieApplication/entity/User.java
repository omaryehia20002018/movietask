package com.Fawry.MovieApplication.entity;

import com.Fawry.MovieApplication.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    @NotNull(message = "username should not be null")
    @NotEmpty(message = "username should not be empty")
    private String username;
    @Column(name = "password")
    @NotNull(message = "password should not be null")
    @NotEmpty(message = "password should not be empty")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

}
