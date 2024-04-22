package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Entities.User;
import com.example.Repositories.UsageHistoryRepository;
import com.example.Repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User, Long> {

    private final UserRepository userRepository;
    private final UsageHistoryRepository usageHistoryRepository;

    @Autowired
    public UserController(UserRepository userRepository, UsageHistoryRepository usageHistoryRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.usageHistoryRepository = usageHistoryRepository;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { 
        if (userRepository.existsById(id)) {
            if (!usageHistoryRepository.existsByUserId(id)) {
                userRepository.deleteById(id);
                return ResponseEntity.ok().build();

            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
