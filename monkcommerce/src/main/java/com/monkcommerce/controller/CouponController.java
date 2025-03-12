package com.monkcommerce.controller;

import com.monkcommerce.dto.CouponRequest;
import com.monkcommerce.model.Coupon;
import com.monkcommerce.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        return ResponseEntity.ok(couponService.createCoupon(coupon));
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        return ResponseEntity.ok(couponService.getAllCoupons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getCouponById(@PathVariable Long id) {
        return ResponseEntity.ok(couponService.getCouponById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable Long id, @RequestBody Coupon updatedCoupon) {
        return ResponseEntity.ok(couponService.updateCoupon(id, updatedCoupon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint for fetching applicable coupons
    @PostMapping("/applicable-coupons")
    public ResponseEntity<List<Coupon>> getApplicableCoupons(@RequestBody CouponRequest request) {
        List<Coupon> applicableCoupons = couponService.getApplicableCoupons(request);
        return ResponseEntity.ok(applicableCoupons);
    }
}
