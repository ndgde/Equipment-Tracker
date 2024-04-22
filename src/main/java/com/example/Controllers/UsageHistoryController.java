package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Repositories.EquipmentRepository;
import com.example.Repositories.UsageHistoryRepository;
import com.example.Repositories.UserRepository;
import com.example.Entities.UsageHistory;

@RestController
@RequestMapping("/api/usage-history")
public class UsageHistoryController extends BaseController<UsageHistory, Long> {

    private final UsageHistoryRepository usageHistoryRepository;
    private final EquipmentRepository equipmentRepository;
    private final UserRepository userRepository;

    @Autowired
    public UsageHistoryController(UsageHistoryRepository usageHistoryRepository, EquipmentRepository equipmentRepository, UserRepository userRepository) {
        super(usageHistoryRepository);
        this.usageHistoryRepository = usageHistoryRepository;
        this.equipmentRepository = equipmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UsageHistory> update(@PathVariable Long id, @RequestBody UsageHistory updatedUsageHistory) {
        return usageHistoryRepository.findById(id)
                .map(existingUsageHistory -> {
                    return equipmentRepository.findById(updatedUsageHistory.getEquipment().getId())
                            .map(existingEquipment -> {
                                existingUsageHistory.setEquipment(existingEquipment);
                                return userRepository.findById(updatedUsageHistory.getUser().getId())
                                        .map(existingUser -> {
                                            existingUsageHistory.setUser(existingUser);
                                            existingUsageHistory.setStartDate(updatedUsageHistory.getStartDate());
                                            existingUsageHistory.setEndDate(updatedUsageHistory.getEndDate());
                                            existingUsageHistory.setReason(updatedUsageHistory.getReason());
                                            existingUsageHistory.setComments(updatedUsageHistory.getComments());
                                            return ResponseEntity.ok(usageHistoryRepository.save(existingUsageHistory));
                                        })
                                        .orElse(ResponseEntity.notFound().build());
                            })
                            .orElse(ResponseEntity.notFound().build());
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
