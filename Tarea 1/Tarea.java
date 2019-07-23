/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_edd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author User
 */
public class Tarea {

    public static void main(String args[]) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcion = 0;
        do {
            System.out.println("SELECCIONE UNA OPCION: ");
            System.out.println("1. Retornar Fecha");
            System.out.println("2. Retornar Primos");
            System.out.println("3. Salir");

            opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 1:
                    System.out.println("1. RETORNAR FECHA ----------------------");
                    
                    String dia = "";
                    String mes = "";
                    String anio = "";
                    do {                        
                        System.out.print("    Ingrese el número del día, un número entre 1 y 31: ");
                        dia = br.readLine();
                        if(isNumeric(dia)){
                            if(Integer.parseInt(dia) < 1 || Integer.parseInt(dia) > 31){
                                dia = "No es";
                            }
                        }
                    } while (!isNumeric(dia));
 
                    do{
                        System.out.print("    Ingrese el número del mes, un número entre 1 y 12: ");
                        mes = br.readLine();
                        if(isNumeric(mes)){
                            if(Integer.parseInt(mes) < 1 || Integer.parseInt(mes) > 12){
                                mes = "No es";
                            }
                        }
                    } while (!isNumeric(mes));
                    
                    do{
                        System.out.print("    Ingrese el número del anio, un número mayor o igual a 1770: ");
                        anio = br.readLine();
                        if(isNumeric(anio)){
                            if(Integer.parseInt(anio) < 1770){
                                anio = "No es";
                            }
                        }
                    } while (!isNumeric(anio));
                    
                    System.out.println(fecha(dia,mes,anio));
                    break;
                case 2:
                    System.out.println("2. RETORNAR PRIMOS----------------------");
                    String primo = "";
                    
                    do {                        
                        System.out.print("    Ingrese un número entero mayor a 0: ");
                        primo = br.readLine();
                        if(isNumeric(primo)){
                            if(Integer.parseInt(primo) < 1){
                                primo = "No es";
                            }
                        }
                    } while (!isNumeric(primo));
                    
                    System.out.println(primos(Integer.parseInt(primo)));
                    break;
            }
        } while (opcion != 3);
    }

//--------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------
//-------------------------------RETORNA EL DIA CORRESPONDIENTE A LA FECHA--------------------------------
//--------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------
    private static String fecha(String dia, String mes, String anio) throws ParseException {
        String inputDateStr = String.format("%s/%s/%s", dia, mes, anio);
        Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        String diaSemana = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toLowerCase();
        return thisDay(diaSemana);
    }
    
    private static String thisDay(String day) {
        switch (day) {
            case "monday":
                return "Lunes";
            case "tuesday":
                return "Martes";
            case "wednesday":
                return "Miércoles";
            case "thursday":
                return "Jueves";
            case "friday":
                return "Viernes";
            case "saturday":
                return "Sábado";
            case "sunday":
                return "Domingo";
        }
        return "Resultado";
    }

//--------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------
//------------------------------RETORNA LOS PRIMOS DENTRO DE UN NUMERO DADO-------------------------------
//--------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------
    private static String primos(int numero) {
        int tamano = 0;
        String primos = "|";
        do {
            tamano++;
            if (CribaEratostenes(tamano)) {
                primos += tamano + "|";
            }
        } while (tamano != numero);
        
        return primos;
    }
    
    private static boolean CribaEratostenes(int numero) {
        switch (numero) {
            case 1:
                return true;
            case 2:
                return true;
            default:
                int contador = 2;
                while (contador != numero) {
                    if (numero % contador == 0) {
                        return false;
                    }
                    contador++;
                }
        }
        return true;
    }
    
//--------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------
    private static boolean isNumeric(String dato) {
        try {
            Integer.parseInt(dato);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
