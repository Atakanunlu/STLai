package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.auth.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile(Long userId);

}
