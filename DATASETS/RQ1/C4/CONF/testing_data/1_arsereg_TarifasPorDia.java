

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class TarifasPorDia 
{
    public static PrintStream out = System.out;
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args ) throws IOException {

        int tarifaLunes = 10;
        int tarifaMartes = 8;
        int tarifaMiercoles = 9;
        int tarifaJueves = 7;
        int tarifaViernes = 11;
        int tarifaSabado = 12;
        int tarifaDomingo = 13;

        System.out.println("Digite cuantas horas trabajó el Lunes");
        int horasLunes = Integer.parseInt(in.readLine());
        if(horasLunes > 8){
            System.out.println("Se permite trabajar un máximo de 8 horas. Se fija el limite a 8 horas.");
            horasLunes = 8;
        }
        System.out.println("Digite cuantas horas trabajó el Martes");
        int horasMartes = Integer.parseInt(in.readLine());
        if(horasMartes > 8){
            System.out.println("Se permite trabajar un máximo de 8 horas. Se fija el límite a 8 horas");
            horasMartes = 8;
        }
        System.out.println("Digite cuantas horas trabajó el Miercoles");
        int horasMiercoles = Integer.parseInt(in.readLine());
        if(horasMiercoles > 8){
            System.out.println("Se permite trabajar un máximo de 8 horas. Se fija el límite a 8 horas");
            horasMiercoles = 8;
        }
        System.out.println("Digite cuantas horas trabajó el Jueves");
        int horasJueves = Integer.parseInt(in.readLine());
        if(horasJueves > 8){
            System.out.println("Se permite trabajar un máximo de 8 horas. Se fija el límite a 8 horas");
            horasJueves = 8;
        }
        System.out.println("Digite cuantas horas trabajó el Viernes");
        int horasViernes = Integer.parseInt(in.readLine());
        if(horasViernes > 8){
            System.out.println("Se permite trabajar un máximo de 8 horas. Se fija el límite a 8 horas");
            horasViernes = 8;
        }
        System.out.println("Digite cuantas horas trabajó el Sabado");
        int horasSabado = Integer.parseInt(in.readLine());
        if(horasSabado > 8){
            System.out.println("Se permite trabajar un máximo de 8 horas. Se fija el límite a 8 horas");
            horasSabado = 8;
        }
        System.out.println("Digite cuantas horas trabajó el Domingo");
        int horasDomingo = Integer.parseInt(in.readLine());
        if(horasDomingo > 8){
            System.out.println("Se permite trabajar un máximo de 8 horas. Se fija el límite a 8 horas");
            horasDomingo = 8;
        }


        int totalLunes = tarifaLunes * horasLunes;
        int totalMartes = tarifaMartes * horasMartes;
        int totalMiercoles = tarifaMiercoles * horasMiercoles;
        int totalJueves = tarifaJueves * horasJueves;
        int totalViernes = tarifaViernes * horasViernes;
        int totalSabado = tarifaSabado * horasSabado;
        int totalDomingo = tarifaDomingo * horasDomingo;

        int total = totalLunes + totalMartes + totalMiercoles + totalJueves + totalViernes + totalSabado + totalDomingo;

        System.out.println("Se debe pagar un total de: " + total);


    }
}
