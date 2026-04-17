package utez.edu.mx.examen.models.producto;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class ProductoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private int Stock;

}
