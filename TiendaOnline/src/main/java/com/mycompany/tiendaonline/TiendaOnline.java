package com.mycompany.tiendaonline;

import java.util.*;

public class TiendaOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Component> productosDisponibles = Arrays.asList(
            new Descuento10(new Producto("Camisa", 9990)),
            new Descuento15(new Producto("Pantalón", 12990)),
            new Descuento20(new Producto("Zapatos", 39990))
        );
        List<Component> carrito = new ArrayList<>();
        Invoker invoker = new Invoker();

        while (true) {
            System.out.println("\n--- MENÚ TIENDA ONLINE ---");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Pagar");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarProductos(productosDisponibles);
                    break;
                case "2":
                    agregarProducto(productosDisponibles, carrito, invoker, scanner);
                    break;
                case "3":
                    mostrarCarrito(carrito);
                    break;
                case "4":
                    if (carrito.isEmpty()) {
                        System.out.println("El carrito está vacío.");
                    } else {
                        if (realizarPago(carrito, scanner)) {
                            carrito.clear();
                        }
                    }
                    break;
                case "5":
                    System.out.println("¡Gracias por usar la tienda!");
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void mostrarProductos(List<Component> productos) {
        System.out.println("\nProductos disponibles:");
        int idx = 1;
        for (Component p : productos) {
            System.out.printf("%d. %s - $%d CLP (Descuento aplicado: $%d CLP)\n", idx++, p.getNombre(), p.getPrecio(), p.aplicarDescuento());
        }
    }

    private static void agregarProducto(List<Component> productos, List<Component> carrito, Invoker invoker, Scanner scanner) {
        while (true) {
            mostrarProductos(productos);
            System.out.print("Selecciona el número del producto: ");
            String input = scanner.nextLine();
            int seleccion = validarNumero(input, 1, productos.size());
            if (seleccion == -1) {
                System.out.println("Selección inválida. Intenta nuevamente.");
                continue;
            }
            Component producto = productos.get(seleccion - 1);
            invoker.agregarComando(new AgregarProductoComando(producto, carrito));
            invoker.ejecutarComandos();
            break;
        }
    }

    private static void mostrarCarrito(List<Component> carrito) {
        System.out.println("\nCarrito de compras:");
        int idx = 1;
        int total = 0;
        for (Component c : carrito) {
            int precioFinal = DiscountManager.getInstance().aplicarDescuento(c);
            System.out.printf("%d. %s - Precio original: $%d CLP | Precio final: $%d CLP\n", idx++, c.getNombre(), c.getPrecio(), precioFinal);
            total += precioFinal;
        }
        System.out.printf("Total a pagar: $%d CLP\n", total);
    }

    private static boolean realizarPago(List<Component> carrito, Scanner scanner) {
        int total = carrito.stream().mapToInt(c -> DiscountManager.getInstance().aplicarDescuento(c)).sum();
        while (true) {
            System.out.println("\nMétodos de pago:");
            System.out.println("1. Débito");
            System.out.println("2. Efectivo");
            System.out.print("Elige una opción: ");
            String metodo = scanner.nextLine();

            if (metodo.equals("1")) {
                while (true) {
                    System.out.print("Ingrese su clave de 4 dígitos: ");
                    String clave = scanner.nextLine();
                    if (!clave.matches("\\d{4}")) {
                        System.out.println("Clave inválida. Debe ser 4 dígitos numéricos.");
                        continue;
                    }
                    System.out.printf("Pago de $%d CLP realizado con débito.\n¡Gracias por su compra!\n", total);
                    return true;
                }
            } else if (metodo.equals("2")) {
                while (true) {
                    System.out.printf("Monto a pagar: $%d CLP\n", total);
                    System.out.print("Ingrese el monto entregado: ");
                    String montoStr = scanner.nextLine();
                    try {
                        int monto = Integer.parseInt(montoStr);
                        if (monto < total) {
                            System.out.println("Monto insuficiente. Intente de nuevo.");
                            continue;
                        }
                        System.out.printf("Pago realizado. Vuelto: $%d CLP\n¡Gracias por su compra!\n", monto - total);
                        return true;
                    } catch (NumberFormatException e) {
                        System.out.println("Monto inválido. Debe ser un número entero.");
                    }
                }
            } else {
                System.out.println("Método de pago inválido. Intente de nuevo.");
            }
        }
    }

    private static int validarNumero(String input, int min, int max) {
        try {
            int num = Integer.parseInt(input);
            if (num >= min && num <= max) return num;
        } catch (NumberFormatException e) {}
        return -1;
    }
}