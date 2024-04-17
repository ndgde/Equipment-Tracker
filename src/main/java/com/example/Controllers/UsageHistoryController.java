@RestController
@RequestMapping("/api")
public class UsageHistoryController {

    private final UsageHistoryRepository usageHistoryRepository;

    public UsageHistoryController(UsageHistoryRepository usageHistoryRepository) {
        this.usageHistoryRepository = usageHistoryRepository;
    }

    @GetMapping("/usagehistory")
    public List<UsageHistory> getAllUsageHistory() {
        return usageHistoryRepository.findAll();
    }
}
