package utnfrc.isi.back.spring.geoapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import utnfrc.isi.back.spring.geoapi.model.DistanciaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
@RequiredArgsConstructor
public class GeoService {

    @Value("${google.maps.apikey}")
    private String apiKey;

    private final RestClient.Builder builder;

    public DistanciaDTO calcularDistancia(String origen, String destino) throws Exception {

        RestClient client = builder.baseUrl("https://maps.googleapis.com/maps/api").build();

        String url = "/distancematrix/json?origins=" + origen +
                "&destinations=" + destino +
                "&units=metric&mode=driving&key=" + apiKey;

        ResponseEntity<String> response =
                client.get().uri(url).retrieve().toEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        // ------------------------------
        // VALIDACIONES IMPORTANTES
        // ------------------------------

        if (root.has("error_message")) {
            throw new IllegalStateException("Google API error: " + root.get("error_message").asText());
        }

        JsonNode rows = root.path("rows");
        if (!rows.isArray() || rows.isEmpty()) {
            throw new IllegalStateException("Google API no devolvió 'rows'. Revisa origen/destino.");
        }

        JsonNode elements = rows.get(0).path("elements");
        if (!elements.isArray() || elements.isEmpty()) {
            throw new IllegalStateException("Google API no devolvió 'elements'.");
        }

        JsonNode leg = elements.get(0);

        String status = leg.path("status").asText();
        if (!"OK".equals(status)) {
            throw new IllegalStateException("Google no pudo calcular distancia (status=" + status + ")");
        }

        // ------------------------------
        // ARMAR RESPUESTA
        // ------------------------------

        DistanciaDTO dto = new DistanciaDTO();
        dto.setOrigen(origen);
        dto.setDestino(destino);

        dto.setKilometros(leg.path("distance").path("value").asDouble() / 1000);
        dto.setDuracionTexto(leg.path("duration").path("text").asText());

        return dto;
    }
}