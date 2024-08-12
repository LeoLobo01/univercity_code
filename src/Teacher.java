import java.util.List;
import java.util.ArrayList;

public class Teacher {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;
    private List<Subject> subjects;

    public Teacher(int id, String nombre, String apellido, String email, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.especialidad = especialidad;
        this.subjects = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public List<Subject> getAsignaturas() { return subjects; }
    public void setAsignaturas(List<Subject> subjects) { this.subjects = subjects; }

    // Métodos
    public void impartirClase() {
        System.out.println(nombre + " está impartiendo una clase.");
    }

    public void evaluarEstudiante(Estudiante estudiante) {
        System.out.println(nombre + " está evaluando a " + estudiante.getNombre());
    }
}