package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.auth.UserProfileResponse;
import com.atakanunlu.STLai.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
