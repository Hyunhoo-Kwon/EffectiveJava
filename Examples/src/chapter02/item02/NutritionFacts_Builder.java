package chapter02.item02;

public class NutritionFacts_Builder {
    // 멤버 변수에 final 선언 가능
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;

    private NutritionFacts_Builder(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
    }

    @Override
    public String toString() {
        return "NutritionFacts_Builder{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                '}';
    }

    public static class Builder {
        // 필수 인자
        private final int servingSize;
        private final int servings;
        // 선택적 인자: 기본값으로 초기화
        private int calories = 0;
        private int fat = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public NutritionFacts_Builder build() {
            return new NutritionFacts_Builder(this);
        }
     }
}
