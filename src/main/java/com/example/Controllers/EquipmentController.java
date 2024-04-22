package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Entities.Equipment;
import com.example.Repositories.EquipmentRepository;
import com.example.Repositories.UsageHistoryRepository;


@RestController
@RequestMapping("api/equipment")
public class EquipmentController extends BaseController<Equipment, Long>{

    private final EquipmentRepository equipmentRepository;
    private final UsageHistoryRepository usageHistoryRepository;

    @Autowired
    public EquipmentController(EquipmentRepository equipmentRepository, UsageHistoryRepository usageHistoryRepository) {
        super(equipmentRepository);
        this.equipmentRepository = equipmentRepository;
        this.usageHistoryRepository = usageHistoryRepository;
    }

    @GetMapping("/cost")
    public double getCostByType(@RequestParam String type) {
        return equipmentRepository.findByType(type)
                .stream()
                .mapToDouble(Equipment::getCost)
                .sum();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (equipmentRepository.existsById(id)) {
            if (!usageHistoryRepository.existsByEquipmentId(id)) {
                equipmentRepository.deleteById(id);
                return ResponseEntity.ok().build();

            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
