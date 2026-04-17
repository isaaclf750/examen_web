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
    private long id;
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
    private ENUM_PEDIDO tipo;


}
