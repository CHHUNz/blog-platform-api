package com.kosign.dev.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    @Query("select u from Users u order by u.username asc")
    List<Users> findAllUserOrderByUsername();

    @Query("select u from Users u where u.id=?1")
    Optional<Users> findUsersById(UUID id);


    @Query("delete from Users where id = ?1")
    Optional<Users> deleteUsersById(UUID id);



}
