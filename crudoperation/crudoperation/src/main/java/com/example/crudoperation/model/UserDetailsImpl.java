package com.example.crudoperation.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails{
	
	private MyUser user;
	
	public UserDetailsImpl(MyUser user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority>getAuthorities
	(){
		return user.getRoles().stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
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
        return true; // Set according to your application's requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Set according to your application's requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Set according to your application's requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Set according to your application's requirements
    }
}
