package com.exp.a99spoonscustomer.Views.PromotionScreen.data

import com.exp.a99spoonscustomer.model.PromotionCard

class PromotionData {
    companion object {
        fun promoCodeData(): List<PromotionCard> {
            return listOf(
                PromotionCard(
                    title = "Welcome Offer",
                    subtitle = "Use code WELCOME10 for 10% off your first purchase!",
                    code = "WELCOME10"
                ),
                PromotionCard(
                    title = "Summer Special",
                    subtitle = "Cool off with 15% off all ice cream orders. Enter code SUMMERICE at checkout!",
                    code = "SUMMERICE"
                ),
                PromotionCard(
                    title = "Snack Time Savings",
                    subtitle = "Enjoy 20% off on all snacks. Use code SNACKTIME20 today!",
                    code = "SNACKTIME20"
                ),
                PromotionCard(
                    title = "Limited Time Deal",
                    subtitle = "Hurry! Get 25% off on your order with code LIMITED25. Don't miss out!",
                    code = "LIMITED25"
                ),
                PromotionCard(
                    title = "Sweet Treats Promo",
                    subtitle = "Indulge in our sweet treats collection with 30% off. Apply code SWEET30 now!",
                    code = "SWEET30"
                ),
                PromotionCard(
                    title = "Healthy Choices Discount",
                    subtitle = "Stay fit and save! Use code HEALTHY20 for 20% off on gluten-free and non-GMO items.",
                    code = "HEALTHY20"
                ),
            )
        }
    }
}