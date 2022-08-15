package com.banquemisr.Service;

import com.banquemisr.persistence.User;
import com.banquemisr.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(username);

        if(user == null)
            throw new UsernameNotFoundException("username not found");

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getDefaultGrantedAuthorities());
    }

    public Optional<User> findByUserName(String username)
    {
        Optional<User> ret = findByUserName(username);
        return ret;
    }

    public User createNewUser(User user)
    {
        if(user != null && user.getUserName() != null)
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        }
        return user;
    }

    private static List<GrantedAuthority> getDefaultGrantedAuthorities()
    {
        List<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        return grantedAuthoritiesList;
    }
}
