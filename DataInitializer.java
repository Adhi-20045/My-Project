package com.slms.config;

import com.slms.entity.User;
import com.slms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create default admin user if not exists
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@sportleague.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(User.Role.ADMIN);
            admin.setStatus(User.UserStatus.ACTIVE);
            userRepository.save(admin);
            System.out.println("Default admin user created: admin/admin123");
        }

        // Create test users for each role
        if (!userRepository.existsByUsername("manager")) {
            User manager = new User();
            manager.setUsername("manager");
            manager.setEmail("manager@sportleague.com");
            manager.setPassword(passwordEncoder.encode("manager123"));
            manager.setRole(User.Role.TEAM_MANAGER);
            manager.setStatus(User.UserStatus.ACTIVE);
            userRepository.save(manager);
            System.out.println("Default manager user created: manager/manager123");
        }

        if (!userRepository.existsByUsername("player")) {
            User player = new User();
            player.setUsername("player");
            player.setEmail("player@sportleague.com");
            player.setPassword(passwordEncoder.encode("player123"));
            player.setRole(User.Role.PLAYER);
            player.setStatus(User.UserStatus.ACTIVE);
            userRepository.save(player);
            System.out.println("Default player user created: player/player123");
        }

        if (!userRepository.existsByUsername("fan")) {
            User fan = new User();
            fan.setUsername("fan");
            fan.setEmail("fan@sportleague.com");
            fan.setPassword(passwordEncoder.encode("fan123"));
            fan.setRole(User.Role.FAN);
            fan.setStatus(User.UserStatus.ACTIVE);
            userRepository.save(fan);
            System.out.println("Default fan user created: fan/fan123");
        }
    }
}