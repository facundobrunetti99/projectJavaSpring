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

import com.javaproject.javacoder.models.Cliente;
import com.javaproject.javacoder.models.Ventas;
import com.javaproject.javacoder.repository.VentaRepository;

@RestController
public class VentaController {

    @Autowired VentaRepository repo;
    @GetMapping
    public String index(){
        return "Conectado";
    }

    @GetMapping("Ventas")
    public List<Ventas> getVentas(){
       return  repo.findAll();
    }
      @PostMapping("alta")
    public String post(@RequestBody Ventas venta){
        repo.save(venta);
        return "Alta Venta";
    }


    @PutMapping("modificar/{id}")
        public String update(@PathVariable Long id, @RequestBody Ventas venta){
            Ventas updateVentas = repo.findById(id).get();
            updateVentas.setTipoVenta(venta.getTipoVenta());
            updateVentas.setMonto(venta.getMonto());
            repo.save(updateVentas);
            return "Modificado";
        }

    @DeleteMapping("Eliminar/{id}")   
    public String delete(@PathVariable Long id){
        Ventas deleteVenta =repo.findById(id).get();
        repo.delete(deleteVenta);
        return "Eliminado";
    } 
    
    
  
  
    
    }
    