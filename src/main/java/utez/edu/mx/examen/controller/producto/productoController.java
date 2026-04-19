package utez.edu.mx.examen.controller.producto;

import org.springframework.web.bind.annotation.*;
import utez.edu.mx.examen.models.producto.ProductoModels;
import utez.edu.mx.examen.services.producto.ProductoServices;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin({"*"})
public class productoController {
    private ProductoServices productoServices;

    public productoController(ProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    @GetMapping("/buscar")
    public ProductoModels buscarPorNombre(@RequestParam String nombre) {
        return productoServices.buscarPorNombre(nombre);
    }

    @PutMapping("/actualizar-stock")
    public String actualizarStock(@RequestParam Long id, @RequestParam Integer nuevoStock) {
        productoServices.actualizarStock(id, nuevoStock);
        return "Stock actualizado correctamente";
    }
}