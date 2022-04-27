import java.io.*;

public class proyecto2 {

    static BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
    public static void main(String[] args) throws Exception {

        opcion3();


    }

    public static void opcion3() throws IOException{
        int cantidadPartidos,i,ptsEquipoPrimario,ptsEquipoOponente,ptsTotal=0;
        String equipoOponente, equipoPrimario,snitchEquipoPrimario,  resultadoPartido="", resultadoGeneral ="";


        out.println("Entradas: ");
        out.print("Equipo: ");
        equipoPrimario = in.readLine();


        out.print("Numero de Juegos: ");
        cantidadPartidos = Integer.parseInt(in.readLine());
    


        for (i=1; i<=cantidadPartidos; i++)
        {
            out.print("\nJuego " + i + " contra: "  );
            equipoOponente= in.readLine();

            out.print("Marcador de " + equipoPrimario + ": "  );
            ptsEquipoPrimario = Integer.parseInt(in.readLine());
            ptsTotal += ptsEquipoPrimario;

            
            do
            {
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
                resultadoPartido = equipoPrimario + " vs " + equipoOponente + " " + ptsEquipoPrimario + "*-" + ptsEquipoOponente;
                resultadoGeneral += "\n" +  resultadoPartido;
            }
            else
            {
                resultadoPartido = equipoPrimario + " vs " + equipoOponente + " " + ptsEquipoPrimario + "-" + ptsEquipoOponente + "*";
                resultadoGeneral += "\n" +  resultadoPartido;
            }



            
        }

        out.println(resultadoGeneral );
        out.println("\nEl puntaje total de partidos de "+ equipoPrimario + "es: " + ptsTotal);
    }
}