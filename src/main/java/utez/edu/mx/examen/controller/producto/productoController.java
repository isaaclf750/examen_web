package utez.edu.mx.examen.controller.producto;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.examen.services.producto.ProductoServices;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin({"*"})
public class productoController {
    private ProductoServices productoServices;

    public productoController(ProductoServices productoServices) {
        this.productoServices = productoServices;

    }
}
