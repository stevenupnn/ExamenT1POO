package caso2_gestionEstudiantes;

public abstract class Estudiante implements Evaluable {
    protected String nombre;
    protected String apellido;
    protected String codigo;
    protected int edad;
    protected double[] notas;
    protected static int totalEstudiantes = 0; // Atributo estático
    
    // Constructor
    public Estudiante(String nombre, String apellido, String codigo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.edad = edad;
        this.notas = new double[5]; // Array para 5 notas
        totalEstudiantes++; // Incrementar contador estático
    }
    
    // Método abstracto que debe ser implementado por las subclases
    public abstract double calcularMensualidad();
    
    // Método estático para obtener el total de estudiantes
    public static int getTotalEstudiantes() {
        return totalEstudiantes;
    }
    
    // Implementación de la interfaz Evaluable
    @Override
    public void evaluar() {
        System.out.println("Evaluando a " + getNombreCompleto());
        System.out.println("Promedio actual: " + obtenerPromedio());
        
        if (obtenerPromedio() >= 14.0) {
            System.out.println("Estado: APROBADO ✓");
        } else if (obtenerPromedio() >= 10.5) {
            System.out.println("Estado: EN OBSERVACIÓN ⚠");
        } else {
            System.out.println("Estado: DESAPROBADO ✗");
        }
    }
    
    @Override
    public double obtenerPromedio() {
        double suma = 0;
        int notasValidas = 0;
        
        for (double nota : notas) {
            if (nota > 0) { // Solo contar notas asignadas
                suma += nota;
                notasValidas++;
            }
        }
        
        return notasValidas > 0 ? suma / notasValidas : 0.0;
    }
    
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    public void agregarNota(int posicion, double nota) {
        if (posicion >= 0 && posicion < notas.length && nota >= 0 && nota <= 20) {
            notas[posicion] = nota;
        }
    }
    
    public double[] getNotas() {
        return notas.clone(); // Retorna una copia para proteger el array
    }
    
    // Método toString común
    @Override
    public String toString() {
        return getNombreCompleto() + " (Código: " + codigo + ")";
    }
}
