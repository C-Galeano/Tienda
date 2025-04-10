public class Laptop extends Producto implements Vendible {
    private String procesador;
    private int memoriaRAM;


    public Laptop(String nombre, String marca, double precio, int cantidadStock,
                  String procesador, int memoriaRAM) {

        super(nombre, marca, precio, cantidadStock);

        this.procesador = procesador;
        this.memoriaRAM = memoriaRAM;
    }


    public String getProcesador() {
        return procesador;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }


    @Override
    public void mostrarDetalles() {
        System.out.println("--- Laptop ---");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Marca: " + getMarca());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Stock: " + getCantidadStock() + " unidades");
        System.out.println("Procesador: " + this.procesador);
        System.out.println("RAM: " + this.memoriaRAM + " GB");
        System.out.println("--------------");
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