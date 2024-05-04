package com.example.challenge4.repository;


import com.example.challenge4.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    @Procedure(procedureName = "users_insert_data")
    void usersInsertData(String username, String email, String password);

    @Procedure(procedureName = "users_update_data")
    void usersUpdateData(UUID id, String username, String email, String password);

    @Procedure(procedureName = "users_delete_data")
    void usersDeleteData(UUID id);

    Optional<Users> findByUsername(String username);
}
