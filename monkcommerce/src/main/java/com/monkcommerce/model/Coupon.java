package com.monkcommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CouponType type;

    @Column(nullable = false)
    private Double discount;  // Changed to Double

    @Column(nullable = false)
    private Double threshold; // Changed to Double

    private Integer repetitionLimit; // Changed from int to Integer

    @ElementCollection
    private List<Long> buyProducts; // For BxGy

    @ElementCollection
    private List<Long> getProducts; // For BxGy
}
