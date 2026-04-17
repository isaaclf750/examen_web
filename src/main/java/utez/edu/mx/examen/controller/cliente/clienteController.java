package utez.edu.mx.examen.controller.cliente;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.examen.services.cliente.ClienteServices;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin({"*"})
public class clienteController {
    private ClienteServices clienteServices;

    public clienteController(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }
}
