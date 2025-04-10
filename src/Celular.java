public class Celular extends Producto implements Vendible {
    private int capacidadBateria;
    private int camaraResolucion;

    public Celular(String nombre, String marca, double precio, int cantidadStock,
                   int capacidadBateria, int camaraResolucion) {

        super(nombre, marca, precio, cantidadStock);

        this.capacidadBateria = capacidadBateria;
        this.camaraResolucion = camaraResolucion;
    }

    public int getCapacidadBateria() {
        return capacidadBateria;
    }

    public int getCamaraResolucion() {
        return camaraResolucion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("--- Celular ---");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Marca: " + getMarca());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Stock: " + getCantidadStock() + " unidades");
        System.out.println("Batería: " + this.capacidadBateria + " mAh");
        System.out.println("Cámara: " + this.camaraResolucion + " MP");
        System.out.println("---------------");
    }


    @Override
    public double calcularPrecioVenta(int cantidad) {
        if (cantidad <= 0) {
            return 0;
        }
        double precioTotal = getPrecio() * cantidad;


        if (cantidad > CANTIDAD_MINIMA_DESCUENTO) {
            double descuento = precioTotal * TASA_DESCUENTO;
            precioTotal -= descuento;
            System.out.println("(Descuento del " + (TASA_DESCUENTO * 100) + "% aplicado por comprar " + cantidad + " unidades)");
        }
        return precioTotal;
    }
}