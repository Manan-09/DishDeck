package dev.manan.dishdeck.service;

import dev.manan.dishdeck.data.dto.CreateUserDTO;
import dev.manan.dishdeck.data.entity.User;
import dev.manan.dishdeck.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static dev.manan.dishdeck.util.AlphanumericGenerator.generateAlphanumeric;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private final int USER_ID_LENGTH = 5;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).orElseThrow();
    }

    public User createUser(CreateUserDTO createUserDTO) {
        User user = User.from(createUserDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.insert(user);
    }

    public String createUniqueUserId() {
        String uniqueId;
        do {
            uniqueId = generateAlphanumeric(USER_ID_LENGTH);
        } while(userRepo.existsByUserId(uniqueId));
        return uniqueId;
    }
}