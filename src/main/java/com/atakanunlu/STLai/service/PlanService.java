package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.subscription.PlanResponse;


import java.util.List;

public interface PlanService {
     List<PlanResponse> getAllActivePlans();
}
