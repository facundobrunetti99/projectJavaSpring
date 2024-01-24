package com.javaproject.javacoder.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaproject.javacoder.models.Producto;
public interface ProductoRepository extends JpaRepository<Producto, Long> { 
}
