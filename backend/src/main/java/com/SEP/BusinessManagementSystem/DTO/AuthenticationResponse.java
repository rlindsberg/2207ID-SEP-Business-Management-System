package com.SEP.BusinessManagementSystem.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AuthenticationResponse {
    private final String jwt;

}