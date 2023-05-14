package com.pwr.awt.librarysystem.security;

import com.pwr.awt.librarysystem.entity.LibraryUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final LibraryUser user;

    public UserDetailsImpl(LibraryUser user) {
        this.user = user;
    }

    public long getId(){
        return user.getUserId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole() == null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
