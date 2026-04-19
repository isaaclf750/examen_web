package utez.edu.mx.examen.models.cliente;

import jakarta.persistence.*;
import utez.edu.mx.examen.models.pedido.PedidoModels;
import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @Enumerated(EnumType.STRING)
    private ENUM_CLIENTE tipoCliente;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoModels> pedidos;

    public ClienteModels() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ENUM_CLIENTE getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(ENUM_CLIENTE tipoCliente) { this.tipoCliente = tipoCliente; }

    public List<PedidoModels> getPedidos() { return pedidos; }
    public void setPedidos(List<PedidoModels> pedidos) { this.pedidos = pedidos; }
}