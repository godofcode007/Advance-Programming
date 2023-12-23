package com.example.univeristy4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.univeristy4.Entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
