import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;


public class Reto2Funciones {
    //region Inner Class
    public static class Chofer {
        //region ATRIBUTOS
        private String _nombre;
        private Integer _telefono;
        //endregion
        //region PROPERTY
        public void setName(String name){_nombre=name;}
        public String getName(){return _nombre;}

        public void setPhone(Integer telefono){_telefono=telefono;}
        public Integer getPhone(){return _telefono;}
        //endregion
        //region CONSTRUCTOR
        /**Constructor completo.*/
        public Chofer(String nombre, Integer telefono){
            setName(nombre);
            setPhone(telefono);
        }
        //endregion
    }
    public static class Auto{
        //region ATRIBUTOS
            private String _matricula;
            private String _marca;
            private Boolean _esta;
        //endregion
        //region PROPERTY
            public void setMatricula(String matricula){_matricula=matricula;}
            public String getMatricula(){return _matricula;}

            public void setMarca(String marca){_marca=marca;}
            public String getMarca(){return _marca;}

            public void setEsta(boolean esta){_esta=esta;};
            public Boolean getEsta(){return _esta;};
            public Chofer Conductor;
        //endregion
        //region CONSTRUCTOR
            /**Contrsuctor completo.*/
            public Auto(String datos, Chofer conductor){
                String[] partes=datos.split("\\|");//Se realiza esto para poder utilizar el .add con 2 argumentos.
                setMatricula(partes[0].toUpperCase());
                setMarca(partes[1].toUpperCase());
                setEsta(true);
                Conductor=conductor;
            }
        //endregion
    }
    //endregion
    //region Funciones
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Auto> Vehiculos = new ArrayList<>();

        boolean bandera = true;
        String opcion, titulo = "?????????????????????????????????????????????\n??? El guardi??n ???\n?????????????????????????????????????????????\n", menuOpciones = "Opci??n 1 - Ingresar veh??culo.\nOpci??n 2 - Retirar veh??culo.\nOpci??n 3 - Listar los registros.\nCualquier otro caracter para Salir.";

        while (bandera) {
            System.out.println(titulo + menuOpciones);

            opcion = input.next();
            switch (opcion) {
                case "1":
                    if (Estacionados(Vehiculos) >4) System.out.println("La escuela se encuentra sin cupos.\n\n");
                    else System.out.println(titulo+Ingresar(titulo,input,Vehiculos));
                    break;
                case "2":
                    if (Estacionados(Vehiculos) >0){
                        System.out.print(titulo + "\nIngrese la matr??cula del veh??culo que se retira: ");
                        String matri = input.next().toUpperCase().trim();

                        Auto car = BuscarAuto(matri, Vehiculos);
                        if (car == null || !car.getEsta()) {
                            System.out.print("El veh??culo no se encuentra en el parking.\n\n");
                        } else {
                            car.setEsta(false);
                            System.out.print(titulo+"El veh??culo fue retirado con ??xito.\n\n");
                        }
                    }
                    else System.out.print("No hay veh??culos en el parking.\n\n");
                    break;
                case "3":
                    ArrayList<Auto> Listado =ListarPresentes(Vehiculos);
                    if (Listado!=null) {
                        String todos="\n";
                        for (Auto car:Listado) {todos+=MostrarUno(car);}//Se concatenan todos los datos de los veh??culos.
                        System.out.print(todos+"\n\n");
                    }
                    else System.out.print("No hay veh??culos en el parking.\n\n");
                    break;
                default:
                    System.out.println("??Hasta pronto!\n\n");
                    bandera = false;
                    break;
            }
        }
    }
    /**Solicita los datos necesarios para ingresar un veh??culo al parking devolviendo un String acorde a lo realizado.*/
    public static String Ingresar(String titulo, Scanner input, ArrayList<Auto> Vehiculos) {

        System.out.print("\nIngrese la matr??cula del veh??culo: ");
        String matricula = input.next().toUpperCase().trim();
        Auto car = BuscarAuto(matricula, Vehiculos);
        boolean bandera = true;
        if (car != null) {
            if (car.getEsta()) {return "\nEl veh??culo ya se encuentra en el parking.\n";}

            System.out.print("La matr??cula " + matricula + " ya posee registros: \n" + MostrarUno(car) + "Ingrese la opci??n deseada:\n'Guardar' para ingresarlo con esos datos.\nCualquier otro caracter para cambiar los datos. ");
            bandera = !"guardar".equals(input.next().toLowerCase().trim());
        }
        if (bandera) {
            System.out.print("\nIngrese la marca del veh??culo: ");
            String marca = input.next();
            String datosAuto = matricula + "|" + marca; //Concateno los datos para poder pasarlos como un ??nico par??metro al hacer .add() y luego separarlos en ClassAuto

            System.out.print("\nIngrese el n??mero de tel??fono del conductor: ");
            Integer tel = input.nextInt();

            input.nextLine();
            System.out.print("\nIngrese el nombre del conductor: ");
            String nombre = input.nextLine();

            if (car == null) {//Si no hab??a registro lo agrego.
                Auto a = new Auto(datosAuto, new Chofer(nombre, tel));//En la funci??n add() no permite crear el objeto por lo que creo esta referencia.
                return Vehiculos.add(a) ? "\nVeh??culo agregado con ??xito.\n" : "\nVeh??culo no agregado.\n";
            } else {//si ya exist??a registro lo modifico.
                car.setMarca(marca);
                car.Conductor.setName(nombre);
                car.Conductor.setPhone(tel);
            }
        }

        car.setEsta(true);//Simplemente modifico el atributo "Esta" para ingresar el veh??culo al parking.
        return "\nVeh??culo agregado con ??xito.\n";
    }

    /**Busca un elemento en el ArrayList pasado por par??metro, devuelve null o dicho elemento.*/
    public static Auto BuscarAuto(String matri, ArrayList<Auto> Vehiculos){
        Optional<Auto> ListaFiltrada=Vehiculos.stream().filter(auto -> matri.equals(auto.getMatricula())).findAny();
        return ListaFiltrada.isEmpty() ? null : ListaFiltrada.get();
    }

    /**Devuelve una lista con todos los auto con el atributo Esta==true o null en su defecto.*/
    public static ArrayList<Auto> ListarPresentes(ArrayList<Auto> Vehiculos){
        List<Auto> ListaFiltrada=Vehiculos.stream().filter(Auto::getEsta).collect(Collectors.toList());
        return ListaFiltrada.isEmpty() ? null : new ArrayList<Auto>(ListaFiltrada);
    }

    /**Devuelve la cantidad de veh??culos que hay en el parking.*/
    public static Integer Estacionados(ArrayList<Auto> Vehiculos){
        ArrayList<Auto> Listado=ListarPresentes(Vehiculos);
        return  Listado== null ? 0 : Listado.size();
    }

    /**Devuelve un String con los datos del veh??culo concatenados.*/ /*Soy consiente que deber??a sobrescribir ToString()*/
    public static String MostrarUno(Auto car){
        return  "Marca: "+car.getMarca()+"\nMatr??cula: "+ car.getMatricula()+"\nConductor: "+car.Conductor.getName()+"\nTel??fono: "+car.Conductor.getPhone()+"\n\n";
    }
    //endregion
}