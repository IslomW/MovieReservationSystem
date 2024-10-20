package com.sharipov.movie_reservation_system.domain.web.controller;

import com.sharipov.movie_reservation_system.domain.service.ProfileService;
import com.sharipov.movie_reservation_system.domain.web.dto.AuthDTO;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "Auth Controller",
        description = "Auth API"
)
public class AuthController {

    private final ProfileService profileService;


    @PostMapping("/registration")
    public ProfileDTO registration(@RequestBody ProfileDTO dto) {
        ProfileDTO profileDTO = profileService.create(dto);
        return ResponseEntity.ok(profileDTO).getBody();
    }

    @PostMapping("/authorization")
    public ResponseEntity<ProfileDTO> authorization(@Validated @RequestBody AuthDTO authDTO){
        ProfileDTO result = profileService.authorization(authDTO);
        return ResponseEntity.ok(result);
    }

//
//    @PostMapping("/refresh-token")
//    public ResponseEntity<TokenDTO> refreshToken(@RequestBody TokenDTO dto){
//        TokenDTO tokenDTO = profileService.getNewAccessToken(dto);
//        return ResponseEntity.ok(tokenDTO);
//
//    }




}
