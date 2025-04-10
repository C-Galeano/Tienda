public class RegistroCompra {
    private Producto productoComprado;
    private int cantidadComprada;
    private double precioPagadoTotal;

    public RegistroCompra(Producto productoComprado, int cantidadComprada, double precioPagadoTotal) {
        this.productoComprado = productoComprado;
        this.cantidadComprada = cantidadComprada;
        this.precioPagadoTotal = precioPagadoTotal;
    }


    public Producto getProductoComprado() {
        return productoComprado;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public double getPrecioPagadoTotal() {
        return precioPagadoTotal;
    }


    public void mostrarDetalleRegistro() {
        System.out.println("  * Producto: " + productoComprado.getNombre() + " (" + productoComprado.getMarca() + ")");
        System.out.println("    Cantidad: " + cantidadComprada);
        System.out.println("    Precio Pagado: $" + String.format("%.2f", precioPagadoTotal)); // Formatear a 2 decimales
    }
}