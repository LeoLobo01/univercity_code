import java.util.Date;

public class Matricula {
    private int id;
    private Date fecha;
    private Estudiante estudiante;
    private Subject subject;

    public Matricula(int id, Date fecha, Estudiante estudiante, Subject subject) {
        this.id = id;
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.subject = subject;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Subject getAsignatura() { return subject; }
    public void setAsignatura(Subject subject) { this.subject = subject; }

    // Métodos
    public void realizarMatricula() {
        System.out.println("Matrícula realizada para " + estudiante.getNombre() + " en " + subject.getNombre());
    }

    public void cancelarMatricula() {
        System.out.println("Matrícula cancelada para " + estudiante.getNombre() + " en " + subject.getNombre());
    }
}
