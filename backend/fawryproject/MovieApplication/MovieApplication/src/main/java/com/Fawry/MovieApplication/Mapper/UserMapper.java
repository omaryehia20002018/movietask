package com.Fawry.MovieApplication.Mapper;

import com.Fawry.MovieApplication.dto.User.UserDto;
import com.Fawry.MovieApplication.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);
}
