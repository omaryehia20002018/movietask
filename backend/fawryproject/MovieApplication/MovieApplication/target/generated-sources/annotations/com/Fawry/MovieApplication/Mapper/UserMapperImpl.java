package com.Fawry.MovieApplication.Mapper;

import com.Fawry.MovieApplication.dto.User.UserDto;
import com.Fawry.MovieApplication.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-29T14:18:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setRole( userDto.getRole() );

        return user;
    }
}
