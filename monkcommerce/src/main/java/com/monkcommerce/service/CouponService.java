package com.monkcommerce.service;

import com.monkcommerce.dto.CouponRequest;
import com.monkcommerce.exception.CouponNotFoundException;
import com.monkcommerce.model.Coupon;
import com.monkcommerce.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon getCouponById(Long id) {
        return couponRepository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException("Coupon not found with id: " + id));
    }

    public Coupon updateCoupon(Long id, Coupon updatedCoupon) {
        Coupon existingCoupon = getCouponById(id);
        existingCoupon.setDiscount(updatedCoupon.getDiscount());
        existingCoupon.setThreshold(updatedCoupon.getThreshold());
        existingCoupon.setRepetitionLimit(updatedCoupon.getRepetitionLimit());
        existingCoupon.setType(updatedCoupon.getType());
        return couponRepository.save(existingCoupon);
    }

    public void deleteCoupon(Long id) {
        couponRepository.deleteById(id);
    }

    // New method to fetch applicable coupons
    public List<Coupon> getApplicableCoupons(CouponRequest request) {
        return couponRepository.findAll().stream()
            .filter(coupon -> request.getCartTotal() >= coupon.getThreshold())
            .collect(Collectors.toList());
    }
}
