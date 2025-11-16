@Entity
@Table(name = "routes")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    private Long requestId;
    private Integer totalTramos;
    private Integer totalDepots;

    private BigDecimal totalDistanceKm;
    private Integer estimatedTimeMin;
    private BigDecimal estimatedCost;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<Segmento> segmentos;
}
