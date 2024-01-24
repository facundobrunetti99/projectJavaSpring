package com.javaproject.javacoder.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.javacoder.models.Producto;
import com.javaproject.javacoder.repository.ProductoRepository;

@RestController
public class ProductoController {

    @Autowired ProductoRepository repo;
    @GetMapping
    public String index(){
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<Producto> getProducto(){
       return repo.findAll();
    }

    @PostMapping("alta")
    public String post(@RequestBody Producto producto){
        repo.save(producto);
        return "resuelto";
    }
    
    @PutMapping("modificar/{id}")
        public String update(@PathVariable Long id, @RequestBody Producto producto){
            Producto updateProducto = repo.findById(id).get();
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setPrecio(producto.getPrecio());
            updateProducto.setCantidad(producto.getCantidad());
            repo.save(updateProducto);
            return "Modificado";
        }

    @DeleteMapping("Eliminar/{id}")   
    public String delete(@PathVariable Long id){
        Producto deleteProducto =repo.findById(id).get();
        repo.delete(deleteProducto);
        return "Eliminado";
    } 
    
    }
    

