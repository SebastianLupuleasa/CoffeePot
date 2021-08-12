package com.lupuleasa.coffee.security;

import com.lupuleasa.coffee.models.Customer;
import com.lupuleasa.coffee.repositories.CustomerRepository;
import com.lupuleasa.coffee.security.MyCustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyCustomerDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Customer> user= Optional.ofNullable(userRepository.findByUserName(userName));

        user.orElseThrow(() -> new UsernameNotFoundException("Not fount: "+userName));

        return user.map(MyCustomerDetails::new).get();
    }

}
