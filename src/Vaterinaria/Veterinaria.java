package Vaterinaria;

/* Veronica Velasco Jiménez 221224
   Marco Darinel Ortiz Díaz 221213
*/
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Veterinaria {
    public static void main(String[] args) {
        double VentaTotal = 0;
        ArrayList<Mascota> ListaMascota= new ArrayList<>();
        ArrayList <Carnet> Carnet=new ArrayList<>();
        ArrayList <Cliente> ListaCliente= new ArrayList<>();
        ArrayList <Producto> ListaProductos= new ArrayList<>();
        ListaProductos.add(new Medicamento(1,"Medicamento",250,"Vitaminas","Perros"));
        ListaProductos.add(new Medicamento(2,"Lombix",300,"Desparacitante","Ganado"));
        ListaProductos.add(new Accesorio(3,"Collar",50,"Collar","Perro"));
        ListaProductos.add(new Accesorio(4,"Pelota",60,"Juguete","Perro"));
        Scanner entrada = new Scanner(System.in);
        int opcion,id=1;
        String nombre;
        do {
            System.out.println("Bienvenido, por favor digite una opcion :" +
                    "\n1.Registrar Cliente " +
                    "\n2.Ver Mascotas" +
                    "\n3.Realizar Expediente Clinico" +
                    "\n4.Imprimir Expediente" +
                    "\n5.Comprar Producto" +
                    "\n6.Ver venta total" +
                    "\n7.Salir");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Nombre: ");
                    nombre= entrada.next();
                    id+=id;
                    ListaCliente.add(new Cliente(id,nombre));
                    System.out.println("Cuantas mascotas va a registrar?");
                    opcion= entrada.nextInt();
                    for (int i=1; i<=opcion;i++){
                        int edad;
                        String genero,tipo;
                        System.out.println("Nombre:");
                        nombre= entrada.next();
                        System.out.println("Edad: ");
                        edad=entrada.nextInt();
                        System.out.println("Genero");
                        genero=entrada.next();
                        System.out.println("Tipo de animal");
                        tipo= entrada.next();
                        ListaMascota.add(new Mascota(id,nombre,edad,tipo,genero));
                    }
                    break;
                case 2:
                    System.out.println("Nombre de cliente: ");
                    String buscar;
                    int idBuscar = 1;

                    buscar= entrada.next();
                    bUSCAR: for (Cliente cliente : ListaCliente){
                        if (cliente.getNombre().equals(buscar)){
                            System.out.println("Encontrado: ");
                            idBuscar= cliente.getId();
                            System.out.println("Nombre: " + cliente.getNombre());
                        }

                    }
                    buscar: for (Mascota mascota : ListaMascota){
                        if (mascota.getId()==idBuscar){
                            System.out.println("Nombre de la mascota "+ mascota.getNombre());
                        }
                    }
                    break;
                case  3:
                    System.out.println("Digite el nombre de la mascota");
                    nombre= entrada.next();
                    String estado,vacunas;
                    double peso;
                    buscar: for (Mascota mascota : ListaMascota){
                        if (mascota.getNombre().equals(nombre)){
                            System.out.println("Estado de la mascota (Bueno, Grave, Delicado): ");
                            estado= entrada.next();
                            System.out.println("Peso de la mascota: ");
                            peso= entrada.nextDouble();
                            id=mascota.getId();
                            System.out.println("Vacunas: ");
                            vacunas= entrada.next();

                            Carnet.add(new Carnet(id,mascota.getNombre(),mascota.getEdad(),mascota.getTipo(),
                                    mascota.getGenero(),estado,peso,vacunas,new Date() ));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nombre de la mascota: ");
                    nombre= entrada.next();
                    buscar: for (Carnet carnet : Carnet){
                        if (carnet.getNombre().equals(nombre)){
                            System.out.println("Nombre de la mascota: "+ carnet.getNombre());
                            System.out.print("Edad: "+ carnet.getEdad() + "\n");
                            System.out.print("Tipo: "+ carnet.getTipo() + "\n");
                            System.out.print("Genero: "+ carnet.getGenero() + "\n");
                            System.out.print("Estado: "+ carnet.getEstado()+ "\n");
                            System.out.print("Peso: "+carnet.getPeso() + "\n");
                            System.out.print("Vacunas: "+carnet.getVacunas() + "\n");
                        }
                    }
                    break;
                case 5:
                    boolean validar=false;
                    do {
                        System.out.println("Que desea comprar?");
                        IMPRIMIR : for (Producto producto: ListaProductos){
                            System.out.println("Nombre "+ producto.getNombre());
                            System.out.println("Precio "+producto.getPrecio());
                        }
                        System.out.println("Escoja el producto: ");
                        nombre= entrada.next();
                        buscar: for (Producto producto: ListaProductos){
                            if (producto.getNombre().equals(nombre)){
                                VentaTotal+=producto.getPrecio();
                                validar=true;
                                System.out.println("Usted compro: "+ producto.getNombre());
                            }
                        }
                    }while (!validar);
                    break;
                case 6:
                    System.out.println("La venta total es: " + VentaTotal);
                    break;
            }
        }    while (opcion<=6);
    }
}
