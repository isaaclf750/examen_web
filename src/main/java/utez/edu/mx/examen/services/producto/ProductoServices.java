package utez.edu.mx.examen.services.producto;

import org.springframework.stereotype.Service;
import utez.edu.mx.examen.models.producto.ProductoRepository;

@Service
public class ProductoServices {
    private ProductoRepository productoRepository;

    public ProductoServices(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
}
