import java.util.*;

public class Univercity {
    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();
    private static List<Matricula> matriculas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    agregarDocente();
                    break;
                case 3:
                    agregarAsignatura();
                    break;
                case 4:
                    agregarAula();
                    break;
                case 5:
                    realizarMatricula();
                    break;
                case 6:
                    mostrarEstudiantes();
                    break;
                case 7:
                    mostrarDocentes();
                    break;
                case 8:
                    mostrarAsignaturas();
                    break;
                case 9:
                    mostrarAulas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
//Menu
    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Agregar Estudiante");
        System.out.println("2. Agregar Docente");
        System.out.println("3. Agregar Asignatura");
        System.out.println("4. Agregar Aula");
        System.out.println("5. Realizar Matrícula");
        System.out.println("6. Mostrar Estudiantes");
        System.out.println("7. Mostrar Docentes");
        System.out.println("8. Mostrar Asignaturas");
        System.out.println("9. Mostrar Aulas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
//opcciones Metodos
    private static void agregarEstudiante() {
        System.out.print("Ingrese ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del estudiante: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese edad del estudiante: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese email del estudiante: ");
        String email = scanner.nextLine();

        Estudiante estudiante = new Estudiante(id, nombre, apellido, edad, email);
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado exitosamente.");
    }

    private static void agregarDocente() {
        System.out.print("Ingrese ID del docente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del docente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del docente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese email del docente: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese especialidad del docente: ");
        String especialidad = scanner.nextLine();

        Teacher teacher = new Teacher(id, nombre, apellido, email, especialidad);
        teachers.add(teacher);
        System.out.println("Docente agregado exitosamente.");
    }

    private static void agregarAsignatura() {
        System.out.print("Ingrese ID de la asignatura: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre de la asignatura: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese descripción de la asignatura: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese ID del docente para la asignatura: ");
        int idDocente = scanner.nextInt();
        scanner.nextLine();
        int credits = scanner.nextInt();
        scanner.nextLine();

        Teacher teacher = buscarDocentePorId(idDocente);
        if (teacher == null) {
            System.out.println("Docente no encontrado.");
            return;
        }

        Subject subject = new Subject(id, nombre, descripcion, teacher, credits );
        subjects.add(subject);
        teacher.getAsignaturas().add(subject);
        System.out.println("Asignatura agregada exitosamente.");
    }

    private static void agregarAula() {
        System.out.print("Ingrese ID del aula: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese número del aula: ");
        String numero = scanner.nextLine();
        System.out.print("Ingrese capacidad del aula: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        Room room = new Room(id, numero, capacidad);
        rooms.add(room);
        System.out.println("Aula agregada exitosamente.");
    }

    private static void realizarMatricula() {
        System.out.print("Ingrese ID del estudiante: ");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese ID de la asignatura: ");
        int idAsignatura = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = buscarEstudiantePorId(idEstudiante);
        Subject subject = buscarAsignaturaPorId(idAsignatura);

        if (estudiante == null || subject == null) {
            System.out.println("Estudiante o asignatura no encontrados.");
            return;
        }

        Matricula matricula = new Matricula(matriculas.size() + 1, new Date(), estudiante, subject);
        matriculas.add(matricula);
        estudiante.getMatriculas().add(matricula);
        subject.getMatriculas().add(matricula);
        estudiante.inscribirse(subject);
        System.out.println("Matrícula realizada exitosamente.");
    }

    private static void mostrarEstudiantes() {
        System.out.println("\n--- Lista de Estudiantes ---");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    private static void mostrarDocentes() {
        System.out.println("\n--- Lista de Docentes ---");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    private static void mostrarAsignaturas() {
        System.out.println("\n--- Lista de Asignaturas ---");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    private static void mostrarAulas() {
        System.out.println("\n--- Lista de Aulas ---");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private static Estudiante buscarEstudiantePorId(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    private static Teacher buscarDocentePorId(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private static Subject buscarAsignaturaPorId(int id) {
        for (Subject subject : subjects) {
            if (subject.getId() == id) {
                return subject;
            }
        }
        return null;
    }
}
