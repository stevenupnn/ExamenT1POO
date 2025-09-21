package caso2_gestionEstudiantes;

import java.util.ArrayList;
import java.util.List;

public class GestionEstudiantes {
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    
    public GestionEstudiantes() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
    // Método que demuestra polimorfismo
    public void procesarEstudiantes() {
        System.out.println("=== PROCESAMIENTO POLIMÓRFICO ===\n");
        
        for (Estudiante estudiante : estudiantes) {
            // Polimorfismo: el método evaluar() se ejecuta según el tipo real del objeto
            estudiante.evaluar();
            
            // Polimorfismo: calcularMensualidad() se ejecuta según la implementación de cada subclase
            System.out.println("Cálculo de mensualidad para " + estudiante.getNombreCompleto() + 
                             ": S/. " + String.format("%.2f", estudiante.calcularMensualidad()) + "\n");
        }
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
    
    public void mostrarEstadisticas() {
        System.out.println("=== ESTADÍSTICAS GENERALES ===");
        System.out.println("Total de estudiantes registrados: " + Estudiante.getTotalEstudiantes());
        System.out.println("Total de cursos disponibles: " + Curso.getTotalCursos());
        System.out.println("===============================\n");
    }
    
    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }
    
    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }
}
