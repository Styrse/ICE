package ice.ice;

public enum Food {
    TIKKA_MASALA(3500),
    BURGER(4500),
    PIZZA(2250),
    BAKED_SALMON(6500),
    FALAFEL(1000),
    MINCED_BEEF_PATTY(5500),
    CRISPY_PORK_WITH_PARSLEY_SAUCE(4500),
    CEASER_SALAD(1500),
    BEYOND_MEAT_PATTY(1250),
    SUSHI(3000),
    PLANT_BASED_PATTY(1000);

    final int co2GramsPrMeal;

    Food(int co2GramsPrMeal){
        this.co2GramsPrMeal = co2GramsPrMeal;
    }

    public int getCo2GramsPrMeal() {
        return co2GramsPrMeal;
    }
}
