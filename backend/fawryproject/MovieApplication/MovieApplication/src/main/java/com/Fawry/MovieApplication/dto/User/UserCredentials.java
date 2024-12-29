package com.Fawry.MovieApplication.dto.User;

import com.Fawry.MovieApplication.entity.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {
    private String token;
    @Enumerated(EnumType.STRING)
    private Role role;
}
