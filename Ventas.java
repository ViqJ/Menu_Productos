/**
 * La clase Ventas representa una transaccion de venta de un producto.
 */
public class Ventas {
    int codigoProducto;
    String nombreProducto;
    int cantidadVenta;
    /**
     * Constructor de la clase Ventas.
     *
     * @param codigoProducto   El codigo del producto vendido.
     * @param nombreProducto   El nombre del producto vendido.
     * @param cantidadVenta    La cantidad vendida del producto.
     */
    public Ventas(int codigoProducto, String nombreProducto, int cantidadVenta){
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadVenta = cantidadVenta;
        
    }
    /**
     * Obtiene el codigo del producto vendido.
     *
     * @return El codigo del producto vendido.
     */
    public int getCodigoProducto() {
        return this.codigoProducto;
    }
    /**
     * Obtiene el nombre del producto vendido.
     *
     * @return El nombre del producto vendido.
     */
    public String getNombreProducto() {
        return this.nombreProducto;
    }
    /**
     * Obtiene la cantidad vendida del producto.
     *
     * @return La cantidad vendida del producto.
     */
    public int getCantidadVenta() {
        return this.cantidadVenta;
    }
    /**
     * Establece el codigo del producto vendido.
     *
     * @param codigoProducto El nuevo codigo del producto vendido.
     */
    public void setCodigoProducto(int codigoProducto){
        this.codigoProducto = codigoProducto;
    }
    /**
     * Establece el nombre del producto vendido.
     *
     * @param nombreProducto El nuevo nombre del producto vendido.
     */
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    /**
     * Establece la cantidad vendida del producto.
     *
     * @param cantidadVenta La nueva cantidad vendida del producto.
     */
    public void setCantidadVenta(int cantidadVenta){
        this.cantidadVenta = cantidadVenta;
    }

}
