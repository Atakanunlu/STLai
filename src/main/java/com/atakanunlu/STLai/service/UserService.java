package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {

    UserProfileResponse getProfile(Long userId);

}
