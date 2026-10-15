package uniquindio.edu.co.model;

public class Funcion {

    // atributos
    private String codigo, fecha, horaInicio;
    private double precioBase;

    // relaciones
    private Pelicula thePeliculaFuncion;
    private Sala theSalaFuncion;

    /**
     * Metodo constructor de la clase Funcion
     * @param codigo de la funcion
     * @param fecha  de presentacion
     * @param horaInicio en  HH:mm
     * @param precioBase  de la boleta
     * @param thePeliculaFuncion pelicula que se proyecta
     * @param theSalaFuncion sala donde se proyecta
     */
    public Funcion(String codigo, String fecha, String horaInicio, double precioBase, Pelicula thePeliculaFuncion, Sala theSalaFuncion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.thePeliculaFuncion = thePeliculaFuncion;
        this.theSalaFuncion = theSalaFuncion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Pelicula getThePeliculaFuncion() {
        return thePeliculaFuncion;
    }

    public void setThePeliculaFuncion(Pelicula thePeliculaFuncion) {
        this.thePeliculaFuncion = thePeliculaFuncion;
    }

    public Sala getTheSalaFuncion() {
        return theSalaFuncion;
    }

    public void setTheSalaFuncion(Sala theSalaFuncion) {
        this.theSalaFuncion = theSalaFuncion;
    }

    /**
     * Convierte una hora en formato HH:mm a minutos desde la medianoche
     * @param hora en formato HH:mm
     * @return minutos desde las 00:00
     */
    private int aMinutos(String hora) {
        String[] partes = hora.trim().split(":");
        return Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);
    }

    /**
     * Verifica si esta funcion se cruza con otra en la misma sala y fecha,
     * usando la duracion de cada pelicula para saber cuando termina
     * @param f otra funcion
     * @return true si los horarios se superponen
     */
    public boolean hayConflicto(Funcion f) {
        if (!theSalaFuncion.getCodigo().equals(f.getTheSalaFuncion().getCodigo())) {
            return false;
        }
        if (!fecha.equals(f.getFecha())) {
            return false;
        }
        int inicioA = aMinutos(horaInicio);
        int finA = inicioA + thePeliculaFuncion.getDuracion();
        int inicioB = aMinutos(f.getHoraInicio());
        int finB = inicioB + f.getThePeliculaFuncion().getDuracion();
        return inicioA < finB && inicioB < finA;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", precioBase=" + precioBase +
                ", thePeliculaFuncion=" + thePeliculaFuncion +
                ", theSalaFuncion=" + theSalaFuncion +
                '}';
    }
}