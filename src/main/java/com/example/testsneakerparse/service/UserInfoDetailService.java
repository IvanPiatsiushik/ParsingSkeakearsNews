package com.example.testsneakerparse.service;

import com.example.testsneakerparse.config.UserInfoUserDetails;
import com.example.testsneakerparse.entity.UserInfo;
import com.example.testsneakerparse.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserInfoDetailService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Optional<UserInfo> userInfo = repository.findByName(username);

       return userInfo.map(UserInfoUserDetails::new)
               .orElseThrow(()->new UsernameNotFoundException("user no found"+username));

    }
}
