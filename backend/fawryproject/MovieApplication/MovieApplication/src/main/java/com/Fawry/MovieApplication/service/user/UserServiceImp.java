package com.Fawry.MovieApplication.service.user;

import com.Fawry.MovieApplication.Mapper.UserMapper;
import com.Fawry.MovieApplication.dto.User.UserDto;
import com.Fawry.MovieApplication.entity.User;
import com.Fawry.MovieApplication.repository.user.UserRepository;
import com.Fawry.MovieApplication.service.jwt.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepository UserRepo;
    @Autowired
    private UserMapper userMapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public User register(UserDto userDto) {
        User user=userMapper.toUser(userDto);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(user.getRole());
        UserRepo.save(user);
        return user;
    }
    @Override
    public String verify(UserDto userDto) {
        User user=userMapper.toUser(userDto);
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
           User theuser= UserRepo.findByUsername(user.getUsername());
            return jwtService.generateToken(user.getUsername(),theuser);
        } else {
            return "fail";
        }
    }
}
