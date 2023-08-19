import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner reading = new Scanner(System.in);
        String search = "";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List <Adress> adresses = new ArrayList<>();

        while (!search.equalsIgnoreCase("sair")){
            System.out.println("\nDigite o CEP para busca do endereço desejado, ou 'sair' para encerrar.");
            search = reading.nextLine();

            String adress = "https://viacep.com.br/ws/" + search + "/json/";

            if (search.equalsIgnoreCase("sair")){
                System.out.println("\nObrigado por utilizar nosso sistema, volte sempre!");
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(adress))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers
                        .ofString());

                String json = response.body();
                Adress adress1 = gson.fromJson(json, Adress.class);

                System.out.println(adress1);
                adresses.add(adress1);

            } catch (Exception e){
                System.out.println("\nErro de digitação!");
            }

        }

        FileWriter write = new FileWriter("Endereços.txt");
        write.write(gson.toJson(adresses));
        write.close();
        System.out.println("Sistema encerrado.");

    }
}