@Entity
@Table(name = "Segmento")
public class Segmento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long segmentoId;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    private String originType;

    private BigDecimal originLat;
    private BigDecimal originLng;

    private BigDecimal destLat;
    private BigDecimal destLng;

    private String segmentType;
    private String status;

    private BigDecimal estimatedDistanceKm;
    private Integer estimatedTimeMin;
    private BigDecimal estimatedCost;

    private BigDecimal actualDistanceKm;
    private Integer actualTimeMin;
    private BigDecimal actualCost;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Long truckId;
}