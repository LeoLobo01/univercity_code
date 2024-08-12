import java.util.List;
import java.util.ArrayList;

public class Subject {
    private int id;
    private String nombre;
    private String descripcion;
    private Teacher teacher;
    private List<Estudiante> estudiantes;
    private List<Matricula> matriculas;
    private int credits;

    public Subject(int id, String nombre, String descripcion, Teacher teacher, int credits) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.teacher = teacher;
        this.estudiantes = new ArrayList<>();
        this.matriculas = new ArrayList<>();
        this.credits= credits;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Teacher getDocente() { return teacher; }
    public void setDocente(Teacher teacher) { this.teacher = teacher; }

    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }

    public List<Matricula> getMatriculas() { return matriculas; }
    public void setMatriculas(List<Matricula> matriculas) { this.matriculas = matriculas; }

    // Métodos
    public void agregarMaterial() {
        System.out.println("Material agregado para la asignatura " + nombre);
    }

    public void asignarDocente(Teacher teacher) {
        this.teacher = teacher;
        System.out.println("Docente " + teacher.getNombre() + " asignado a " + nombre);
    }
}