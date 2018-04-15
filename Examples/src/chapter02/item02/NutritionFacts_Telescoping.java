package chapter02.item02;

public class NutritionFacts_Telescoping {
    // 멤버 변수에 final 선언 가능
    private final int servingSize;    // 필수
    private final int servings;       // 필수
    private final int calories;       // 선택
    private final int fat;            // 선택

    public NutritionFacts_Telescoping(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
    }
}
