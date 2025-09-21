package caso2_gestionEstudiantes;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE ESTUDIANTES ===\n");
        
        // Crear instancia del sistema
        GestionEstudiantes sistema = new GestionEstudiantes();
        
        // Crear cursos
        Curso curso1 = new Curso("Programación Orientada a Objetos", "POO001", 4, "Prof. García");
        Curso curso2 = new Curso("Base de Datos", "BD002", 3, "Prof. López");
        Curso curso3 = new Curso("Algoritmos", "ALG003", 4, "Prof. Martínez");
        
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);
        sistema.agregarCurso(curso3);
        
        // Crear estudiantes regulares
        EstudianteRegular estudiante1 = new EstudianteRegular("Ana", "Rodríguez", "E001", 20);
        EstudianteRegular estudiante2 = new EstudianteRegular("Carlos", "Mendoza", "E002", 19);
        
        // Crear estudiantes becados
        EstudianteBecado estudiante3 = new EstudianteBecado("María", "Torres", "E003", 21, 50, "Beca de Excelencia");
        EstudianteBecado estudiante4 = new EstudianteBecado("Luis", "Vargas", "E004", 20, 75, "Beca Socioeconómica");
        
        // Agregar estudiantes al sistema
        sistema.agregarEstudiante(estudiante1);
        sistema.agregarEstudiante(estudiante2);
        sistema.agregarEstudiante(estudiante3);
        sistema.agregarEstudiante(estudiante4);
        
        // Asignar notas a los estudiantes
        System.out.println("--- Asignando notas ---");
        estudiante1.agregarNota(0, 16.5);
        estudiante1.agregarNota(1, 17.0);
        estudiante1.agregarNota(2, 15.5);
        
        estudiante2.agregarNota(0, 12.0);
        estudiante2.agregarNota(1, 13.5);
        estudiante2.agregarNota(2, 11.8);
        
        estudiante3.agregarNota(0, 18.0);
        estudiante3.agregarNota(1, 17.5);
        estudiante3.agregarNota(2, 19.0);
        
        estudiante4.agregarNota(0, 14.5);
        estudiante4.agregarNota(1, 15.0);
        estudiante4.agregarNota(2, 13.8);
        
        // Mostrar información de cursos
        System.out.println("--- Información de Cursos ---");
        for (Curso curso : sistema.getCursos()) {
            curso.mostrarInformacion();
        }
        
        // Demostrar polimorfismo y uso de interfaces
        sistema.procesarEstudiantes();
        
        // Mostrar estadísticas usando métodos estáticos
        sistema.mostrarEstadisticas();
        
        // Demostrar diferencia entre métodos estáticos y no estáticos
        System.out.println("--- Ejemplo: Métodos Estáticos vs No Estáticos ---");
        System.out.println("Método estático - Total estudiantes: " + Estudiante.getTotalEstudiantes());
        System.out.println("Método estático - Total cursos: " + Curso.getTotalCursos());
        System.out.println("Método no estático - Promedio de " + estudiante1.getNombreCompleto() + 
                         ": " + estudiante1.obtenerPromedio());
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}
