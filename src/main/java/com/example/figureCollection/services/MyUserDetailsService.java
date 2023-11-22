package com.example.figureCollection.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.figureCollection.dao.IUserDao;
import com.example.figureCollection.model.entity.Role;
import org.springframework.security.core.userdetails.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        com.example.figureCollection.model.entity.User usuario = this.userDao.findByUsername(username).orElseThrow();

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Role rol : usuario.getListRoles()) {
            authorities.add(new SimpleGrantedAuthority(rol.getAuthority()));
        }

        return new User(username, usuario.getPassword(), usuario.getEnabled(), true, true, true,authorities);

    }


    
}
