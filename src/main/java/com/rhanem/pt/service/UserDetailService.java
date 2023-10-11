package com.rhanem.pt.service;

import com.rhanem.pt.repository.UserRepository;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {

    UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow( () -> {
            throw new UsernameNotFoundException("user not found");
        });
    }
}
