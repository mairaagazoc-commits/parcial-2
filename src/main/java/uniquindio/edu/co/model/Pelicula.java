package uniquindio.edu.co.model;

public class Pelicula {

    // atributos
    private String codigo,titulo,clasificacion;
    private int duracion;


    // relaciones
    private Genero genero;

    /**
     * Metodo constructor de la clase Pelicula
     * @param codigo        de la pelicula
     * @param titulo        de la pelicula
     * @param duracion      en minutos
     * @param clasificacion por edad
     * @param genero        de la pelicula
     */
    public Pelicula(String codigo, String titulo, int duracion, String clasificacion, Genero genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", genero=" + genero +
                '}';
    }
}