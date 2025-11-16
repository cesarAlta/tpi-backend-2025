@Entity
@Table(name = "Ruta")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutaId;

    private Long requestId;

    private Integer totalTramos;
    private Integer totalDepots;
    private BigDecimal totalDistanceKm;
    private Integer estimatedTimeMin;
    private BigDecimal estimatedCost;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<Segmento> segmentos = new ArrayList<>();
}