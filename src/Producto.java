
public abstract class Producto {
    private String nombre;
    private String marca;
    private double precio;
    private int cantidadStock;


    public Producto(String nombre, String marca, double precio, int cantidadStock) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public boolean hayStockSuficiente(int cantidadDeseada) {
        return this.cantidadStock >= cantidadDeseada;
    }


    public void reducirStock(int cantidadVendida) {
        if (cantidadVendida > 0 && cantidadVendida <= this.cantidadStock) {
            this.cantidadStock -= cantidadVendida;
        } else {
            System.err.println("Advertencia: Intento de reducir stock inválido para " + nombre);
        }
    }


    public abstract void mostrarDetalles();
}