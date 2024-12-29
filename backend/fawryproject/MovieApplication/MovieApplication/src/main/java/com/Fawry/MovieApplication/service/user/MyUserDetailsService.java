package com.Fawry.MovieApplication.service.user;


import com.Fawry.MovieApplication.entity.User;
import com.Fawry.MovieApplication.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }

        //user.setRole(Role.valueOf("Role_"+user.getRole()));
        GrantedAuthority authoritity= new SimpleGrantedAuthority("ROLE_"+user.getRole().name());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Collections.singleton(authoritity));
    }
}
