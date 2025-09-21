package caso3_sistemaVentas;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE VENTAS EN LÍNEA ===\n");
        
        // Crear tienda
        TiendaOnline tienda = new TiendaOnline("TechStore Peru");
        
        try {
            // Crear y agregar productos
            System.out.println("--- Agregando productos al inventario ---");
            Producto laptop = new Producto("Laptop Gaming ASUS", 2500.00, 5);
            Producto mouse = new Producto("Mouse Logitech G502", 150.00, 10);
            Producto teclado = new Producto("Teclado Mecánico RGB", 200.00, 8);
            Producto monitor = new Producto("Monitor 24 pulgadas", 800.00, 3);
            Producto auriculares = new Producto("Auriculares HyperX", 120.00, 0); // Sin stock
            
            tienda.agregarProducto(laptop);
            tienda.agregarProducto(mouse);
            tienda.agregarProducto(teclado);
            tienda.agregarProducto(monitor);
            tienda.agregarProducto(auriculares);
            
            // Mostrar inventario inicial
            tienda.mostrarInventario();
            
            // Realizar primera venta
            System.out.println("--- Realizando Venta #1 ---");
            Venta venta1 = tienda.realizarCompra();
            
            try {
                venta1.agregarItem(laptop, 1);
                venta1.agregarItem(mouse, 2);
                venta1.agregarItem(teclado, 1);
                
                venta1.mostrarDetalle();
                tienda.procesarVenta(venta1);
                
            } catch (StockInsuficienteException e) {
                System.err.println("Error en venta: " + e.getMessage());
            }
            
            // Realizar segunda venta con problema de stock
            System.out.println("--- Realizando Venta #2 (con error de stock) ---");
            Venta venta2 = tienda.realizarCompra();
            
            try {
                venta2.agregarItem(monitor, 2);
                venta2.agregarItem(auriculares, 1); // Este producto no tiene stock
                venta2.mostrarDetalle();
                tienda.procesarVenta(venta2);
                
            } catch (StockInsuficienteException e) {
                System.err.println("Error en venta: " + e.getMessage());
                System.out.println("Cancelando venta...");
                venta2.cancelarVenta();
            }
            
            // Realizar tercera venta exitosa
            System.out.println("--- Realizando Venta #3 ---");
            Venta venta3 = tienda.realizarCompra();
            
            try {
                venta3.agregarItem(monitor, 1);
                venta3.agregarItem(mouse, 1);
                
                venta3.mostrarDetalle();
                tienda.procesarVenta(venta3);
                
            } catch (StockInsuficienteException e) {
                System.err.println("Error en venta: " + e.getMessage());
            }
            
            // Mostrar inventario actualizado
            System.out.println("--- Inventario después de las ventas ---");
            tienda.mostrarInventario();
            
            // Mostrar historial de ventas
            tienda.mostrarHistorialVentas();
            
            // Mostrar productos con stock bajo
            System.out.println("--- Productos con stock bajo (≤3 unidades) ---");
            java.util.List<Producto> stockBajo = tienda.getProductosStockBajo(3);
            if (stockBajo.isEmpty()) {
                System.out.println("Todos los productos tienen stock suficiente.");
            } else {
                for (Producto producto : stockBajo) {
                    System.out.println("⚠ " + producto.toString());
                }
            }
            
            // Demostrar búsqueda de productos
            System.out.println("\n--- Demostrando búsqueda de productos ---");
            try {
                Producto encontrado = tienda.buscarProductoPorNombre("Mouse Logitech G502");
                System.out.println("✓ Producto encontrado: " + encontrado.toString());
            } catch (ProductoNoEncontradoException e) {
                System.err.println("✗ " + e.getMessage());
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear producto: " + e.getMessage());
        }
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}