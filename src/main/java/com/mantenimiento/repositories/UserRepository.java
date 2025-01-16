package com.mantenimiento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mantenimiento.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

	 @Query(value = "SELECT en.* FROM tb_user en WHERE en.username = :username", nativeQuery = true)
	 Usuario getUser(@Param("username") String username);


}
