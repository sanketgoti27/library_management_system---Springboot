package com.example.security.service.implService;


import com.example.security.entity.Patron;
import com.example.security.repository.PatronRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private PatronRepository patronRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);
    private String TAG_NAME = "JwtUserDetailsService";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info(TAG_NAME + " :: inside loadUserByUsername : username :: " + username);

         Patron patron= this.patronRepository.findByName(username);
        if(patron != null){
            GrantedAuthority authority = new SimpleGrantedAuthority(patron.getRole().getRoleName());
            List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
            authorityList.add(authority);
            return new org.springframework.security.core.userdetails.User(patron.getName(), patron.getPassword(), authorityList);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}