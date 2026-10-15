package uniquindio.edu.co.model;

public class Cliente extends Persona {

    // atributos
    private String codigoAfiliacion;
    private double porcentajeDescuento;

    public Cliente(String documento, String nombre, String correo, String telefono) {
        super(documento, nombre, correo, telefono);
    }

    public Cliente(String documento, String nombre, String correo, String telefono, String codigoAfiliacion, double porcentajeDescuento) {
        super(documento, nombre, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento='" + getDocumento() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", codigoAfiliacion='" + codigoAfiliacion + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }
}