package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Cine {

    public final static double RECARGO_VIP = 0.30;
    public final static double RECARGO_3D = 0.20;

    private String nombre, nit, direccion, ciudad;

    private List<Sala> listCineSalas;
    private List<Pelicula> listCinePeliculas;
    private List<Funcion> listCineFunciones;
    private List<Persona> listCinePersonas;
    private List<Venta> listCineVentas;

    /**
     * Metodo constructor de la clase Cine
     * @param nombre comercial del cine
     * @param nit del cine
     * @param direccion del cine
     * @param ciudad del cine
     */
    public Cine(String nombre, String nit, String direccion, String ciudad) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.listCineSalas = new ArrayList<>();
        this.listCinePeliculas = new ArrayList<>();
        this.listCineFunciones = new ArrayList<>();
        this.listCinePersonas = new ArrayList<>();
        this.listCineVentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Sala> getListCineSalas() {
        return listCineSalas;
    }

    public void setListCineSalas(List<Sala> listCineSalas) {
        this.listCineSalas = listCineSalas;
    }

    public List<Pelicula> getListCinePeliculas() {
        return listCinePeliculas;
    }

    public void setListCinePeliculas(List<Pelicula> listCinePeliculas) {
        this.listCinePeliculas = listCinePeliculas;
    }

    public List<Funcion> getListCineFunciones() {
        return listCineFunciones;
    }

    public void setListCineFunciones(List<Funcion> listCineFunciones) {
        this.listCineFunciones = listCineFunciones;
    }

    public List<Persona> getListCinePersonas() {
        return listCinePersonas;
    }

    public void setListCinePersonas(List<Persona> listCinePersonas) {
        this.listCinePersonas = listCinePersonas;
    }

    public List<Venta> getListCineVentas() {
        return listCineVentas;
    }

    public void setListCineVentas(List<Venta> listCineVentas) {
        this.listCineVentas = listCineVentas;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listCineSalas=" + listCineSalas +
                ", listCinePeliculas=" + listCinePeliculas +
                ", listCineFunciones=" + listCineFunciones +
                ", listCinePersonas=" + listCinePersonas +
                ", listCineVentas=" + listCineVentas +
                '}';
    }

    /**
     * Registra una pelicula en el catalogo verificando que el codigo no exista
     * @param pelicula a registrar
     * @return true si se registro, false si el codigo ya existe
     */
    public boolean registrarPelicula(Pelicula pelicula) {
        if (buscarPelicula(pelicula.getCodigo()) != null) {
            return false;
        }
        listCinePeliculas.add(pelicula);
        return true;
    }

    /**
     * Registra una sala verificando que el codigo no exista
     * @param sala a registrar
     * @return true si se registro, false si el codigo ya existe
     */
    public boolean registrarSala(Sala sala) {
        if (buscarSala(sala.getCodigo()) != null) {
            return false;
        }
        listCineSalas.add(sala);
        return true;
    }

    /**
     * Registra un cliente verificando que el documento no este repetido
     * @param cliente a registrar
     * @return true si se registro, false si el documento ya existe
     */
    public boolean registrarCliente(Cliente cliente) {
        if (buscarPersona(cliente.getDocumento()) != null) {
            return false;
        }
        listCinePersonas.add(cliente);
        return true;
    }

    /**
     * Registra un operario verificando que el documento no este repetido
     * @param operario a registrar
     * @return true si se registro, false si el documento ya existe
     */
    public boolean registrarOperario(Operario operario) {
        if (buscarPersona(operario.getDocumento()) != null) {
            return false;
        }
        listCinePersonas.add(operario);
        return true;
    }

    /**
     * Busca una pelicula por su codigo
     * @param codigo de la pelicula
     * @return la pelicula encontrada o null si no existe
     */
    public Pelicula buscarPelicula(String codigo) {
        for (Pelicula p : listCinePeliculas) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Busca una sala por su codigo
     * @param codigo de la sala
     * @return la sala encontrada o null si no existe
     */
    public Sala buscarSala(String codigo) {
        for (Sala s : listCineSalas) {
            if (s.getCodigo().equals(codigo)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Busca una funcion por su codigo
     * @param codigo de la funcion
     * @return la funcion encontrada o null si no existe
     */
    public Funcion buscarFuncion(String codigo) {
        for (Funcion f : listCineFunciones) {
            if (f.getCodigo().equals(codigo)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Busca una persona (cliente u operario) por su documento
     * @param documento de la persona
     * @return la persona encontrada o null si no existe
     */
    public Persona buscarPersona(String documento) {
        for (Persona p : listCinePersonas) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Busca un cliente por su documento
     * @param documento del cliente
     * @return el cliente encontrado o null si no existe o no es cliente
     */
    public Cliente buscarCliente(String documento) {
        Persona persona = buscarPersona(documento);
        if (persona instanceof Cliente) {
            return (Cliente) persona;
        }
        return null;
    }

    /**
     * Busca un operario por su documento
     * @param documento del operario
     * @return el operario encontrado o null si no existe o no es operario
     */
    public Operario buscarOperario(String documento) {
        Persona persona = buscarPersona(documento);
        if (persona instanceof Operario) {
            return (Operario) persona;
        }
        return null;
    }

    /**
     * Busca una venta por su codigo
     * @param codigo de la venta
     * @return la venta encontrada o null si no existe
     */
    public Venta buscarVenta(String codigo) {
        for (Venta v : listCineVentas) {
            if (v.getCodigo().equals(codigo)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Programa una funcion verificando que el codigo no exista y que
     * no haya conflicto de horario en la misma sala
     * @param funcion a programar
     * @return true si se programo, false si el codigo existe o hay conflicto de horario
     */
    public boolean programarFuncion(Funcion funcion) {
        if (buscarFuncion(funcion.getCodigo()) != null) {
            return false;
        }
        for (Funcion f : listCineFunciones) {
            if (funcion.hayConflicto(f)) {
                return false;
            }
        }
        listCineFunciones.add(funcion);
        return true;
    }

    /**
     * Registra una venta si el codigo no existe y tiene al menos una boleta
     * @param venta a registrar
     * @return true si se registro, false si el codigo existe o no tiene boletas
     */
    public boolean registrarVenta(Venta venta) {
        if (buscarVenta(venta.getCodigo()) != null) {
            return false;
        }
        if (venta.getListVentaBoletas().isEmpty()) {
            return false;
        }
        listCineVentas.add(venta);
        return true;
    }

    /**
     * Verifica si un asiento ya fue vendido para una funcion en las ventas registradas
     * @param funcion a consultar
     * @param fila del asiento
     * @param numeroAsiento a verificar
     * @return true si el asiento esta ocupado
     */
    public boolean asientoOcupado(Funcion funcion, int fila, int numeroAsiento) {
        for (Venta v : listCineVentas) {
            if (v.getTheFuncionVenta().getCodigo().equals(funcion.getCodigo())) {
                for (Boleta b : v.getListVentaBoletas()) {
                    if (b.getFila() == fila && b.getNumeroAsiento() == numeroAsiento) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Calcula el valor de una boleta: precio base, luego recargo por
     * tipo de sala y luego descuento del cliente
     * @param funcion de la boleta
     * @param cliente que compra la boleta
     * @return valor final de la boleta
     */
    public double calcularValorBoleta(Funcion funcion, Cliente cliente) {
        double valor = funcion.getPrecioBase();
        TipoSala tipo = funcion.getTheSalaFuncion().getTipoSala();

        if (tipo == TipoSala.VIP) {
            valor = valor + (valor * RECARGO_VIP);
        } else if (tipo == TipoSala.SALA_3D) {
            valor = valor + (valor * RECARGO_3D);
        }

        valor = valor - (valor * cliente.getPorcentajeDescuento() / 100);
        return valor;
    }

    /**
     * Agrega una boleta a la venta si el asiento existe en la sala
     * y no esta ocupado para la funcion
     * @param venta a la que se agrega la boleta
     * @param fila del asiento
     * @param numeroAsiento de la boleta
     * @return true si se agrego, false si el asiento no existe o esta ocupado
     */
    public boolean agregarBoleta(Venta venta, int fila, int numeroAsiento) {
        Funcion funcion = venta.getTheFuncionVenta();
        Sala sala = funcion.getTheSalaFuncion();

        if (fila < 1 || fila > sala.getFilas()
                || numeroAsiento < 1 || numeroAsiento > sala.getColumnas()) {
            return false;
        }
        if (asientoOcupado(funcion, fila, numeroAsiento)) {
            return false;
        }
        for (Boleta b : venta.getListVentaBoletas()) {
            if (b.getFila() == fila && b.getNumeroAsiento() == numeroAsiento) {
                return false;
            }
        }

        String codigoBoleta = venta.getCodigo() + "-B" + (venta.getListVentaBoletas().size() + 1);
        double valor = calcularValorBoleta(funcion, venta.getTheClienteVenta());
        venta.getListVentaBoletas().add(new Boleta(codigoBoleta, fila, numeroAsiento, valor));
        return true;
    }

    /**
     * Cuenta las boletas vendidas para una funcion
     * @param funcion a consultar
     * @return cantidad de boletas vendidas
     */
    public int contarBoletasVendidas(Funcion funcion) {
        int cantidad = 0;
        for (Venta v : listCineVentas) {
            if (v.getTheFuncionVenta().getCodigo().equals(funcion.getCodigo())) {
                cantidad += v.getListVentaBoletas().size();
            }
        }
        return cantidad;
    }

    /**
     * Calcula el porcentaje de ocupacion de una funcion segun las boletas
     * vendidas y la capacidad maxima de la sala
     * @param codigoFuncion de la funcion
     * @return porcentaje de ocupacion, o -1 si la funcion no existe
     */
    public double calcularOcupacionFuncion(String codigoFuncion) {
        Funcion funcion = buscarFuncion(codigoFuncion);
        if (funcion == null) {
            return -1;
        }
        int vendidas = contarBoletasVendidas(funcion);
        return (vendidas * 100.0) / funcion.getTheSalaFuncion().getCapacidadMaxima();
    }

    /**
     * Calcula los ingresos generados por una funcion sumando el total de sus ventas
     * @param codigoFuncion de la funcion
     * @return ingresos de la funcion, o -1 si la funcion no existe
     */
    public double calcularIngresosFuncion(String codigoFuncion) {
        Funcion funcion = buscarFuncion(codigoFuncion);
        if (funcion == null) {
            return -1;
        }
        double ingresos = 0;
        for (Venta v : listCineVentas) {
            if (v.getTheFuncionVenta().getCodigo().equals(funcion.getCodigo())) {
                ingresos += v.calcularTotal();
            }
        }
        return ingresos;
    }


    /**
     * Consulta las peliculas disponibles en el catalogo
     * @return texto con las peliculas registradas
     */
    public String consultarPeliculas() {
        if (listCinePeliculas.isEmpty()) {
            return "No hay películas registradas.";
        }
        String texto = "PELÍCULAS\n\n";
        for (Pelicula p : listCinePeliculas) {
            texto += p + "\n";
        }
        return texto;
    }
}