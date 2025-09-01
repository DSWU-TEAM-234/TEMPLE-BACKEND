package com.example.temple_backend.user.controller;

import com.example.temple_backend.user.model.SignupRequest;
import com.example.temple_backend.user.model.UserDto;
import com.example.temple_backend.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    /**
     * 회원가입 API
     * @param signupRequest 회원가입 요청 데이터
     * @return 생성된 사용자 정보
     */
    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequest signupRequest) {
        log.info("회원가입 요청: email={}, displayName={}",
          signupRequest.getEmail(), signupRequest.getDisplayName());

        return authService.signup(signupRequest);
    }

    /**
     * 사용자 정보 조회 API
     * @param userId 사용자 ID
     * @return 사용자 정보
     */
    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return authService.getUserById(userId);
    }

    /**
     * 이메일로 사용자 정보 조회 API
     * @param email 이메일
     * @return 사용자 정보
     */
    @GetMapping("/users")
    public UserDto getUserByEmail(@RequestParam String email) {
        return authService.getUserByEmail(email);
    }
}
