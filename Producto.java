
public class Producto{
    String nombre;
    int cantidad;
    int codigo;
    /**
     * Constructor de la clase Producto.
     *
     * @param nombre   El nombre del producto.
     * @param cantidad La cantidad inicial del producto en el inventario.
     * @param codigo   El código único del producto.
     */
        public Producto(String nombre, int cantidad, int codigo){
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.codigo = codigo;
        }
    /**
     * Reduce la cantidad del producto después de una compra.
     *
     * @param cantidadComprada La cantidad comprada que se debe restar al inventario.
     */
        public void Descontar(int cantidadComprada){
            this.cantidad -= cantidadComprada;
        }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
        public String getNombre(){
            return this.nombre;
        }
    /**
     * Obtiene el código único del producto.
     *
     * @return El código único del producto.
     */
        public int getCodigo(){
            return this.codigo;
        }
    /**
     * Obtiene la cantidad disponible del producto en el inventario.
     *
     * @return La cantidad disponible del producto en el inventario.
     */
        public int getCantidad(){
            return this.cantidad;
        }
    /**
     * Establece la cantidad del producto en el inventario.
     *
     * @param cantidad La nueva cantidad a reducir del inventario.
     */
        public void setCantidad(int cantidad){
            this.cantidad -= cantidad;
        }

}