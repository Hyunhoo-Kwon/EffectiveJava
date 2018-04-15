## 규칙1. 생성자 대신 정적 팩토리 메서드를 사용할 수 없는지 생각해 보라

### 객체를 생성하는 일반적인 방법
 1. 생성자를 이용
 > publice BigInteger(...) {...}
 2. 정적 팩토리 메서드
 > public static BigInteger valueOf(...) {...}

### 생성자로 객체를 생성할 때 단점
 1. 클래스에는 signiture 별로 하나의 생성자만 넣을 수 있다. 
  (signiture: 메서드이름 + 매개변수 // VM수준에서 메서드와 클래스를 식별하는데 사용)
 2. 다른 초기화 기능이나 목적을 가진 객체를 생성하기 위해 생성자 매개변수의 순서를 바꾸는 방법으로 생성자를 overloading 한다.
 3. 이렇게 만들어진 생성자를 사용하는 사람은 생성자가 어떤 기능을 하는지 파악하기 힘들다.

### 정적 팩토리 메서드를 사용할 때 장점
#### (장점 1) 생성자와 달리 정적 팩토리 메서드는 메서드의 이름을 명명할 수 있다
 * 같은 signiture를 갖는 생성자를 여러 개 정의할 필요가 있을 때는 생성자보다 정적 팩토리 메서드로 정의
   * 메서드 이름을 보면 기능이 명확히 드러나도록 작명
 
#### (장점 2) 생성자와 달리 호출할 때마다 새로운 객체를 생성할 필요가 없다
 * 싱글턴패턴, BigInteger.valueOf(long val) 메서드는 이 기법을 활용한 좋은 사례
    * 객체를 반복해서 반환할 수 있으므로 어떤 시점에 어떤 객체가 얼마나 존재하는지 정밀하게 제어할 수 있다
    * 이렇게 구현된 클래스는 equals(Object) 대신 == 연산자를 사용하여 비교할 수 있으므로 성능이 향상된다
      > BigInteger.valueOf(0) == BigInteger.valueOf(0) -> true

#### (장점 3) 생성자와 달리 반환값 자료형의 하위 자료형 객체를 반환할 수 있다

#### ~~(장점 4) 형인자 자료형(parameterized type) 객체를 만들 때 편하다~~
 * 일반적인 Map 생성자 호출 방법
 > Map<String, List<String>> m = new HashMap<String, List<String>>();
 * 정적 팩터리 메서드 사용
 > Map<String, List<String>> m = HashMap.netInstance();
 * Java 1.7 형식 추론이 가능해 다음과 같은 방법 사용 가능
 > Map<String, List<String>> m = new HashMap<>();

### 정적 팩토리 메서드를 사용할 때 단점
#### (단점 1) 정적 팩토리 메서드만 있는 클래스를 만들면, public이나 protected로 선언된 생성자가 없으므로 하위 클래스를 만들 수 없다

#### (단점 2) 정적 팩토리 메서드가 다른 정적 메서드(static 메서드)와 확연히 구분되지 않는다

### 자주 사용되는 정적 팩토리 메서드 이름
 * valueOf / Of : 형변환(type-conversion) 메서드
 * getInstance
 * newInstance
 * getType
 * newType
