package caso2_gestionEstudiantes;

public class EstudianteRegular extends Estudiante {
    private static final double MENSUALIDAD_BASE = 500.0;
    private double descuentoPorPromedio;
    
    public EstudianteRegular(String nombre, String apellido, String codigo, int edad) {
        super(nombre, apellido, codigo, edad);
        this.descuentoPorPromedio = 0.0;
    }
    
    @Override
    public double calcularMensualidad() {
        double promedio = obtenerPromedio();
        
        // Aplicar descuento por buen rendimiento académico
        if (promedio >= 17.0) {
            descuentoPorPromedio = 0.15; // 15% de descuento
        } else if (promedio >= 15.0) {
            descuentoPorPromedio = 0.10; // 10% de descuento
        } else if (promedio >= 13.0) {
            descuentoPorPromedio = 0.05; // 5% de descuento
        } else {
            descuentoPorPromedio = 0.0; // Sin descuento
        }
        
        return MENSUALIDAD_BASE * (1 - descuentoPorPromedio);
    }
    
    @Override
    public void evaluar() {
        System.out.println("=== EVALUACIÓN ESTUDIANTE REGULAR ===");
        super.evaluar();
        System.out.println("Mensualidad: S/. " + String.format("%.2f", calcularMensualidad()));
        if (descuentoPorPromedio > 0) {
            System.out.println("Descuento aplicado: " + (descuentoPorPromedio * 100) + "%");
        }
        System.out.println("=====================================\n");
    }
    
    public double getDescuentoPorPromedio() {
        return descuentoPorPromedio;
    }
}

