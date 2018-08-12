package chapter02.item02;

public class NutritionFacts_JavaBeans {
    // 멤버 변수에 final 선언 불가능
    private int servingSize = -1;   // 필수: 기본값 없음
    private int servings = -1;      // 필수: 기본값 없음
    private int calories = 0;       // 선택: 기본값으로 초기화
    private int fat = 0;            // 선택: 기본값으로 초기화

    public NutritionFacts_JavaBeans() {

    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }
}
