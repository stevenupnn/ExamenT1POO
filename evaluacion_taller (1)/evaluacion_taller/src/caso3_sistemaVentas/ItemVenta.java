package caso3_sistemaVentas;

public class ItemVenta {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
    public ItemVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
        this.subtotal = precioUnitario * cantidad;
    }
    
    // Getters
    public Producto getProducto() {
        return producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    @Override
    public String toString() {
        return cantidad + "x " + producto.getNombre() + 
               " @ S/. " + String.format("%.2f", precioUnitario) + 
               " = S/. " + String.format("%.2f", subtotal);
    }
}

