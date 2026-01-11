package com.atakanunlu.STLai.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

    Long id;

    String name;

    String stripePriceId;
    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews; // izin verilen max izleme sayısı
    Boolean unlimitedAi; // LLM e sınırsız erişim true dönerse max token sınırı dikkate alınmaz.

    Boolean active;

}
