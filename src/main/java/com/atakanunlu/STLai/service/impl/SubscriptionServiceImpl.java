package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.subscription.CheckoutRequest;
import com.atakanunlu.STLai.dto.subscription.CheckoutResponse;
import com.atakanunlu.STLai.dto.subscription.PortalResponse;
import com.atakanunlu.STLai.dto.subscription.SubscriptionResponse;
import com.atakanunlu.STLai.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
