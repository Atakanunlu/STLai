package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.subscription.PlanLimitsResponse;
import com.atakanunlu.STLai.dto.subscription.UsageTodayResponse;
import com.atakanunlu.STLai.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsage(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
