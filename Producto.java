public class Producto{
    String nombre;
    int cantidad;
    int codigo;

        public Producto(String nombre, int cantidad, int codigo){
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.codigo = codigo;
        }
        public void Descontar(int cantidadComprada){
            this.cantidad -= cantidadComprada;
        }
        public String getNombre(){
            return this.nombre;
        }
        public int getCodigo(){
            return this.codigo;
        }
        public int getCantidad(){
            return this.cantidad;
        }
        public void setCantidad(int cantidad){
            this.cantidad -= cantidad;
        }

}