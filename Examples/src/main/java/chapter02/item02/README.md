## 규칙2. 생성자 인자가 많을 때는 Builder 패턴 적용을 고려하라

### 생성자에 전달되는 선택적 인자수가 많을 때 적용 가능한 방법
 1. 점층적 생성자 패턴(telescoping constructor pattern) [[코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter02/item02/NutritionFacts_Telescoping.java)
    * 필수 인자만 받는 생성자를 하나 생성하고, 선택적 인자를 받는 생성자를 쌓아 올리듯 추가하는 방법
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
 2. 자바빈 패턴(JavaBeans pattern) [[코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter02/item02/NutritionFacts_JavaBeans.java)
    * 인자 없는 생성자를 호출하여 객체부터 만든 다음, 설정 메서드(setter)를 호출하는 방법
 ```
 NutritionFacts_JavaBeans cocaCola = new NutritionFacts_JavaBeans();
 cocaCola.setServingSize(240);
 cocaCola.setServings(80);
 ...
 ```
 3. 빌더 패턴(Builder Pattern) [[코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter02/item02/NutritionFacts_Builder.java)
    * 필요한 객체를 직접 생성하는 대신, 빌더 객체를 먼저 만든 후 빌더 객체에 정의된 설정 메서드들을 호출하여 인자들을 추가하는 방법
    * (롬복을 사용할 경우 클래스에 @Bulider 어노테이션 붙여서 사용할 수 있다)
 ```
 NutritionFacts_Builder cocaCola = new NutritionFacts_Builder.Builder(240, 8).calories(100).fat(10).build();
 ```
 
### 점층적 생성자 패턴 단점
 1. 점층적 생성자 패턴은 인자의 순서를 혼동할 수 있고, 읽기 어려운 코드가 된다
 
### 자바빈 패턴의 단점
 1. 1회의 함수 호출로 객체 생성을 끝낼 수 없으므로, 객체 일관성이 일시적으로 깨질 수 있다
 2. 변경 불가능(immutable) 클래스를 만들 수 없다 (멤버 변수에 final 선언 불가능)
 
### 빌더 패턴의 장점
#### (장점 1) 빌더 패턴의 클라이언트 코드 가독성은 전통적인 점층적 생성자 패턴을 따를 때보다 훨씬 좋아질 것이며, 
#### (장점 2) 그 결과물은 자바빈을 사용할 때보다 훨씬 안전할 것이다

### 빌더 패턴의 단점
#### (단점 1) 객체를 생성하려면 우선 빌더 객체를 생성해야 하므로, 오버헤드가 발생한다
#### (단점 2) 빌더 패턴 구현 코드가 필요하므로, 코드량이 증가한다
