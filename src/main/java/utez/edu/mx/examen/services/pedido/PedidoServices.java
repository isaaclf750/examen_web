package utez.edu.mx.examen.services.pedido;

import org.springframework.stereotype.Service;
import utez.edu.mx.examen.models.pedido.PedidoRepository;

@Service
public class PedidoServices {
    private PedidoRepository pedidoRepository;

    public PedidoServices(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
