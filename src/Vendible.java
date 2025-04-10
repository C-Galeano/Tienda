
public interface Vendible {
    int CANTIDAD_MINIMA_DESCUENTO = 5;
    double TASA_DESCUENTO = 0.10;

    double calcularPrecioVenta(int cantidad);
}