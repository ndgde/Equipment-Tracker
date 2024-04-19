package com.example.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repositories.UsageHistoryRepository;
import com.example.Entities.UsageHistory;

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
