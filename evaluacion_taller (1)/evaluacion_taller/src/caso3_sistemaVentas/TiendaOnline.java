package caso3_sistemaVentas;

import java.util.ArrayList;
import java.util.List;

public class TiendaOnline {
    private List<Producto> productos; // ArrayList para gestionar múltiples productos
    private List<Venta> historialVentas;
    private String nombreTienda;
    
    public TiendaOnline(String nombreTienda) {
        this.nombreTienda = nombreTienda;
        this.productos = new ArrayList<>();
        this.historialVentas = new ArrayList<>();
    }
    
    // Método para agregar productos al inventario
    public void agregarProducto(Producto producto) {
        if (!productos.contains(producto)) {
            productos.add(producto);
            System.out.println("✓ Producto agregado: " + producto.getNombre());
        } else {
            System.out.println("⚠ El producto ya existe en el inventario");
        }
    }
    
    // Método para buscar producto por código
    public Producto buscarProducto(String codigo) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException("Producto con código " + codigo + " no encontrado");
    }
    
    // Método para buscar producto por nombre
    public Producto buscarProductoPorNombre(String nombre) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException("Producto " + nombre + " no encontrado");
    }
    
    // Método principal para realizar una compra
    public Venta realizarCompra() {
        return new Venta();
    }
    
    // Método para procesar una venta completa
    public void procesarVenta(Venta venta) throws StockInsuficienteException {
        if (!venta.tieneItems()) {
            throw new IllegalArgumentException("No se puede procesar una venta sin items");
        }
        
        try {
            venta.finalizarVenta();
            historialVentas.add(venta);
            System.out.println("✓ Venta procesada exitosamente: " + venta.getNumeroVenta());
        } catch (StockInsuficienteException e) {
            System.err.println("✗ Error al procesar venta: " + e.getMessage());
            throw e;
        }
    }
    
    // Método para mostrar inventario completo
    public void mostrarInventario() {
        System.out.println("=== INVENTARIO DE " + nombreTienda.toUpperCase() + " ===");
        
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("Total de productos: " + productos.size());
            System.out.println("-----------------------------------------------");
            for (Producto producto : productos) {
                producto.mostrarInformacion();
            }
        }
        System.out.println("===============================================\n");
    }
    
    // Método para mostrar historial de ventas
    public void mostrarHistorialVentas() {
        System.out.println("=== HISTORIAL DE VENTAS ===");
        
        if (historialVentas.isEmpty()) {
            System.out.println("No se han registrado ventas.");
        } else {
            double totalVentas = 0;
            for (Venta venta : historialVentas) {
                System.out.println(venta.getNumeroVenta() + " - Total: S/. " + 
                                 String.format("%.2f", venta.getTotal()));
                totalVentas += venta.getTotal();
            }
            System.out.println("---------------------------");
            System.out.println("Total vendido: S/. " + String.format("%.2f", totalVentas));
        }
        System.out.println("===========================\n");
    }
    
    // Método para obtener productos con stock bajo
    public List<Producto> getProductosStockBajo(int limite) {
        List<Producto> stockBajo = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getStock() <= limite) {
                stockBajo.add(producto);
            }
        }
        return stockBajo;
    }
    
    // Getters
    public List<Producto> getProductos() {
        return new ArrayList<>(productos); // Retorna copia para proteger la colección
    }
    
    public List<Venta> getHistorialVentas() {
        return new ArrayList<>(historialVentas);
    }
    
    public String getNombreTienda() {
        return nombreTienda;
    }
}
