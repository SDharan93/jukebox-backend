package com.dropmusic.jukebox.dao;

import com.dropmusic.jukebox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * Find a user by email
     *
     * @param email The user's email.
     * @return user A user that is associated with the given email or null.
     */
    User findOneByEmail(String email);
}
