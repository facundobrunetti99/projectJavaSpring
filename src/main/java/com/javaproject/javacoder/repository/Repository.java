package com.javaproject.javacoder.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaproject.javacoder.models.Cliente;

public interface Repository extends JpaRepository<Cliente, Long> {
    
}
