package caso1_sistemaBiblioteca;

public class Autor {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    
    // Constructor
    public Autor(String nombre, String apellido, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }
    
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + nacionalidad + ")";
    }
}
