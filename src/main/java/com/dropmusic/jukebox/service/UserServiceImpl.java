package com.dropmusic.jukebox.service;

import com.dropmusic.jukebox.dao.UserDao;
import com.dropmusic.jukebox.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Override
    public User findByEmail(String email) {
        return userDao.findOneByEmail(email);
    }

    /**
     * Finds a user from database that matches the provided email.
     *
     * @param username The username of the user. In this application
     *                 the email will represent the username.
     * @return user A user associated with the given email.
     * @throws UsernameNotFoundException If no user is found, UsernameNotFoundException will be thrown.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findOneByEmail(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
