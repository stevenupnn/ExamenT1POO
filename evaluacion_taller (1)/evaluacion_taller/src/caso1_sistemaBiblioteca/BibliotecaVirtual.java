package caso1_sistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaVirtual {
    private List<Libro> libros;
    
    public BibliotecaVirtual() {
        this.libros = new ArrayList<>();
    }
    
    // Método para registrar libro con ISBN
    public void registrarLibro(String titulo, Autor autor, int año, String isbn) {
        try {
            Libro libro = new Libro(titulo, autor, año, isbn);
            libros.add(libro);
            System.out.println("✓ Libro registrado exitosamente con ISBN: " + isbn);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Método para registrar libro sin ISBN (sobrecarga)
    public void registrarLibro(String titulo, Autor autor, int año) {
        try {
            Libro libro = new Libro(titulo, autor, año);
            libros.add(libro);
            System.out.println("✓ Libro registrado exitosamente sin ISBN");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Método para mostrar todos los libros
    public void mostrarTodosLosLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }
        
        System.out.println("\n=== CATÁLOGO DE LIBROS ===");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + ". " + libros.get(i).toString());
        }
        System.out.println("==========================\n");
    }
    
    public List<Libro> getLibros() {
        return new ArrayList<>(libros); // Retorna una copia para proteger la colección
    }
}

