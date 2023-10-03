import java.util.Scanner;

public class Menu {
    public Scanner entrada = new Scanner(System.in);
    public String [] opcionesMenu = {"1. Agregar un producto","2. Comprar un producto","3. Ver ventas","4. Salir"};
    
    public Menu(){
    }
    public void mostrar(){
        System.out.println("----------Menu----------");
        for(String opcion:opcionesMenu){
            System.out.println(opcion);
        }
    }
    public int selecionarOpcion(){
        int seleccion = 0;
        System.out.print("Seleccione opcion: ");
        while(true){
            if(entrada.hasNextInt()){
            seleccion = entrada.nextInt();
            if( seleccion>=1 && seleccion <= opcionesMenu.length ){
                break;
            }else
            System.out.print("Opcion no valida, vuelva a intentar: ");
            }else{
            System.out.print("Entrada no valida, vuelva a intentar: ");
            entrada.next();
            }
        }
        return seleccion;
    }
}
