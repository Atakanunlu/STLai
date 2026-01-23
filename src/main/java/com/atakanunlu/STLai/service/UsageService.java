package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.subscription.PlanLimitsResponse;
import com.atakanunlu.STLai.dto.subscription.UsageTodayResponse;


public interface UsageService {
    UsageTodayResponse getTodayUsage(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
