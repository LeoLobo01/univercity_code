public class Room {
    private int id;
    private String numero;
    private int capacidad;

    public Room(int id, String numero, int capacidad) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    // Métodos
    public void asignar() {
        System.out.println("Aula " + numero + " asignada.");
    }

    public void liberar() {
        System.out.println("Aula " + numero + " liberada.");
    }
}
