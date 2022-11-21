import java.util.*;

public class Reto1Funciones {
    public static class Cliente {
        //region ATRIBUTOS
            private String _nombre;
            private boolean _curso;
            private boolean _aprobo;
        //endregion
        //region PROPERTY
            public void setName(String name){_nombre=name;}
            public String getName(){return _nombre;}

            public void setCurso(Boolean presento){
                _curso =presento;}
            public boolean getCurso(){return _curso;}

            public void setAprobo(Boolean aprobo){_aprobo=aprobo;}
            public boolean getAprobo(){return _aprobo;}
        //endregion
        //region CONTRUSCTOR
            /**Constructor completo.*/
            public Cliente(String nombre, Boolean curso, Boolean aprobo){
                setName(nombre);
                setCurso(curso);
                setAprobo(aprobo);
            }
        //endregion
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Cliente> clientes= new ArrayList<>();
        boolean bandera=true;
        String opcion, titulo="╔════════════╗\n║ El Maestro ║\n╚════════════╝\n",menuOpciones="Opción 1 - Ingresar cliente.\nOpción 2 - Listar un clientes.\nOpción 3 - Listar todos los clientes.\nCualquier otro caracter para Salir.";

        while  (bandera) {
            System.out.println(titulo + menuOpciones);
            opcion=input.next();
            switch (opcion) {
                case "1":
                    if (clientes.size()>7) System.out.println("\nLa escuela se encuentra sin cupos.\n");
                    else {
                        System.out.print(titulo + "\nIngrese el nombre del cliente: ");
                        String name = input.next();

                        System.out.print("Ingrese si cursó: (SI/NO) ");
                        boolean curso = "si".equals(input.next().toLowerCase().trim());
                        boolean aprobo;
                        if (curso) {
                            System.out.print("Ingrese si aprobó: (SI/NO) ");
                            aprobo = "si".equals(input.next().toLowerCase().trim());
                        } else aprobo = false;
                        String respuesta = clientes.add(new Cliente(name, curso, aprobo)) ? "Cliente agregado con éxito.\n" : "No se agregó el cliente.\n";
                        System.out.println(respuesta);
                    }
                    break;
                case "2":
                    System.out.println(ListarUnCliente(clientes,input));
                    break;
                case "3":
                    System.out.println(ListarTodos(clientes,input));
                    break;
                default: System.out.println("\n¡Hasta pronto!\n\n"); bandera=false; break;
            }
        }
    }
    private static String ListarUnCliente (ArrayList<Cliente>clientes, Scanner input){
        if (!clientes.isEmpty()) {
            System.out.print("Ingrese el nombre del cliente: ");
            String Nombre = input.next();

            Optional<Cliente> ListFilter = clientes.stream().filter(cliente -> cliente.getName().equals(Nombre)).findAny();//Devuelve el objeto Cliente en caso de que exista.

            Cliente c = ListFilter.isEmpty() ? null : ListFilter.get();//En caso de haber filtrado la lista y que esté vacía hago que la referencia al objeto sea null.
            if (c == null)
                return "No se tiene registro de un cliente con nombre " + Nombre + ".\n";
            else {
                String ap = c.getAprobo() ? "Si" : "No";
                String pre = c.getCurso() ? "Si" : "No";
                return "Nombre: " + c.getName() + "\nCursó: " + pre + "\nAprobó: " + ap+"\n";
            }
        }
        return "No hay registros de clientes.\n";
    }
    private static String ListarTodos(ArrayList<Cliente> clientes, Scanner input){
        if (!clientes.isEmpty()) {
            String respuesta="";
            for (Cliente item: clientes) {
                String ap = item.getAprobo() ? "Si" : "No";
                String pre = item.getCurso() ? "Si" : "No";
                respuesta+="Nombre: "+item.getName()+ "\nCursó: " + pre + "\nAprobó: " + ap+"\n\n";
            }
            return respuesta;
        }
        return "No hay registros de clientes.\n";
    }
}
