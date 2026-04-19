package utez.edu.mx.examen.services.pedido;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.examen.models.cliente.ClienteModels;
import utez.edu.mx.examen.models.cliente.ClienteRepository;
import utez.edu.mx.examen.models.pedido.ENUM_PEDIDO;
import utez.edu.mx.examen.models.pedido.PedidoModels;
import utez.edu.mx.examen.models.pedido.PedidoRepository;
import utez.edu.mx.examen.models.producto.ProductoModels;
import utez.edu.mx.examen.models.producto.ProductoRepository;
import utez.edu.mx.examen.models.cliente.ENUM_CLIENTE;
import java.time.LocalDate;

@Service
public class PedidoServices {
    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private ProductoRepository productoRepository;

    public PedidoServices(PedidoRepository pedidoRepository,
                          ClienteRepository clienteRepository,
                          ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public PedidoModels crearPedido(String nombreCliente, String nombreProducto, int cantidad) {
        // 1. Buscar cliente
        ClienteModels cliente = clienteRepository.findByNombre(nombreCliente);
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado: " + nombreCliente);
        }

        // 2. Buscar producto
        ProductoModels producto = productoRepository.findByNombre(nombreProducto);
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado: " + nombreProducto);
        }

        // 3. Validar stock
        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente. Stock disponible: " + producto.getStock());
        }

        // 4. Calcular total (precio * cantidad)
        double subtotal = producto.getPrecio() * cantidad;
        double total = subtotal;

        // 5. Aplicar descuento si es PREMIUM (10%)
        if (cliente.getTipoCliente() == ENUM_CLIENTE.PREMIUM) {
            total = subtotal * 0.10;
        }

        // 6. Validar monto y asignar estado
        ENUM_PEDIDO estado;
        if (total > 5000) {
            estado = ENUM_PEDIDO.PENDIENTE;
        } else {
            estado = ENUM_PEDIDO.APROBADO;
        }

        // 7. Crear pedido
        PedidoModels pedido = new PedidoModels();
        pedido.setFecha(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setProducto(producto);
        pedido.setCantidad(cantidad);
        pedido.setTotal(total);
        pedido.setEstado(estado);

        // 8. Actualizar stock
        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);

        return pedidoRepository.save(pedido);
    }

    @Transactional(rollbackFor = Exception.class)
    public PedidoModels aprobarPedidoPendiente(Long pedidoId) {
        PedidoModels pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if (pedido.getEstado() != ENUM_PEDIDO.PENDIENTE) {
            throw new RuntimeException("Solo se pueden aprobar pedidos en estado PENDIENTE");
        }

        pedido.setEstado(ENUM_PEDIDO.APROBADO);
        return pedidoRepository.save(pedido);
    }
}