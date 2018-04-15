## 규칙2. 생성자 인자가 많을 때는 Builder 패턴 적용을 고려하라

### 생성자에 전달되는 선택적 인자수가 많을 때 적용 가능한 방법
 1. 점층적 생성자 패턴(telescoping constructor pattern)
    * 필수 인자만 받는 생성자를 하나 생성하고, 선택적 인자를 받는 생성자를 쌓아 올리듯 추가하는 방법
    * (단점 1) 점층적 생성자 패턴은 인자의 순서를 혼동할 수 있고, 읽기 어려운 코드가 된다
 ```
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
 ```
 2. 자바빈 패턴(JavaBeans pattern)
    * 인자 없는 생성자를 호출하여 객체부터 만든 다음, 설정 메서드(setter)를 호출하는 방법
    * (단점 1) 1회의 함수 호출로 객체 생성을 끝낼 수 없으므로, 객체 일관성이 일시적으로 깨질 수 있다
    * (단점 2) 변경 불가능(immutable) 클래스를 만들 수 없다 (멤버 변수에 final 선언 불가능)
 ```
 NutritionFacts_JavaBeans cocaCola = new NutritionFacts_JavaBeans();
 cocaCola.setServingSize(240);
 cocaCola.setServings(80);
 ...
 ```
 3. 빌더 패턴(Builder Pattern)
