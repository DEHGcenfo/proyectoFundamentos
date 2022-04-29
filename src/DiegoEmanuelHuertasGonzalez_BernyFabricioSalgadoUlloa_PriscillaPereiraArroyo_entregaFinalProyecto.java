import java.io.*;
public class DiegoEmanuelHuertasGonzalez_BernyFabricioSalgadoUlloa_PriscillaPereiraArroyo_entregaFinalProyecto {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu()throws IOException{
        
        int opcionMenu, cantEquipo = 0;
        double promedioOponentes = 0;

        String [] equipos = new String [0],
                  resultados = new String [0];

        int [] numJuegos = new int [0], 
               numOponentes = new int [0];
    
        double [] puntajeTotal = new double [0];

       do {
        out.println("\n\nOpciones del menu");
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
        out.print("Ingrese el numero de la opcion que deseas escoger: ");
        opcionMenu = Integer.parseInt(in.readLine());


        switch(opcionMenu){
            
            case 1: 

                cantEquipo = obtenerCantidadEquipos();
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
                promedioOponentes = obtenerPromedioOpenentes(numOponentes);
            break;
            
            case 7:
                imprimirEquicoMasPartidos(equipos, numJuegos);
            break;
            
            case 8:
                imprimirEquicoMenosPartidos(equipos, numJuegos);
            break;
            
            case 9:
            imprimirEquipos5Partidos(equipos, numJuegos);
            break;
            
            case 10:
                ObtenerEquiposMasOponentes(promedioOponentes, equipos, numOponentes);
            break;

            case 11:
                out.println("Programa Finalizado");
                System.exit(0);
            break;
            
            default:
                out.println("----------");
                out.println("Opcion incorrecta"); 
                out.println("----------");
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

    //Obtiene y devuelve la cantidad de equipos que el usuario desea
    public static int obtenerCantidadEquipos() throws IOException{
        int cantEquipos;
        out.print("\n\nDigite la cantidad de equipos: ");
        cantEquipos = Integer.parseInt(in.readLine());
       
        return cantEquipos;
    }

    //Solicita la informacion correspondiente para cada arreglo (Equipos - Numero de Juegos de los Equipos - Numero de Openentes de los Equipos)
    public static void registrarInfo(String [] equipos, int [] numJuegos, int [] numOponentes)throws IOException{
        String nombreEquipo;
        int numOponentesEquipo, numJuegosEquipo;

        for(int i = 0; i<equipos.length; i++){
            out.print("\nIngrese el nombre del equipo "+ (i+1)+": ");
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

    //Construye el reporte general de resultados solicitando la informacion necesaria al usuario
    public static void construirReporte(String [] equipos, int [] numJuegos, int [] numOponentes, String [] resultados, double [] puntajeTotal) throws IOException{
        
        String resultadoGeneral;
        double ptsTotal;

        for(int j = 0; j< equipos.length ; j++){
            
            resultadoGeneral = "";
            ptsTotal = 0;

            out.print("Ingrese la informacion del equipo " + equipos[j]);
            
            for (int i=0; i<numJuegos[j]; i++) {

                int ptsEquipoPrimario, ptsEquipoOponente;
                String equipoOponente = "", snitchEquipoPrimario,  resultadoPartido = "";
                
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

            puntajeTotal[j] = ptsTotal; 
            resultados[j] = resultadoGeneral;
            
        }
    }

    
    //FUNCION 6 - Obtiene el promedio general de todos los openentes diferentes entre cada equipo del torneo
    public static double obtenerPromedioOpenentes(int [] numOponentes ) {
        double promedio = 0;

        for (int i = 0; i<numOponentes.length; i++) {
            promedio += numOponentes[i]; 
        }
        promedio /= numOponentes.length;    

        out.println("\nEl promedio de openentes diferentes para cada equipo del torneo es: " + promedio);
        return promedio;
    }
    //Funcion 7 - imprime el equipo con mas partidos jugados
    public static void imprimirEquicoMasPartidos(String [] equipos, int [] numJuegos){
        String equipoMayor = "";
        int numJuegosM = 0;
        
        for (int i = 0; i<equipos.length; i++){
            
            if(i>0){
                if(i==1){
                    if(numJuegos[i] > numJuegos[i-1] && numJuegos[i] > numJuegosM){
                        numJuegosM = numJuegos[i];
                        equipoMayor = equipos[i];
                    
                    } else if(numJuegos[i]<numJuegos[i-1] && numJuegos[i] > numJuegosM){
                        equipoMayor = equipos[i-1];
                    }
                }
                
            }
            
        }
        out.println("El equipo con mas partidos corresponde a: "+ equipoMayor);
    } 
    // funcion 8 - Imprime el equipo con menos partidos jugados
    public static void imprimirEquicoMenosPartidos(String [] equipos, int [] numJuegos){
        String equipoMenor = "";
        int numJuegosM = 0;
        
        for (int i = 0; i<equipos.length; i++){
            
            if(i>0){
                if(i == 1){
                    numJuegosM = numJuegos[i];
                    equipoMenor = equipos[i];
                } else{
                    if(numJuegos[i] < numJuegos[i-1] && numJuegos[i] < numJuegosM){
                        numJuegosM = numJuegos[i];
                        equipoMenor = equipos[i];
                    
                    } else if(numJuegos[i]<numJuegos[i-1] && numJuegos[i] < numJuegosM){
                        equipoMenor = equipos[i-1];
                    }
                }
                
            }
            
        }
        out.println("El equipo con menos partidos corresponde a: "+ equipoMenor);
    } 

    public static void imprimirEquipos5Partidos(String [] equipos, int [] numJuegos){
        String [] escogerEquipos = new String [0];
        int cantEquipos=0, conta = 0;

        for(int i = 0; i<equipos.length; i++){
            if(numJuegos[i] >=5){
                cantEquipos++;
            }
        }
        escogerEquipos = new String [cantEquipos];
        for(int i = 0; i<equipos.length; i++){
            if(numJuegos[i] >=5){
                escogerEquipos[conta] = equipos[i];
                conta++;
            }
        }
        out.println("Los equipos con 5 partidos o mas son los siguentes: ");
        for(int i = 0; i<escogerEquipos.length; i++){
            out.print(escogerEquipos[i]+" ");
        }

    }

    //FUNCION 10 - Obtiene el nombre de los equipos que superan el promedio general de oponentes por equipo del torneo
    public static void ObtenerEquiposMasOponentes(double promedio, String[] equipos, int[] numOponentes) {
        
        out.println("\nLos Equipos con el numero de oponentes superior al promedio de " + promedio + " son: ");
        for (int i = 0; i < numOponentes.length; i++) {
            if (numOponentes[i] > promedio) {
                out.print("\n-" + equipos[i] +  " con un total de " + numOponentes[i] + " oponentes");
            }
        }
        out.print("\n");
    }



}