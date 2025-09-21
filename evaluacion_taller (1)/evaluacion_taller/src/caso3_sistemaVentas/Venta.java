package caso3_sistemaVentas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String numeroVenta;
    private LocalDateTime fechaHora;
    private List<ItemVenta> items; // Composición: Una venta está compuesta de items
    private double total;
    private static int contadorVentas = 1;
    
    public Venta() {
        this.numeroVenta = "VTA" + String.format("%04d", contadorVentas++);
        this.fechaHora = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.total = 0.0;
    }
    
    // Método para agregar un item a la venta
    public void agregarItem(Producto producto, int cantidad) throws StockInsuficienteException {
        if (!producto.estaDisponible(cantidad)) {
            throw new StockInsuficienteException(
                "No hay suficiente stock de " + producto.getNombre() + 
                ". Disponible: " + producto.getStock()
            );
        }
        
        ItemVenta item = new ItemVenta(producto, cantidad);
        items.add(item);
        total += item.getSubtotal();
    }
    
    // Método para finalizar la venta (procesar stock)
    public void finalizarVenta() throws StockInsuficienteException {
        for (ItemVenta item : items) {
            item.getProducto().reducirStock(item.getCantidad());
        }
    }
    
    // Método para cancelar venta (restaurar stock si ya se procesó)
    public void cancelarVenta() {
        for (ItemVenta item : items) {
            item.getProducto().agregarStock(item.getCantidad());
        }
        items.clear();
        total = 0.0;
    }
    
    // Método para mostrar el detalle de la venta
    public void mostrarDetalle() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("======== DETALLE DE VENTA ========");
        System.out.println("Número: " + numeroVenta);
        System.out.println("Fecha: " + fechaHora.format(formatter));
        System.out.println("-----------------------------------");
        
        if (items.isEmpty()) {
            System.out.println("No hay items en esta venta.");
        } else {
            for (ItemVenta item : items) {
                System.out.println(item.toString());
            }
            System.out.println("-----------------------------------");
            System.out.println("TOTAL: S/. " + String.format("%.2f", total));
        }
        System.out.println("==================================\n");
    }
    
    // Getters
    public String getNumeroVenta() {
        return numeroVenta;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public List<ItemVenta> getItems() {
        return new ArrayList<>(items); // Retorna copia para proteger la colección
    }
    
    public double getTotal() {
        return total;
    }
    
    public boolean tieneItems() {
        return !items.isEmpty();
    }
}