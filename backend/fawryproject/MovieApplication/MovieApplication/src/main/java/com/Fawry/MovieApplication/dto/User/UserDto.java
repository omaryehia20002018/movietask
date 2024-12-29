package com.Fawry.MovieApplication.dto.User;

import com.Fawry.MovieApplication.entity.enums.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private Role role;
}
