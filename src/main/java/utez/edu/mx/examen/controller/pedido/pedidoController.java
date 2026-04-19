package utez.edu.mx.examen.controller.pedido;

import org.springframework.web.bind.annotation.*;
import utez.edu.mx.examen.models.pedido.PedidoModels;
import utez.edu.mx.examen.services.pedido.PedidoServices;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin({"*"})
public class pedidoController {
    private PedidoServices pedidoServices;

    public pedidoController(PedidoServices pedidoServices) {
        this.pedidoServices = pedidoServices;
    }

    @PostMapping("/crear")
    public PedidoModels crearPedido(@RequestParam String nombreCliente,
                                    @RequestParam String nombreProducto,
                                    @RequestParam int cantidad) {
        return pedidoServices.crearPedido(nombreCliente, nombreProducto, cantidad);
    }

    @PutMapping("/aprobar/{id}")
    public PedidoModels aprobarPedido(@PathVariable Long id) {
        return pedidoServices.aprobarPedidoPendiente(id);
    }
}