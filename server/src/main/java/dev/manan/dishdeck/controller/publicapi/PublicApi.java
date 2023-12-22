package dev.manan.dishdeck.controller.publicapi;

import dev.manan.dishdeck.data.dto.CreateUserDTO;
import dev.manan.dishdeck.data.dto.LoginRequest;
import dev.manan.dishdeck.data.entity.User;
import dev.manan.dishdeck.service.JWTService;
import dev.manan.dishdeck.service.StorageService;
import dev.manan.dishdeck.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

@RestController
@RequestMapping("/api/public/v1")
@RequiredArgsConstructor
public class PublicApi {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserService userService;
    private final StorageService storageService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            User user = userService.loadUserByUsername(loginRequest.getUsername());
            return ResponseEntity.ok(jwtService.generateToken(user.getUsername(), user.getUserId()));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO) {
        return ResponseEntity.ok(userService.createUser(createUserDTO));
    }

    @GetMapping("/image/{key}")
    public ResponseEntity<URL> fetchPresignedUrl(@PathVariable String key) throws Exception {
        return ResponseEntity.ok(storageService.generatePresignedUrl(key));
    }
}