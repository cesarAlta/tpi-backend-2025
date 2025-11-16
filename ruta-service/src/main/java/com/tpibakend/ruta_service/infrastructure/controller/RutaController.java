@RestController
@RequestMapping("/rutas")
public class RutaController {

    private final RutaApplicationService rutaService;

    public RutaController(RutaApplicationService rutaService) {
        this.rutaService = rutaService;
    }

    @PostMapping
    public ResponseEntity<RouteResponseDTO> createRuta(@RequestBody RouteRequestDTO dto) {
        return ResponseEntity.ok(rutaService.createRuta(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaResponseDTO> getRuta(@PathVariable Long id) {
        return ResponseEntity.ok(rutaService.getRuta(id));
    }
}