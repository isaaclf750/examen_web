package utez.edu.mx.examen.services.cliente;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.examen.models.cliente.ClienteModels;
import utez.edu.mx.examen.models.cliente.ClienteRepository;

@Service
public class ClienteServices {
    private ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public ClienteModels buscarPorNombre(String nombre) {
        ClienteModels cliente = clienteRepository.findByNombre(nombre);
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado: " + nombre);
        }
        return cliente;
    }
}