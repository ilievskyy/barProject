package com.example.barshop.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class OrderDto {

    @Setter
    private Long productId;

    @Setter
    private String preferences;

    public OrderDto() {
    }

    public OrderDto(Long productId, String preferences) {
        this.productId = productId;
        this.preferences = preferences;
    }

}
