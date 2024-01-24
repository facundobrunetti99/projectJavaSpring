package com.javaproject.javacoder.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javaproject.javacoder.models.Cliente;
import com.javaproject.javacoder.repository.ClienteRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ClienteController {

    @Autowired 
    private ClienteRepository repo;

    @GetMapping("clientes")
    public List<Cliente> getClientes(){
       return repo.findAll();
    }

    @PostMapping("cliente/nuevo")
    public String post(@RequestBody Cliente cliente){
        repo.save(cliente);
        return "resuelto";
    }
    
    @PutMapping("cliente/modificar/{id}")
        public String update(@PathVariable Long id, @RequestBody Cliente cliente){
            Cliente updateCliente = repo.findById(id).get();
            updateCliente.setNombre(cliente.getNombre());
            updateCliente.setCorreo(cliente.getCorreo());
            repo.save(updateCliente);
            return "Modificado";
        }

    @DeleteMapping("cliente/eliminar/{id}")   
    public String delete(@PathVariable Long id){
        Cliente deleteCliente =repo.findById(id).get();
        repo.delete(deleteCliente);
        return "Eliminado";
    } 
    
    }
    

