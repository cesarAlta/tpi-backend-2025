@FeignClient(name = "solicitud-service", url = "${ms.solicitud.url}")
public interface SolicitudClient {

    @GetMapping("/solicitudes/{id}")
    SolicitudDTO getSolicitud(@PathVariable Long id);
}
