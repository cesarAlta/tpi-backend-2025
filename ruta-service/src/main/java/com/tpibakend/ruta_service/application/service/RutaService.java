@Service
public class RutaApplicationService {

    private final JpaRutaRepository rutaRepository;
    private final JpaSegmentoRepository segmentoRepository;

    public RutaApplicationService(JpaRutaRepository rutaRepository,
                                  JpaSegmentoRepository segmentoRepository) {
        this.rutaRepository = rutaRepository;
        this.segmentoRepository = segmentoRepository;
    }

    public RutaResponseDTO crearRuta(RutaRequestDTO dto) {

        Ruta ruta = new Ruta();
        ruta.setRequestId(dto.getRequestId());
        ruta.setCreatedAt(LocalDateTime.now());

        // Valores iniciales (sin cálculos)
        ruta.setTotalTramos(0);
        ruta.setTotalDepots(0);
        ruta.setTotalDistanceKm(BigDecimal.ZERO);
        ruta.setEstimatedCost(BigDecimal.ZERO);
        ruta.setEstimatedTimeMin(0);

        Ruta guardada = rutaRepository.save(ruta);

        return RutaResponseDTO.from(guardada);
    }

    public RutaResponseDTO obtenerRuta(Long id) {
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new RutaNotFoundException(id));

        return RutaResponseDTO.from(ruta);
    }

    public List<RutaResponseDTO> obtenerTodas() {
        return rutaRepository.findAll()
                .stream()
                .map(RutaResponseDTO::from)
                .toList();
    }
}