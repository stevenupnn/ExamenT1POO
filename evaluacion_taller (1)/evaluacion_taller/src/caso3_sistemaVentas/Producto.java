package caso3_sistemaVentas;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private String codigo;
    private static int contadorCodigo = 1000;
    
    // Constructor
    public Producto(String nombre, double precio, int stock) throws IllegalArgumentException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El nombre del producto no puede estar vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Error: El precio debe ser mayor que cero");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Error: El stock no puede ser negativo");
        }
        
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.codigo = "PROD" + (++contadorCodigo);
    }
    
    // Método para reducir stock durante una compra
    public void reducirStock(int cantidad) throws StockInsuficienteException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        if (cantidad > stock) {
            throw new StockInsuficienteException(
                "Stock insuficiente para " + nombre + ". Disponible: " + stock + ", Solicitado: " + cantidad
            );
        }
        stock -= cantidad;
    }
    
    // Método para agregar stock
    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
        }
    }
    
    // Método para verificar disponibilidad
    public boolean estaDisponible(int cantidad) {
        return stock >= cantidad;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }
    
    public int getStock() {
        return stock;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    // Método para mostrar información del producto
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo + " | " + nombre + 
                         " | Precio: S/. " + String.format("%.2f", precio) + 
                         " | Stock: " + stock + " unidades");
    }
    
    @Override
    public String toString() {
        return nombre + " (S/. " + String.format("%.2f", precio) + ") - Stock: " + stock;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return codigo.equals(producto.codigo);
    }
}
