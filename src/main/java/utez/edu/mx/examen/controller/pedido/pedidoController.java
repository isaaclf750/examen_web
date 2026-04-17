package utez.edu.mx.examen.controller.pedido;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.examen.services.pedido.PedidoServices;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin({"*"})
public class pedidoController {
    private PedidoServices pedidoServices;
    public pedidoController(PedidoServices pedidoServices) {
        this.pedidoServices = pedidoServices;
    }
}
