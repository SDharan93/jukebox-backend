package com.dropmusic.jukebox.service;

import com.dropmusic.jukebox.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService
{
    User findByEmail(String email);
}
