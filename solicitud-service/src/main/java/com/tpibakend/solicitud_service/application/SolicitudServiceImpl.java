@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository repository;

    @Override
    public Solicitud crearSolicitud(SolicitudRequestDTO dto) {

        Solicitud solicitud = Solicitud.builder()
                .requestNumber(UUID.randomUUID().toString())
                .clientId(dto.getClientId())
                .containerId(dto.getContainerId())
                .status(EstadoSolicitud.BORRADOR)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return repository.save(solicitud);
    }

    @Override
    public Solicitud obtenerSolicitud(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    @Override
    public Solicitud actualizarEstado(Long id, String nuevoEstado) {
        Solicitud solicitud = obtenerSolicitud(id);
        solicitud.setStatus(EstadoSolicitud.valueOf(nuevoEstado));
        solicitud.setUpdatedAt(LocalDateTime.now());
        return repository.save(solicitud);
    }
}
