@Entity
public class UsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String comments;

    // Геттеры и сеттеры
}
