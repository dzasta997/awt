package com.pwr.awt.librarysystem.security;

import com.pwr.awt.librarysystem.entity.LibraryUser;
import com.pwr.awt.librarysystem.entity.UserInfo;
import com.pwr.awt.librarysystem.repository.LibraryUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final LibraryUserRepository libraryUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImpl(LibraryUserRepository libraryUserRepository, PasswordEncoder passwordEncoder) {
        this.libraryUserRepository = libraryUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LibraryUser user = libraryUserRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(user);
    }

    @PostConstruct
    public void init() {
        initUser("admin", "pass", Role.ADMIN);
        initUser("customer", "pass", Role.CUSTOMER);
        initUser("employee", "pass", Role.EMPLOYEE);
    }

    private void initUser(String username, String password, Role role) {
        if (!libraryUserRepository.existsByUsername(username)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setFirstName("Andrew");
            userInfo.setLastName("Bernard");
            LibraryUser user = new LibraryUser();
            user.setUserInfo(userInfo);
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(role);

            libraryUserRepository.save(user);
        }
    }
}
