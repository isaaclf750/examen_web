package utez.edu.mx.examen.models.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.examen.services.producto.ProductoServices;

public interface ProductoRepository extends JpaRepository <ProductoModels, Long> {

}
