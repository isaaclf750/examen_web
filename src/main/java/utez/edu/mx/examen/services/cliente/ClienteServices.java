package utez.edu.mx.examen.services.cliente;

import org.springframework.stereotype.Service;
import utez.edu.mx.examen.models.cliente.ClienteRepository;

@Service
public class ClienteServices {
    private ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
}


