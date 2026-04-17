package utez.edu.mx.examen.models.cliente;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @Enumerated(EnumType.STRING)
    private ENUM_CLIENTE tipoCliente;



}





