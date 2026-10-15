package uniquindio.edu.co;

import uniquindio.edu.co.model.*;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Cine cine = new Cine("CinePlus", "900001234-1", "Calle 10 # 5-20", "Armenia");
        int opcion = 0;

        while (opcion != 11) {

            String menu = """
                    --- CINEPLUS ---
                    1. Registrar película
                    2. Registrar cliente
                    3. Registrar operario
                    4. Registrar sala
                    5. Programar función
                    6. Realizar venta de boletas
                    7. Consultar películas
                    8. Calcular total de una venta
                    9. Calcular ocupación de una función
                    10. Calcular ingresos de una función
                    11. Salir

                    Seleccione una opción:
                    """;

            String entrada = JOptionPane.showInputDialog(null, menu);
            if (entrada == null) {
                break;
            }

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                continue;
            }

            try {
                switch (opcion) {
                    case 1: {
                        String codigo = JOptionPane.showInputDialog(null, "Código de la película:");
                        String titulo = JOptionPane.showInputDialog(null, "Título:");
                        int duracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Duración en minutos:"));
                        if (duracion <= 0) {
                            JOptionPane.showMessageDialog(null, "La duración debe ser mayor a 0.");
                            break;
                        }
                        String clasificacion = JOptionPane.showInputDialog(null, "Clasificación por edad:");

                        String menuGenero = """
                                SELECCIONE EL GÉNERO:
                                1. Acción
                                2. Comedia
                                3. Drama
                                4. Terror
                                5. Animación

                                Seleccione una opción:
                                """;
                        int opcionGenero = Integer.parseInt(JOptionPane.showInputDialog(null, menuGenero));

                        Genero genero = Genero.ACCION;
                        if (opcionGenero == 2) {
                            genero = Genero.COMEDIA;
                        } else if (opcionGenero == 3) {
                            genero = Genero.DRAMA;
                        } else if (opcionGenero == 4) {
                            genero = Genero.TERROR;
                        } else if (opcionGenero == 5) {
                            genero = Genero.ANIMACION;
                        }

                        Pelicula pelicula = new Pelicula(codigo, titulo, duracion, clasificacion, genero);
                        if (cine.registrarPelicula(pelicula)) {
                            JOptionPane.showMessageDialog(null, "¡Película registrada!\n\n" + pelicula);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe una película con ese código.");
                        }
                        break;
                    }
                    case 2: {
                        String documento = JOptionPane.showInputDialog(null, "Documento:");
                        String nombre = JOptionPane.showInputDialog(null, "Nombre completo:");
                        String correo = JOptionPane.showInputDialog(null, "Correo:");
                        String telefono = JOptionPane.showInputDialog(null, "Teléfono:");
                        String codigoAfiliacion = JOptionPane.showInputDialog(null, "Código de afiliación:");
                        double descuento = Double.parseDouble(
                                JOptionPane.showInputDialog(null, "Porcentaje de descuento (0 a 100):"));
                        if (descuento < 0 || descuento > 100) {
                            JOptionPane.showMessageDialog(null, "El descuento debe estar entre 0 y 100.");
                            break;
                        }

                        Cliente cliente = new Cliente(documento, nombre, correo, telefono,
                                codigoAfiliacion, descuento);
                        if (cine.registrarCliente(cliente)) {
                            JOptionPane.showMessageDialog(null, "¡Cliente registrado!\n\n" + cliente);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe una persona con ese documento.");
                        }
                        break;
                    }
                    case 3: {
                        String documento = JOptionPane.showInputDialog(null, "Documento:");
                        String nombre = JOptionPane.showInputDialog(null, "Nombre completo:");
                        String correo = JOptionPane.showInputDialog(null, "Correo:");
                        String telefono = JOptionPane.showInputDialog(null, "Teléfono:");
                        String codigoEmpleado = JOptionPane.showInputDialog(null, "Código de empleado:");
                        String fechaContratacion = JOptionPane.showInputDialog(null,
                                "Fecha de contratación (AAAA-MM-DD):");
                        double salario = Double.parseDouble(
                                JOptionPane.showInputDialog(null, "Salario básico:"));

                        Operario operario = new Operario(documento, nombre, correo, telefono,
                                codigoEmpleado, fechaContratacion, salario);
                        if (cine.registrarOperario(operario)) {
                            JOptionPane.showMessageDialog(null, "¡Operario registrado!\n\n" + operario);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe una persona con ese documento.");
                        }
                        break;
                    }
                    case 4: {
                        String codigo = JOptionPane.showInputDialog(null, "Código de la sala:");
                        String nombre = JOptionPane.showInputDialog(null, "Nombre de la sala:");
                        int filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de filas:"));
                        int columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de columnas:"));
                        if (filas <= 0 || columnas <= 0) {
                            JOptionPane.showMessageDialog(null, "Las filas y columnas deben ser mayores a 0.");
                            break;
                        }

                        String menuTipoSala = """
                                SELECCIONE EL TIPO DE SALA:
                                1. Tradicional
                                2. VIP
                                3. 3D

                                Seleccione una opción:
                                """;
                        int opcionTipoSala = Integer.parseInt(JOptionPane.showInputDialog(null, menuTipoSala));

                        TipoSala tipoSala = TipoSala.TRADICIONAL; // valor por defecto
                        if (opcionTipoSala == 2) {
                            tipoSala = TipoSala.VIP;
                        } else if (opcionTipoSala == 3) {
                            tipoSala = TipoSala.SALA_3D;
                        }

                        Sala sala = new Sala(codigo, nombre, filas * columnas, filas, columnas, tipoSala);
                        if (cine.registrarSala(sala)) {
                            JOptionPane.showMessageDialog(null, "¡Sala registrada!\n\n" + sala);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe una sala con ese código.");
                        }
                        break;
                    }
                    case 5: {
                        String codigo = JOptionPane.showInputDialog(null, "Código de la función:");
                        String fecha = JOptionPane.showInputDialog(null, "Fecha (AAAA-MM-DD):");
                        String hora = JOptionPane.showInputDialog(null, "Hora de inicio (HH:mm):");
                        if (hora == null || !hora.matches("([01]?\\d|2[0-3]):[0-5]\\d")) {
                            JOptionPane.showMessageDialog(null,
                                    "La hora debe tener el formato HH:mm (por ejemplo 14:30).");
                            break;
                        }
                        double precio = Double.parseDouble(
                                JOptionPane.showInputDialog(null, "Precio base de la boleta:"));

                        Pelicula pelicula = cine.buscarPelicula(
                                JOptionPane.showInputDialog(null, "Código de la película:"));
                        if (pelicula == null) {
                            JOptionPane.showMessageDialog(null, "La película no existe.");
                            break;
                        }
                        Sala sala = cine.buscarSala(
                                JOptionPane.showInputDialog(null, "Código de la sala:"));
                        if (sala == null) {
                            JOptionPane.showMessageDialog(null, "La sala no existe.");
                            break;
                        }

                        Funcion funcion = new Funcion(codigo, fecha, hora, precio, pelicula, sala);
                        if (cine.programarFuncion(funcion)) {
                            JOptionPane.showMessageDialog(null, "Función programada\n\n" + funcion);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "No se pudo programar: código repetido o conflicto de horario en la sala.");
                        }
                        break;
                    }
                    case 6: {
                        String codigoVenta = JOptionPane.showInputDialog(null, "Código de la venta:");
                        if (cine.buscarVenta(codigoVenta) != null) {
                            JOptionPane.showMessageDialog(null, "Ya existe una venta con ese código.");
                            break;
                        }
                        String fecha = JOptionPane.showInputDialog(null, "Fecha de la venta (AAAA-MM-DD):");

                        Cliente cliente = cine.buscarCliente(
                                JOptionPane.showInputDialog(null, "Documento del cliente:"));
                        if (cliente == null) {
                            JOptionPane.showMessageDialog(null, "El cliente no está registrado.");
                            break;
                        }
                        Operario operario = cine.buscarOperario(
                                JOptionPane.showInputDialog(null, "Documento del operario:"));
                        if (operario == null) {
                            JOptionPane.showMessageDialog(null, "El operario no está registrado.");
                            break;
                        }
                        Funcion funcion = cine.buscarFuncion(
                                JOptionPane.showInputDialog(null, "Código de la función:"));
                        if (funcion == null) {
                            JOptionPane.showMessageDialog(null, "La función no existe.");
                            break;
                        }

                        Venta venta = new Venta(codigoVenta, fecha, cliente, operario, funcion);
                        int cantidad = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "¿Cuántas boletas desea comprar?"));
                        if (cantidad <= 0) {
                            JOptionPane.showMessageDialog(null, "Debe comprar al menos una boleta.");
                            break;
                        }

                        for (int i = 1; i <= cantidad; i++) {
                            int fila = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Boleta " + i + " - Fila:"));
                            int asiento = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Boleta " + i + " - Número de asiento:"));
                            if (!cine.agregarBoleta(venta, fila, asiento)) {
                                JOptionPane.showMessageDialog(null,
                                        "El asiento " + fila + "-" + asiento + " no existe u está ocupado.");
                            }
                        }

                        if (cine.registrarVenta(venta)) {
                            JOptionPane.showMessageDialog(null, "¡Venta registrada!\nBoletas: "
                                    + venta.getListVentaBoletas().size()
                                    + "\nTotal: " + venta.calcularTotal());
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "No se registró la venta: ninguna boleta fue válida.");
                        }
                        break;
                    }
                    case 7:
                        JOptionPane.showMessageDialog(null, cine.consultarPeliculas());
                        break;
                    case 8: {
                        Venta venta = cine.buscarVenta(
                                JOptionPane.showInputDialog(null, "Código de la venta:"));
                        if (venta == null) {
                            JOptionPane.showMessageDialog(null, "La venta no existe.");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Total de la venta " + venta.getCodigo() + ": " + venta.calcularTotal());
                        }
                        break;
                    }
                    case 9: {
                        double ocupacion = cine.calcularOcupacionFuncion(
                                JOptionPane.showInputDialog(null, "Código de la función:"));
                        if (ocupacion < 0) {
                            JOptionPane.showMessageDialog(null, "La función no existe.");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Ocupación: " + String.format("%.1f", ocupacion) + " %");
                        }
                        break;
                    }
                    case 10: {
                        double ingresos = cine.calcularIngresosFuncion(
                                JOptionPane.showInputDialog(null, "Código de la función:"));
                        if (ingresos < 0) {
                            JOptionPane.showMessageDialog(null, "La función no existe.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingresos de la función: " + ingresos);
                        }
                        break;
                    }
                    case 11:
                        JOptionPane.showMessageDialog(null, "¡Gracias por utilizar CinePlus!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Seleccione del 1 al 11.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Dato inválido: debe ingresar un número válido. La operación fue cancelada.");
            }
        }
    }
}