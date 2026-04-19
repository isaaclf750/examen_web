package utez.edu.mx.examen.models.producto;

import jakarta.persistence.*;
import utez.edu.mx.examen.models.pedido.PedidoModels;
import java.util.List;

@Entity
@Table(name = "producto")
public class ProductoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private int stock;

    @OneToMany(mappedBy = "producto")
    private List<PedidoModels> pedidos;

    public ProductoModels() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public List<PedidoModels> getPedidos() { return pedidos; }
    public void setPedidos(List<PedidoModels> pedidos) { this.pedidos = pedidos; }
}