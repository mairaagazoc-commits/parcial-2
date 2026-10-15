package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    // atributos
    private String codigo;
    private String fecha;

    // relaciones
    private Cliente theClienteVenta;
    private Operario theOperarioVenta;
    private Funcion theFuncionVenta;
    private List<Boleta> listVentaBoletas;

    /**
     * Metodo constructor de la clase Venta
     * @param codigo de la venta
     * @param fecha   de la venta
     * @param theClienteVenta  cliente de la venta
     * @param theOperarioVenta operario que registra la venta
     * @param theFuncionVenta  funcion de la venta
     */
    public Venta(String codigo, String fecha, Cliente theClienteVenta, Operario theOperarioVenta, Funcion theFuncionVenta) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.theClienteVenta = theClienteVenta;
        this.theOperarioVenta = theOperarioVenta;
        this.theFuncionVenta = theFuncionVenta;
        this.listVentaBoletas = new ArrayList<>();
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

    public Cliente getTheClienteVenta() {
        return theClienteVenta;
    }

    public void setTheClienteVenta(Cliente theClienteVenta) {
        this.theClienteVenta = theClienteVenta;
    }

    public Operario getTheOperarioVenta() {
        return theOperarioVenta;
    }

    public void setTheOperarioVenta(Operario theOperarioVenta) {
        this.theOperarioVenta = theOperarioVenta;
    }

    public Funcion getTheFuncionVenta() {
        return theFuncionVenta;
    }

    public void setTheFuncionVenta(Funcion theFuncionVenta) {
        this.theFuncionVenta = theFuncionVenta;
    }

    public List<Boleta> getListVentaBoletas() {
        return listVentaBoletas;
    }

    public void setListVentaBoletas(List<Boleta> listVentaBoletas) {
        this.listVentaBoletas = listVentaBoletas;
    }

    /**
     * Calcula el valor total de la venta sumando el valor de cada boleta
     * @return total de la venta
     */
    public double calcularTotal() {
        double total = 0;
        for (Boleta b : listVentaBoletas) {
            total += b.getValor();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", theClienteVenta=" + theClienteVenta +
                ", theOperarioVenta=" + theOperarioVenta +
                ", theFuncionVenta=" + theFuncionVenta +
                ", listVentaBoletas=" + listVentaBoletas +
                '}';
    }
}