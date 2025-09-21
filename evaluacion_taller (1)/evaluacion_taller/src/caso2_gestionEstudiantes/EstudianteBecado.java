package caso2_gestionEstudiantes;

public class EstudianteBecado extends Estudiante {
    private static final double MENSUALIDAD_BASE = 500.0;
    private double porcentajeBeca;
    private String tipoBeca;
    
    public EstudianteBecado(String nombre, String apellido, String codigo, int edad, 
                           double porcentajeBeca, String tipoBeca) {
        super(nombre, apellido, codigo, edad);
        this.porcentajeBeca = porcentajeBeca;
        this.tipoBeca = tipoBeca;
    }
    
    @Override
    public double calcularMensualidad() {
        // La beca reduce la mensualidad según el porcentaje
        double descuentoBeca = MENSUALIDAD_BASE * (porcentajeBeca / 100);
        double mensualidadFinal = MENSUALIDAD_BASE - descuentoBeca;
        
        // Si tiene muy buen rendimiento, aplicar descuento adicional
        double promedio = obtenerPromedio();
        if (promedio >= 16.0) {
            mensualidadFinal *= 0.95; // 5% adicional por excelencia académica
        }
        
        return Math.max(mensualidadFinal, 0); // Nunca menor que 0
    }
    
    @Override
    public void evaluar() {
        System.out.println("=== EVALUACIÓN ESTUDIANTE BECADO ===");
        super.evaluar();
        System.out.println("Tipo de beca: " + tipoBeca);
        System.out.println("Porcentaje de beca: " + porcentajeBeca + "%");
        System.out.println("Mensualidad: S/. " + String.format("%.2f", calcularMensualidad()));
        
        if (obtenerPromedio() < 13.0) {
            System.out.println("⚠ ADVERTENCIA: Promedio bajo puede afectar la beca");
        }
        System.out.println("====================================\n");
    }
    
    public double getPorcentajeBeca() {
        return porcentajeBeca;
    }
    
    public String getTipoBeca() {
        return tipoBeca;
    }
    
    public void setPorcentajeBeca(double porcentajeBeca) {
        if (porcentajeBeca >= 0 && porcentajeBeca <= 100) {
            this.porcentajeBeca = porcentajeBeca;
        }
    }
}