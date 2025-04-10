import java.util.ArrayList;
import java.util.List;

public class TiendaSimulacion {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Simulación de Tienda Tecnológica ---");


        List<Producto> inventario = new ArrayList<>();
        inventario.add(new Laptop("MacBook Pro", "Apple", 2500.00, 10, "M3 Pro", 16));
        inventario.add(new Laptop("ThinkPad X1", "Lenovo", 1800.00, 15, "Intel i7", 16));
        inventario.add(new Celular("iPhone 15", "Apple", 1100.00, 25, 3800, 48));
        inventario.add(new Celular("Galaxy S24", "Samsung", 1000.00, 30, 4500, 50));
        inventario.add(new Laptop("Gamer ROG", "ASUS", 2100.00, 8, "AMD Ryzen 9", 32)); // Laptop con descuento posible


        System.out.println("\n--- Inventario Inicial ---");
        mostrarInventarioCompleto(inventario);


        Cliente cliente1 = new Cliente("Ana Gómez", "ana.gomez@email.com");
        Cliente cliente2 = new Cliente("Luis Martin", "luis.martin@email.com");



        System.out.println("\n--- Iniciando Proceso de Compras ---");


        realizarCompra(cliente1, inventario, "MacBook Pro", 1);


        realizarCompra(cliente2, inventario, "Galaxy S24", 2);


        realizarCompra(cliente1, inventario, "iPhone 15", 6);


        realizarCompra(cliente2, inventario, "ThinkPad X1", 10); // Aplica descuento


        realizarCompra(cliente1, inventario, "Gamer ROG", 12); // Debería fallar por stock


        realizarCompra(cliente2, inventario, "Gamer ROG", 8); // Compra exitosa con descuento



        System.out.println("\n--- Resumen Final de la Simulación ---");


        cliente1.mostrarHistorialCompras();
        cliente2.mostrarHistorialCompras();


        System.out.println("\n--- Inventario Final ---");
        mostrarInventarioCompleto(inventario);

        System.out.println("\n--- Fin de la Simulación ---");
    }


    public static Producto buscarProductoPorNombre(List<Producto> inventario, String nombreBuscado) {
        for (Producto p : inventario) {

            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return p;
            }
        }
        return null;
    }


    public static void realizarCompra(Cliente cliente, List<Producto> inventario, String nombreProducto, int cantidad) {
        System.out.println("\nIntentando compra: " + cliente.getNombre() + " quiere " + cantidad + " x " + nombreProducto);


        Producto productoAComprar = buscarProductoPorNombre(inventario, nombreProducto);

        if (productoAComprar == null) {
            System.out.println("Error: Producto '" + nombreProducto + "' no encontrado en el inventario.");
            return;
        }


        if (productoAComprar.hayStockSuficiente(cantidad)) {

            double precioVenta = ((Vendible) productoAComprar).calcularPrecioVenta(cantidad);


            productoAComprar.reducirStock(cantidad);


            cliente.agregarCompra(productoAComprar, cantidad, precioVenta);

            System.out.println("Compra exitosa. Costo: $" + String.format("%.2f", precioVenta));

        } else {
            System.out.println("Error: Stock insuficiente para '" + nombreProducto + "'. Solicitado: "
                    + cantidad + ", Disponible: " + productoAComprar.getCantidadStock());
        }
    }

    public static void mostrarInventarioCompleto(List<Producto> inventario) {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("--------------------------------------------------");
        for (Producto p : inventario) {
            p.mostrarDetalles();
        }
        System.out.println("--------------------------------------------------");
    }
}