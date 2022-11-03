package com.SEP.BusinessManagementSystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AuthenticationResponse {
    private final String jwt;

}