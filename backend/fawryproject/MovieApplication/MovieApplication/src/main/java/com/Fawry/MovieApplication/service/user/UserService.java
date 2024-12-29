package com.Fawry.MovieApplication.service.user;

import com.Fawry.MovieApplication.dto.User.UserDto;
import com.Fawry.MovieApplication.entity.User;

public interface UserService {
    public User register(UserDto userDto);
    public String verify(UserDto userDto);
}
