package com.javaproject.javacoder.models;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venta",cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

   

    @OneToOne(mappedBy = "venta")
    private Cliente cliente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoVenta() {
        return TipoVenta;
    }

    public void setTipoVenta(String TipoVenta) {
        this.TipoVenta = TipoVenta;
       
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }


    @Column(name="TipoVenta")
    private String TipoVenta;
    @Column(name="Monto")
    private Float monto;


  

}

