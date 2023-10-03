
import java.util.Scanner;


class Principal{
    /**
     * El método main es el punto de entrada principal para la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args){
        int productosActuales = 3;
        int totalProductos = 10;
        String[] encabezadoProductos = {"Codigo","Nombre","Cantidad"};
        String[] encabezadoVentas = {"Codigo","Nombre","CantidadVenta"};
        int espaciosEncabezados = 19;
        Menu menu1 = new Menu();
        Producto[]  listaProductos = new Producto[totalProductos];
        listaProductos = inicializarProductos(totalProductos);
        Ventas[] ventasRealizadas = new Ventas[100];
        int contadorVentas = 0;
        int[] valoresVenta = new int[2];
        boolean salir = false;
        // Bucle principal del programa
        while(true){
            if(salir) break;
            menu1.mostrar();
            switch(menu1.selecionarOpcion()){
                case 1:
                    mostrarProductos(listaProductos,encabezadoProductos,espaciosEncabezados);
                    if(productosActuales==totalProductos){
                        System.out.println("Lista completa, no se puede agregar productos");
                    }else{
                        listaProductos = agregarProducto(listaProductos);
                        System.out.println("Producto agregado correctamente");
                        productosActuales++;
                    }
                    break;
                case 2:
                    mostrarProductos(listaProductos,encabezadoProductos,espaciosEncabezados);
                    valoresVenta = comprarProducto(listaProductos);
                    int indiceVenta = valoresVenta[0];
                    int cantidadVenta = valoresVenta[1];
                    if(cantidadVenta > 0){
                        Ventas venta = new Ventas(listaProductos[indiceVenta].getCodigo(),listaProductos[indiceVenta].getNombre(),cantidadVenta);
                        ventasRealizadas [contadorVentas] = venta;
                        listaProductos[indiceVenta].setCantidad(cantidadVenta);
                        contadorVentas++;
                    }
                    break;
                case 3:
                    imprimirVentas(ventasRealizadas,encabezadoVentas,espaciosEncabezados);
                    break;
                case 4:
                    System.out.println("Muchas gracias");
                    salir = true;
                    break;
                default:
                    System.out.println("Error");
            }
        }


    }

    /**
     * Agrega un nuevo producto a la lista de productos.
     *
     * @param listaActual La lista actual de productos.
     * @return La lista actualizada de productos después de agregar un nuevo producto.
     */
    static Producto[] agregarProducto (Producto[] listaActual){
        int indice = 0;
        while(indice < listaActual.length && listaActual[indice]!=null){
            indice++;
        }
        listaActual[indice] = obtenerDatosProducto(listaActual,indice);
        return listaActual;
    }

    /**
     * Obtiene los datos de un nuevo producto del usuario.
     *
     * @param listaActual La lista actual de productos.
     * @param indice      El índice en el que se debe agregar el nuevo producto.
     * @return Una lista de enteros los datos ingresados por el usuario.
     */
    static Producto obtenerDatosProducto(Producto[] listaActual, int indice){
        Scanner entrada2 = new Scanner(System.in);
        String nombreProducto;
        int cantidadProducto;
        int codigoProducto;
        boolean valorExiste = false;
        //Validacion de nombre de producto
        System.out.print("Digite nombre de producto: ");
        while(true){
            if(entrada2.hasNextInt()){
                System.out.print("Nombre no válido, vuelva a intentarlo: ");
                entrada2.next();
                
                continue;
            }
            nombreProducto = entrada2.next();
            valorExiste = false;
            for(Producto product:listaActual){
                if(product!=null && nombreProducto.equals(product.getNombre())){
                    System.out.print("Este nombre de producto ya existe, vueva a intentarlo: ");
                    valorExiste = true;
                    break;
                }
            }
            if(!valorExiste){
                System.out.println("Se guardó el nombre correctamente");
                break;
            }
            
        }
        //validacion de cantidad de producto
        System.out.print("Digite cantidad de productos: ");
        while(true){
            if(entrada2.hasNextInt()){
                cantidadProducto = entrada2.nextInt();
                if(cantidadProducto > 0){
                System.out.println("Se guardó la cantidad de producto correctamente");
                break;
                }else
                System.out.print("Valor no valido, vuelva a intentar: ");
                }else{
                System.out.print("Entrada no valida, vuelva a intentar: ");
                entrada2.next();
                }
        }
        //validacion de codigo de producto
        /*Opción usuario digita numero positivo 
        System.out.print("Digite codigo de producto: ");
        while(true){
            if(entrada2.hasNextInt()){
            codigoProducto = entrada2.nextInt();
            valorExiste = false;
            if(codigoProducto<=0){
                System.out.print("Codigo no valido, vueva a intentarlo: ");
            }else{
            for(Producto product:listaActual){
                if(product!=null && codigoProducto==product.getCodigo()){
                    System.out.print("Este codigo de producto ya existe, vueva a intentarlo: ");
                    valorExiste = true;
                    break;
                }
            }
            if(!valorExiste){
                System.out.println("Se guardó el codigo de producto correctamente");
                break;
            }
            }
            }else{
                System.out.print("Entrada no valida, vuelva a intentar: ");
                entrada2.next();
            }
        }
        */
        //Opcion automatica
        codigoProducto = (indice == 0) ? 1 : (listaActual[indice-1].getCodigo())+1;

        Producto datosProducto = new Producto(nombreProducto,cantidadProducto,codigoProducto);
        return datosProducto;
    }

    /**
     * Inicializa la lista de productos con algunos productos predefinidos.
     *
     * @param totalProductos El número total de productos a inicializar.
     * @return Una lista de productos inicializada.
     */
    static Producto[] inicializarProductos(int totalProductos){
        Producto[] listaInicial = new Producto[totalProductos];
        listaInicial[0] = new Producto("pina",2,1);
        listaInicial[1] = new Producto("naranja",5,2);
        listaInicial[2] = new Producto("limon",7,3);
        return listaInicial;
    }

    static void mostrarProductos(Producto[] listaActual,String [] encabezado,int espacios){
        for(Producto producto:listaActual){
            if(producto!=null){
                if(producto.getNombre().length()>espacios){
                    espacios = producto.getNombre().length();
                }
            }
        }
        for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
            System.out.print("_");
        }
        System.out.println("");

        System.out.print("|");
        for(String nombre:encabezado){
            System.out.print(nombre);
            for(int i=0;i<espacios-nombre.length();i++){
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println("");
        for(Producto product:listaActual){
            if(product!=null){
                System.out.print("|");
                System.out.print(product.codigo);
                for(int i=0;i<espacios-String.valueOf(product.codigo).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(product.nombre);
                for(int i=0;i<espacios-product.nombre.length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(product.cantidad);
                for(int i=0;i<espacios-String.valueOf(product.cantidad).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.println("");
            }else{
                break;
            }

        }
            for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
                System.out.print("-");
            }
                System.out.println("");
}

static int[] comprarProducto(Producto[] listaActual) {
    Scanner entrada2 = new Scanner(System.in);
    int cantidadProducto = 0;
    int codigoProducto;
    int indice = 0;

    while (true) {
        System.out.print("Digite codigo de producto a comprar: ");
        if (entrada2.hasNextInt()) {
            codigoProducto = entrada2.nextInt();
            boolean productoEncontrado = false;
            for (int i = 0; i < listaActual.length; i++) {
                if (listaActual[i] != null && codigoProducto == listaActual[i].getCodigo()) {
                    productoEncontrado = true;
                    if (listaActual[i].getCantidad() == 0) {
                        System.out.print("Producto con stock insuficiente. ¿Desea volver al menú? 1.Si, 2.No: ");
                        int respueSalir;
                        while (true) {
                            if (entrada2.hasNextInt()) {
                                respueSalir = entrada2.nextInt();
                                if (respueSalir == 1 || respueSalir == 2) {
                                    break;
                                } else {
                                    System.out.print("Opción no válida, vuelva a intentarlo: ");
                                }
                            } else {
                                System.out.print("Valor no válido, vuelva a intentar: ");
                                entrada2.next();
                            }
                        }
                        if (respueSalir == 1) {
                            return new int[]{-1, 0}; // Indica que no se realizó ninguna venta
                        }
                    } else {
                        // validacion de cantidad de producto
                        System.out.print("Digite cantidad de productos a comprar: ");
                        while (true) {
                            if (entrada2.hasNextInt()) {
                                cantidadProducto = entrada2.nextInt();
                                if (cantidadProducto > 0 && listaActual[i].getCantidad() - cantidadProducto >= 0) {
                                    System.out.println("Se realizó venta, muchas gracias");
                                    indice = i;
                                    return new int[]{indice, cantidadProducto}; // Indica que se realizó una venta
                                } else {
                                    if(cantidadProducto<=0){
                                        System.out.print("Valor no valido , vuelva a intentarlo: ");
                                    }else{
                                    System.out.print("Stock insuficiente, vuelva a intentarlo: ");
                                    }
                                }
                            } else {
                                System.out.print("Entrada no válida, vuelva a intentar: ");
                                entrada2.next();
                            }
                        }
                    }
                }
            }
            if (!productoEncontrado) {
                System.out.println("Código de producto no encontrado. Vuelva a intentarlo.");
            }
        } else {
            System.out.print("Entrada no válida, vuelva a intentar: ");
            entrada2.next();
        }
    }
}



    static void imprimirVentas(Ventas[] ventasActuales,String [] encabezado,int espacios){
        for(Ventas producto:ventasActuales){
            if(producto!=null){
                if(producto.getNombreProducto().length()>espacios){
                    espacios = producto.getNombreProducto().length();
                }
            }
        }
        for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
            System.out.print("_");
        }
        System.out.println("");

        System.out.print("|");
        for(String nombre:encabezado){
            System.out.print(nombre);
            for(int i=0;i<espacios-nombre.length();i++){
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println("");
        for(Ventas product:ventasActuales){
            if(product!=null){
                System.out.print("|");
                System.out.print(product.codigoProducto);
                for(int i=0;i<espacios-String.valueOf(product.getCodigoProducto()).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(product.nombreProducto);
                for(int i=0;i<espacios-product.getNombreProducto().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(product.cantidadVenta);
                for(int i=0;i<espacios-String.valueOf(product.getCantidadVenta()).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.println("");
            }else{
                break;
            }

        }
            for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
                System.out.print("-");
            }
                System.out.println("");
}
}