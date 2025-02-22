package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import med.voll.api.domain.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo = true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if (datosActualizarMedico.nombre() != null)
            this.nombre = datosActualizarMedico.nombre();
        if (datosActualizarMedico.documento() != null)
            this.documento = datosActualizarMedico.documento();
        if (datosActualizarMedico.direccion() != null)
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
    }

    public void desactivarMedico() {
        this.activo = false;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public boolean isActivo() {
        return activo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Medico() {
    }

    public Medico(Long id, String nombre, String email, String telefono, String documento, boolean activo, Especialidad especialidad, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.documento = documento;
        this.activo = activo;
        this.especialidad = especialidad;
        this.direccion = direccion;
    }
}
