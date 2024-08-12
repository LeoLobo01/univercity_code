import java.util.List;
import java.util.ArrayList;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private List<Subject> subjects;
    private List<Matricula> matriculas;

    public Estudiante(int id, String nombre, String apellido, int edad, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.subjects = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Subject> getAsignaturas() { return subjects; }
    public void setAsignaturas(List<Subject> subjects) { this.subjects = subjects; }

    public List<Matricula> getMatriculas() { return matriculas; }
    public void setMatriculas(List<Matricula> matriculas) { this.matriculas = matriculas; }

    // Métodos
    public void inscribirse(Subject subject) {
        this.subjects.add(subject);
        subject.getEstudiantes().add(this);
        System.out.println(nombre + " se ha inscrito en " + subject.getNombre());
    }

    public void consultarCalificaciones() {
        System.out.println(nombre + " está consultando sus calificaciones.");
    }
}