package utez.edu.mx.examen.services.producto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.examen.models.producto.ProductoModels;
import utez.edu.mx.examen.models.producto.ProductoRepository;

@Service
public class ProductoServices {
    private ProductoRepository productoRepository;

    public ProductoServices(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional(readOnly = true)
    public ProductoModels buscarPorNombre(String nombre) {
        ProductoModels producto = productoRepository.findByNombre(nombre);
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado: " + nombre);
        }
        return producto;
    }

    @Transactional(rollbackFor = Exception.class)
    public void actualizarStock(Long productoId, int nuevoStock) {
        ProductoModels producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(nuevoStock);
        productoRepository.save(producto);
    }
}