package caso3_sistemaVentas;

class StockInsuficienteException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
