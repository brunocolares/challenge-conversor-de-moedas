import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Conversion;
import modelo.ConversionRates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int opcao = 1;
        while(true) {
            Consultas consultas = new Consultas();
            Scanner sc = new Scanner(System.in);
            System.out.println("** Conversor de moedas ** v1.0.0");
            System.out.println("[1] Dólar to Peso Argentino");
            System.out.println("[2] Peso Argentino to Dólar");
            System.out.println("[3] Dólar to Real Brasileiro");
            System.out.println("[4] Real Brasileiro to Dólar");
            System.out.println("[5] Dólar to Peso Colombiano");
            System.out.println("[6] Peso Colombiado to Dólar");
            System.out.println("[7] Sair");
            System.out.print("** Digite a opção desejada: ");
            opcao = sc.nextInt();
            if(opcao == 7) {
                break;
            } else {
                System.out.println("** Digite o valor desejado: ");
                double valor = sc.nextDouble();
                ConversionRates conversionRates = consultas.findConversionRates(opcao);
                double conversao = consultas.calcular(conversionRates.conversionRate(), valor);
                System.out.println(conversao);
            }
        }
    }
}