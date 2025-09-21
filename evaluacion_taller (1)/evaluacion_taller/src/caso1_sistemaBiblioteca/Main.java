package caso1_sistemaBiblioteca;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA VIRTUAL ===\n");
        
        // Crear instancia de la biblioteca
        BibliotecaVirtual biblioteca = new BibliotecaVirtual();
        
        // Crear autores
        Autor autor1 = new Autor("Gabriel", "García Márquez", "Colombiano");
        Autor autor2 = new Autor("Isabel", "Allende", "Chilena");
        Autor autor3 = new Autor("Mario", "Vargas Llosa", "Peruano");
        
        System.out.println("--- Probando registro de libros ---");
        
        // Registrar libros con ISBN
        biblioteca.registrarLibro("Cien años de soledad", autor1, 1967, "978-0-06-088328-7");
        biblioteca.registrarLibro("La casa de los espíritus", autor2, 1982, "978-84-204-2676-0");
        
        // Registrar libro sin ISBN (usando sobrecarga)
        biblioteca.registrarLibro("La ciudad y los perros", autor3, 1963);
        
        // Intentar registrar libro sin título (debe manejar error)
        System.out.println("\n--- Probando manejo de errores ---");
        biblioteca.registrarLibro("", autor1, 2000);
        biblioteca.registrarLibro(null, autor2, 2000, "123456789");
        
        // Mostrar todos los libros registrados
        biblioteca.mostrarTodosLosLibros();
        
        // Mostrar información detallada de cada libro
        System.out.println("--- Información detallada ---");
        for (Libro libro : biblioteca.getLibros()) {
            libro.mostrarInformacion();
        }
        
        System.out.println("=== FIN DEL PROGRAMA ===");
    }
}