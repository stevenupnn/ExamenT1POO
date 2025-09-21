package caso1_sistemaBiblioteca;

public class Libro {
    private String titulo;
    private Autor autor;
    private int año;
    private String isbn;
    
    // Constructor con ISBN (sobrecarga 1)
    public Libro(String titulo, Autor autor, int año, String isbn) throws IllegalArgumentException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: No se puede registrar un libro sin título");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.isbn = isbn;
    }
    
    // Constructor sin ISBN (sobrecarga 2)
    public Libro(String titulo, Autor autor, int año) throws IllegalArgumentException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: No se puede registrar un libro sin título");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.isbn = "Sin ISBN";
    }
    
    // Métodos getter y setter
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El título no puede estar vacío");
        }
        this.titulo = titulo;
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public int getAño() {
        return año;
    }
    
    public void setAño(int año) {
        this.año = año;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    // Método para mostrar información del libro
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL LIBRO ===");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor.toString());
        System.out.println("Año: " + año);
        System.out.println("ISBN: " + isbn);
        System.out.println("=============================\n");
    }
    
    @Override
    public String toString() {
        return "\"" + titulo + "\" por " + autor.getNombreCompleto() + " (" + año + ")";
    }
}