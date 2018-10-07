## 규칙 8. equals를 재정의할 때는 일반 규약을 따르라

### equals 메서드
 * java.lang.Object
 ```
 public boolean equals(Object obj) {
     return (this == obj);
 }
 ```
 * equals 메서드를 재정의 하지 않는 경우, 모든 객체는 오직 자기 자신하고만 같다.

### equals 메서드를 재정의 하지 않아도 될 경우
 * 각각의 객체가 고유하다: 값 대신 활성 개체(active entity)를 나타내는 경우
   * Thread 클래스의 경우
 * 클래스에 논리적 동일성 검사 방법이 있건 없건 상관없는 경우
   * java.util.Random 클래스는 각 객체가 동일한 난수열을 만드는지 검사하는 equals 메서드를 재정의할 수도 있었지만 불필요한 기능이며 Object의 equals로 충분하다.
 * 상위 클래스에서 재정의한 equals가 하위 클래스에서 사용하기에도 적당하다
   * 대부분의 Set(List, Map) 클래스는 AbstractSet의 equals 메서드를 그대로 사용한다.
   * java.util.AbstractSet
   ```
   public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Set))
            return false;
        Collection<?> c = (Collection<?>) o;
        if (c.size() != size())
            return false;
        try {
            return containsAll(c);
        } catch (ClassCastException unused)   {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }
   ```
 * 클래스가 private 또는 package-private로 선언되었고, equals 메서드를 호출할 일이 없다
   * 해당 상황에서 클라이언트의 실수로 equals를 호출하는 상황에 대처하기 위해 exception을 발생시키는 equals 메서드를 재정의하는 것을 권장한다.
   ```
   @Override
   public boolean equals(Object obj) {
       throw new AssertionError(); // 호출하면 안 되는 메서드를 호출했다는 뜻
   }
   ```
 * 하나의 객체만 존재하는 클래스
   * 싱글톤 객체, enum의 경우 객체 동일성이 곧 논리적 동일성이다. 따라서 Object에 정의된 equals 메서드만 사용해도 논리적 동일성을 검사할 수 있다.

### equals 메서드를 재정의 하는 경우
 * 객체 동일성이 아닌 논리적 동일성의 개념을 지원하는 클래스일 때 equals 메서드를 재정의하는 것이 바람직하다.
   * Integer나 Date 처럼 값 클래스는 대체로 그 조건에 부합한다.
 * equals 메서드를 재정의하면 객체를 Map의 키나 Set의 원소로 사용할 수 있게 된다. (equsals를 올바르게 재정의하지 않은 객체를 Map이나 Set과 함께 사용할 경우, 그 결과는 예측하기 어렵다)
 
### equals 일반 규약
 * 반사성: 모든 객체는 자기 자신과 같다.
   * x.equals(x)는 true. (단, x != null)
 * 대칭성
   * x.equals(y) == true 이면 y.equals(x) == true. (단, x != null, y != null)
   * 대칭성을 위반할 가능성이 있다
 * 추이성
   * x.equals(y) == true 이고 y.equals(z) == true 이면 x.equals(z) == true. (단, x != null, y != null, z != null)
 * 일관성: 일단 같다고 판정된 객체들은 추후 변경되지 않는 한 계속 같아야 한다.
   * equals를 통해 비교되는 정보에 아무 변화가 없다면, x.equals(y) 호출 결과는 호출 횟수에 상관없이 항상 같아야 한다
 * null에 대한 비동치성: 모든 객체는 null과 동치 관계에 있지 아니한다.
   * x.equals(null)은 항상 false. (단, x != null)
   
### equals 메서드 구현 지침
