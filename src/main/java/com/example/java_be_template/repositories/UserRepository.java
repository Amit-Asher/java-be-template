package com.example.java_be_template.repositories;

import com.example.java_be_template.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value =
            "SELECT * FROM users c " +
                    "WHERE " +
                    "(:name = ''  OR c.name = :name )", nativeQuery = true)
    List<User> getByCustomName(@Param("name") String name);
}
