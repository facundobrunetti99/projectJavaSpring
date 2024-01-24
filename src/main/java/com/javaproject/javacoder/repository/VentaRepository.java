package com.javaproject.javacoder.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaproject.javacoder.models.Ventas;
public interface VentaRepository extends JpaRepository<Ventas, Long> {  
}
