import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option = 1;
        Scanner lectura = new Scanner(System.in);

        while(true){
            System.out.println("**********************************************************");
            System.out.println("Por favor digite una opción");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("**********************************************************");
            try{

                option = Integer.valueOf(lectura.nextLine());

                if(option == 7){
                    System.out.println("Gracias por usar nuestro servicio. Hasta la proxima");
                    break;
                } else if (option > 7 || option < 1) {
                    System.out.println("**********************************************************");
                    System.out.println("Por favor escoja un opción valida");
                    System.out.println("Pulse enter para continuar");
                    System.out.println("**********************************************************");
                    lectura.nextLine();
                }else {
                    System.out.println("**********************************************************");
                    System.out.println("Escriba la cantidad a cambiar");
                    var amount =Float.valueOf(lectura.nextLine());

                    Seleccion seleccion = new Seleccion();
                    ConversioDeMoneda resultado = seleccion.activarOpcion(option, amount);

                    System.out.println("El valor de $" +
                            amount + " " +
                            resultado.base_code().toString() +
                            " corresponde al valor de $" +
                            resultado.conversion_result() +
                            " " +
                            resultado.target_code().toString());

                    System.out.println("Pulse enter para continuar");
                    lectura.nextLine();
                }

            }catch (NumberFormatException e){
                System.out.println("Solo puede ingresar numeros");
                System.out.println("Pulse enter para continuar");
                lectura.nextLine();
            }


        }
    }
}