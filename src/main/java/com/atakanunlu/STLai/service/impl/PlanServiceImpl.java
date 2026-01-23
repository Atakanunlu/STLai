package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.subscription.PlanResponse;
import com.atakanunlu.STLai.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
