@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String description;
    private LocalDate acquisitionDate;
    private double cost;
    private String status;
    private String image;

    // Геттеры и сеттеры
}
