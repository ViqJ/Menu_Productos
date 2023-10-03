public class Ventas {
    int codigoProducto;
    String nombreProducto;
    int cantidadVenta;

    public Ventas(int codigoProducto, String nombreProducto, int cantidadVenta){
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadVenta = cantidadVenta;
        
    }


    public int getcodigoProducto() {
        return this.codigoProducto;
    }
    public String getnombreProducto() {
        return this.nombreProducto;
    }
    public int getcantidadVenta() {
        return this.cantidadVenta;
    }
    public void setcodigoProducto(int codigoProducto){
        this.codigoProducto = codigoProducto;
    }
    public void setnombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    public void setcantidadVenta(int cantidadVenta){
        this.cantidadVenta = cantidadVenta;
    }

}
