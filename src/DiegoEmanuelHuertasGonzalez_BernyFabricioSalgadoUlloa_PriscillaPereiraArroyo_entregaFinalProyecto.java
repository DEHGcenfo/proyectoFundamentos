import java.io.*;
public class DiegoEmanuelHuertasGonzalez_BernyFabricioSalgadoUlloa_PriscillaPereiraArroyo_entregaFinalProyecto {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu()throws IOException{
        int opcionMenu, cantEquipo = 0;
        String [] equipos = new String [0];
        int [] numJuegos = new int [0];
        int [] numOponentes = new int [0];
        String [] resultados = new String [0];
        double [] puntajeTotal = new double [0];
       do {
        out.println("Opciones del menu");
        out.println("1. Iniciar el programa");
        out.println("2. Registrar la informacion de los arreglos");
        out.println("3. Construir el reporte del resultado de los juegos");
        out.println("4. Imprimir el reporte de resultado de los equipos");
        out.println("5. Imprimir el puntaje total de cada uno de los equipos");
        out.println("6. Calcular el promedio de oponentes diferentes que tienen todos los equipos del torneo");
        out.println("7. Imprimir el nombre del equipo con mas partidos");
        out.println("8. Imprimir el nombre del equipo con menor puntaje");
        out.println("9. Imprimir los nombres de equipos con 5 partidos jugados o mas");
        out.println("10. Imprimir el nombre de los equipos con mas oponentes que el promedio de oponentes generales");
        out.println("11. Salir");
        opcionMenu = Integer.parseInt(in.readLine());


        switch(opcionMenu){
            
            case 1: 
                cantEquipo = iniciarPrograma();
                equipos = new String [cantEquipo];
                numJuegos = new int [cantEquipo];
                numOponentes = new int [cantEquipo];
                resultados = new String [cantEquipo];
                puntajeTotal = new double [cantEquipo];
                
            break;
            
            case 2:
                registrarInfo(equipos, numJuegos, numOponentes);
            break;
                
            case 3:
            construirReporte(equipos, numJuegos, numOponentes, resultados, puntajeTotal);
            break;
            
            case 4:

            break;
            case 5:
            break;
            case 6:
            break;
            case 7:
            break;
            case 8:
            break;
            case 9:
            break;
            case 10:
            break;
            case 11:
            break;
        }
       } while (opcionMenu != 11);
        
    }

    
    //Devuelve un array de strings los cuales son los equipos
    public static String[] obtenerEquipos(int tamanio){
        String [] equipos = new String [tamanio];

        return equipos;
    }
    //Devuelve un array de enteros usado para numero juegos y numero de oponentes.
    public static int[] obtenerArreglosInt(int tamanio){
        int [] arreglo = new int [tamanio];

        return arreglo;
    }


    public static int iniciarPrograma() throws IOException{
        int cantEquipos;
        out.print("Digite la cantidad de equipos: ");
        cantEquipos = Integer.parseInt(in.readLine());
       
        return cantEquipos;
    }

    

    public static void registrarInfo(String [] equipos, int [] numJuegos, int [] numOponentes)throws IOException{
        String nombreEquipo;
        int numOponentesEquipo, numJuegosEquipo;

        

        for(int i = 0; i<equipos.length; i++){
            out.print("Ingrese el nombre del equipo "+ (i+1)+": ");
            nombreEquipo = in.readLine();
            equipos[i] = nombreEquipo;

            out.print("Ingrese el numero de juegos del equipo "+ (equipos[i])+": ");
            numJuegosEquipo = Integer.parseInt(in.readLine());
            numJuegos[i] = numJuegosEquipo;

            out.print("Ingrese el numero de oponentes del equipo "+ (equipos[i])+": ");
            numOponentesEquipo = Integer.parseInt(in.readLine());
            numOponentes[i] = numOponentesEquipo;

        }  
        
        

    }

    public static void construirReporte(String [] equipos, int [] numJuegos, int [] numOponentes, String [] resultados, double [] puntajeTotal) throws IOException{

        for(int j = 0; j< equipos.length ; j++){
            String resultadoGeneral ="";
            double ptsTotal=0;
            out.print("Ingrese la informacion del equipo " + equipos[j]);
            
            for (int i=0; i<numJuegos[j]; i++) {

                int cantidadPartidos,ptsEquipoPrimario,ptsEquipoOponente;
                String equipoOponente="", equipoPrimario="",snitchEquipoPrimario,  resultadoPartido="";
                
                out.print("\nJuego " + (i+1) + " contra: "  );
                equipoOponente= in.readLine();  
                
                out.print("Marcador de " + equipos[j] + ": "  );
                ptsEquipoPrimario = Integer.parseInt(in.readLine());
                ptsTotal += ptsEquipoPrimario;

                
                do {
                    out.print("Atrapó la snitch, digite si o no: ");
                    snitchEquipoPrimario = in.readLine();
                    snitchEquipoPrimario = snitchEquipoPrimario.toLowerCase();

                    if ((!snitchEquipoPrimario. equals("si")) && (!snitchEquipoPrimario. equals("no")))
                    {
                        out.println("Error, usted debe de digitar si o no");
                    }
                }   while ((!snitchEquipoPrimario. equals("si")) && (!snitchEquipoPrimario. equals("no")));
                
                out.print("Marcador de " + equipoOponente + ": "  );
                ptsEquipoOponente = Integer.parseInt(in.readLine());

                if (snitchEquipoPrimario.equals("si"))
                {
                    resultadoPartido = equipos[j] + " vs " + equipoOponente + " " + ptsEquipoPrimario + "*-" + ptsEquipoOponente;
                    resultadoGeneral += "\n" +  resultadoPartido;
                }
                else
                {
                    resultadoPartido = equipos[j] + " vs " + equipoOponente + " " + ptsEquipoPrimario + "-" + ptsEquipoOponente + "*";
                    resultadoGeneral += "\n" +  resultadoPartido;
                }

                

                //Puntaje por número de juegos:
                if (numJuegos[j] >= 5) {
                    ptsTotal += 1;
                } 
                else {
                    ptsTotal += ( (Math.sqrt(numJuegos[j])) / 2.25 );
                }
        
                //Puntaje por número de oponentes:
                if (numOponentes[j] == 1) {
                    ptsTotal += 1/3;
                }
                else {
                    if (numOponentes[j] == 2) {
                        ptsTotal += 2/3;
                    }
                    else {
                        if (numOponentes[j] >= 3) {
                            ptsTotal += 1;
                        }
                    }
                }

            }

            out.println("El resultado general de todos los partidos del primer equipo es: "+ resultadoGeneral);
            puntajeTotal[j] = ptsTotal; 
            resultados[j] = resultadoGeneral;
            out.println("El puntaje total es de: " + puntajeTotal[j]);
            
        }
        

       
    }

    
}