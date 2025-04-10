import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String correo;
    private List<RegistroCompra> historialCompras;


    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.historialCompras = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }


    public void agregarCompra(Producto producto, int cantidad, double precioPagado) {
        RegistroCompra nuevoRegistro = new RegistroCompra(producto, cantidad, precioPagado);
        this.historialCompras.add(nuevoRegistro);
        System.out.println("Compra registrada para " + this.nombre + ": " + cantidad + " x " + producto.getNombre());
    }


    public void mostrarHistorialCompras() {
        System.out.println("\n--- Historial de Compras de: " + this.nombre + " (" + this.correo + ") ---");
        if (historialCompras.isEmpty()) {
            System.out.println("El cliente no ha realizado compras.");
            return; // Sale del método si no hay compras
        }

        double costoTotalCliente = 0;

        for (RegistroCompra registro : historialCompras) {
            registro.mostrarDetalleRegistro(); // Llama al método del registro para mostrar sus detalles
            costoTotalCliente += registro.getPrecioPagadoTotal(); // Suma el costo de esta compra al total
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Costo Total Gastado por " + this.nombre + ": $" + String.format("%.2f", costoTotalCliente));
        System.out.println("--------------------------------------------------");
    }
}