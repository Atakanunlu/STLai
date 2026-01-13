package com.atakanunlu.STLai.dto.subscription;

public record UsageTodayResponse(
        int tokenUsed,
        int tokensLimit,
        int previewsRunning,
        int previewsLimit
) {
}
