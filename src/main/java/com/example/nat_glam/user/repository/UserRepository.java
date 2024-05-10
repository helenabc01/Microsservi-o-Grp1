package com.example.nat_glam.user.repository;

import com.example.nat_glam.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u.trusted FROM clientes u WHERE u.cpf = :cpf")
    Boolean findTrustedByCpf(@Param("cpf") String cpf);

    @Query("SELECT u.cpf FROM clientes u WHERE u.cpf = :cpf")
    String findUserByCpf(@Param("cpf") String cpf);


    @Modifying
    @Query("UPDATE clientes SET trusted = :value WHERE cpf = :cpf")
    void updateByCpf(@Param("cpf") String cpf, @Param("value") Boolean value);
}