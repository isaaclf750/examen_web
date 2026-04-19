package utez.edu.mx.examen.controller.cliente;

import org.springframework.web.bind.annotation.*;
import utez.edu.mx.examen.models.cliente.ClienteModels;
import utez.edu.mx.examen.services.cliente.ClienteServices;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin({"*"})
public class clienteController {
    private ClienteServices clienteServices;

    public clienteController(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @GetMapping("/buscar")
    public ClienteModels buscarPorNombre(@RequestParam String nombre) {
        return clienteServices.buscarPorNombre(nombre);
    }
}