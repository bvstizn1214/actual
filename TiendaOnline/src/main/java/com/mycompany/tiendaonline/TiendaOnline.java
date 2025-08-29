package com.mycompany.tiendaonline;

import com.mycompany.tiendaonline.controller.ProductosController;
import com.mycompany.tiendaonline.controller.DescuentosController;
import com.mycompany.tiendaonline.controller.CarritoController;
import com.mycompany.tiendaonline.view.ProductosView;
import com.mycompany.tiendaonline.view.CarritoView;
import com.mycompany.tiendaonline.view.DescuentosView;
import com.mycompany.tiendaonline.command.Invoker;
import com.mycompany.tiendaonline.command.AgregarProductoCommand;
import com.mycompany.tiendaonline.decorator.Descuento15;
import com.mycompany.tiendaonline.decorator.Descuento20;
import com.mycompany.tiendaonline.decorator.Descuento10;
import com.mycompany.tiendaonline.decorator.Component;
import com.mycompany.tiendaonline.model.Usuario;
import com.mycompany.tiendaonline.model.Pedido;
import com.mycompany.tiendaonline.model.Producto;
import java.util.*;

public class TiendaOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Component> productosDisponibles = Arrays.asList(
            new Descuento10(new Producto("Camisa", 9990, "Ropa")),
            new Descuento15(new Producto("Pantalón", 12990, "Ropa")),
            new Descuento20(new Producto("Zapatos", 39990, "Calzado"))
        );
        Usuario usuario = new Usuario("Cliente", "cliente@email.com");
        Pedido pedido = new Pedido(usuario);
        Invoker invoker = new Invoker();

        // Vistas y controladores
        ProductosView productosView = new ProductosView();
        CarritoView carritoView = new CarritoView();
        DescuentosView descuentosView = new DescuentosView();

        ProductosController productosController = new ProductosController(productosDisponibles, productosView);
        CarritoController carritoController = new CarritoController(pedido, carritoView);
        DescuentosController descuentosController = new DescuentosController(descuentosView);

        while (true) {
            System.out.println("\n--- MENÚ TIENDA ONLINE ---");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Aplicar descuento a producto");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    productosController.mostrarProductos();
                    break;
                case "2":
                    agregarProducto(productosDisponibles, pedido, invoker, scanner);
                    break;
                case "3":
                    carritoController.mostrarCarrito();
                    break;
                case "4":
                    aplicarDescuento(productosDisponibles, descuentosController, scanner);
                    break;
                case "5":
                    System.out.println("¡Gracias por usar la tienda!");
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void agregarProducto(List<Component> productos, Pedido pedido, Invoker invoker, Scanner scanner) {
        System.out.print("Selecciona el número del producto a agregar: ");
        int seleccion = validarNumero(scanner.nextLine(), 1, productos.size());
        if (seleccion == -1) {
            System.out.println("Selección inválida.");
            return;
        }
        Component producto = productos.get(seleccion - 1);
        invoker.agregarComando(new AgregarProductoCommand(pedido, producto));
        invoker.ejecutarComandos();
        System.out.println("Producto agregado al carrito.");
    }

    private static void aplicarDescuento(List<Component> productos, DescuentosController descuentosController, Scanner scanner) {
        System.out.print("Selecciona el número del producto para ver descuento: ");
        int seleccion = validarNumero(scanner.nextLine(), 1, productos.size());
        if (seleccion == -1) {
            System.out.println("Selección inválida.");
            return;
        }
        Component producto = productos.get(seleccion - 1);
        descuentosController.mostrarDescuento(producto);
    }

    private static int validarNumero(String input, int min, int max) {
        try {
            int num = Integer.parseInt(input);
            if (num >= min && num <= max) return num;
        } catch (NumberFormatException e) {}
        return -1;
    }
}