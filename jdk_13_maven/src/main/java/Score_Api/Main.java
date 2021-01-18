package Score_Api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://live-score-api.p.rapidapi.com/scores/live.json?secret=undefined&key=undefined"))
                .header("x-rapidapi-key", "c4ec2cbf9emsh0979f579338c05ep141da8jsn1ac2bf43ccd7")
                .header("x-rapidapi-host", "live-score-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
