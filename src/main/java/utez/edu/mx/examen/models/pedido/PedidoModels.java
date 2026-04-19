package utez.edu.mx.examen.models.pedido;

import jakarta.persistence.*;
import utez.edu.mx.examen.models.cliente.ClienteModels;
import utez.edu.mx.examen.models.producto.ProductoModels;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class PedidoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModels cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoModels producto;

    private int cantidad;
    private Double total;

    @Enumerated(EnumType.STRING)
    private ENUM_PEDIDO estado;

    public PedidoModels() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public ClienteModels getCliente() { return cliente; }
    public void setCliente(ClienteModels cliente) { this.cliente = cliente; }

    public ProductoModels getProducto() { return producto; }
    public void setProducto(ProductoModels producto) { this.producto = producto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public ENUM_PEDIDO getEstado() { return estado; }
    public void setEstado(ENUM_PEDIDO estado) { this.estado = estado; }
}