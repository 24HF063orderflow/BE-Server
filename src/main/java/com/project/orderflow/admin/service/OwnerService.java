package com.project.orderflow.admin.service;

import com.project.orderflow.admin.domain.Owner;
import com.project.orderflow.admin.dto.LoginDto;
import com.project.orderflow.admin.dto.SignUpDto;
import com.project.orderflow.admin.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    public Owner registerOwner (@RequestBody SignUpDto signUpDto){
        String encodedPassword = passwordEncoder.encode(signUpDto.getPassword());

        Owner owner= Owner.builder()
                .email(signUpDto.getEmail())
                .name(signUpDto.getName())
                .passwordHash(encodedPassword)
                .businessNumber(signUpDto.getBusinessNumber())
                .build();

        return ownerRepository.save(owner);
    }

    public Boolean loginOwner(@RequestBody LoginDto loginDto){
        Owner findOwner = ownerRepository.findByEmail(loginDto.getEmail());

        if(findOwner==null){
            return false;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(loginDto.getPassword(), findOwner.getPasswordHash())) {
            return true;
        }

        return false;
    }

}
