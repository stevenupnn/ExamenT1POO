package caso2_gestionEstudiantes;

public class Curso {
    private String nombre;
    private String codigo;
    private int creditos;
    private String profesor;
    private static int totalCursos = 0; // Atributo estático
    
    public Curso(String nombre, String codigo, int creditos, String profesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.profesor = profesor;
        totalCursos++;
    }
    
    // Método estático
    public static int getTotalCursos() {
        return totalCursos;
    }
    
    // Método no estático para mostrar información del curso
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL CURSO ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Créditos: " + creditos);
        System.out.println("Profesor: " + profesor);
        System.out.println("=============================\n");
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public int getCreditos() {
        return creditos;
    }
    
    public String getProfesor() {
        return profesor;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - " + creditos + " créditos";
    }
}
