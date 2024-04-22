package com.example.Repositories;

import com.example.Entities.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Long> {
    boolean existsByEquipmentId(Long equipmentId);
    boolean existsByUserId(Long userId);
}
