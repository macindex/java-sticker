import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        // Pegar a conexão HTTP e buscar os top 250 filmes
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient(); 
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        
        // Pegar apenas os dados que interessam (titulo poster classificacao)
        var parser = new JsonParser();
        List<Map<String, String>>listaDeFilimes = parser.parse(body);

        // Exibir e manipular os dados

    }
}
