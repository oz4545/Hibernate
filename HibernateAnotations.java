import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta clase es una entidad de Hibernate
@Table(name = "usuarios") // Mapea a la tabla "usuarios" en la base de datos
public class HibernateAnotations {
    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente valores para la clave primaria
    @Column(name = "id") // Mapea al campo "id" en la tabla
    private int id;

    @Column(name = "nombre") // Mapea al campo "nombre" en la tabla
    private String nombre;

    // Constructor vacío requerido por Hibernate
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + "]";
    }
}
