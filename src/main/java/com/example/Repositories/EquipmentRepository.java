package com.example.Repositories;

import com.example.Entities.Equipment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByType(String type);

    @NonNull
    Optional<Equipment> findById(@NonNull Long id);
}
