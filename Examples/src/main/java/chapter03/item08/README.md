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
 1. == 연산자를 사용하여 equals의 인자가 자기 자신인지 검사: 일치하는 경우 true 반환.
     * 성능 최적화를 위한 것
     ```
     if(o == this)
         return true;
     ```
 2. instanceof 연산자를 사용하여 인자의 자료형이 정확한지 검사: 일치하지 않는 경우 false 반환.
     * null에 대한 비 동치성 검사도 포함된다: instanceof 연산자를 첫 번째 피연산자가 null이면 두 번째 피연산자의 자료형에 상관없이 무조건 false 반환. (o == null 검사 불필요)
     * 보통 인자의 자료형은 equals가 정의된 클래스와 같아야 한다
     ```
     if( !(o instanceof MyType) )
         return false;
     ```
   * 인터페이스의 equals 규약이 해당 인터페이스를 구현하는 여러 클래스의 모든 객체를 비교할 수 있도록 정의한 경우 instanceof의 피연산자로 해당 인터페이스를 사용해야 한다
     * Set, List, Map, Map.Entry와 같은 컬렉션 인터페이스들이 이런 특성을 가지고 있다
     ```
     if( !(o instanceof Set) )
         return false;
     ```
     * 동일한 데이터를 갖는 TreeSet과 HashSet 비교 시 true 반환
     * [[테스트코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/test/java/chapter03/item08/SetTest.java)
     ```
     List<String> list = Arrays.asList("TreeSet", "HashSet", "Equals", "True");
     HashSet<String> hashSet = new HashSet<String>(list);
     TreeSet<String> treeSet = new TreeSet<String>(list);

     assertThat(hashSet.equals(treeSet), is(true));
     ```
 3. equlas의 인자를 정확한 자료형으로 변환하라
     * instanceof 검사로 인해 형 변환은 반드시 성공
     ```
     MyType mt = (MyType) o
     ```
 4. 중요 필드 각각이 인자로 주어진 객체의 해당 필드와 일치하는지 검사: 모두 일치하는 경우 true 반환. 그렇지 않는 경우 false 반환.
     * float, double 이외의 기본 자료형은 == 연산자로 비교
     * float 필드는 Float.compare 메서드를, double 필드는 Double.compare 메서드를 사용해서 비교
       * Float.NaN, -0.0f 상수 사용시 == 연산자는 잘못된 결과 반환
       ```
       Float.NaN==Float.NaN // flase 반환. 잘못된 결과.
       0.0f==-0.0f // true 반환. 잘못된 결과.
       ```
     * 객체 참조 필드는 equals를 재귀적으로 호출하여 검사
       * null이 허용되는 필드는 아래의 숙어 사용
       ```
       field == null ? o.field == null : field.equals(o.field)
       ```
     * equals 메서드의 성능은 필드 비교 순서에 영향을 받는다
       * 가능성이 가장 높거나 비교 비용이 낮은 필드부터 비교
  5. equals 메서드 구현을 끝냈다면, 대칭성, 추이성, 일관성의 세 속성이 만족되는지 검토 및 단위 테스트

### equals 구현 시 주의사항
 * equals 구현 시 hashCode도 재정의하라
 * equals 메서드의 인자 형을 Object에서 다른것으로 바꾸지 마라
   * 인자형 변경시 Object.equals를 재정의하는 것이 아닌 오버로딩이다. @Override 키워드 사용으로 이런 실수는 피할 수 있다.

### lombok @EqualsAndHashCode 구현 예제
  * lombok의 @EqualsAndHashCode 사용 시 equals 메서드는 위의 구현 지침 4단계 + canEqual 검사로 정의된다.
    * canEqual 메서드: 구현 지침 4단계에 따라 슈퍼클래스와 서브클래스에 equals 메서드 정의 시 다음과 같이 일반 규약이 깨지는 경우가 발생한다.
    * [[구현코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter03/item08/SubClass.java)[[테스트코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/test/java/chapter03/item08/SubClassTest.java)
    ```
    // 대칭성 위반
    superClass.equals(subClass) == true
    subClass.equals(superClass) == false
    ```
  * ref. https://projectlombok.org/features/EqualsAndHashCode
  * [[구현코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter03/item08/EqualsAndHashCodeExample.java)[[테스트코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/test/java/chapter03/item08/EqualsAndHashCodeExampleTest.java)
  ```
  public class EqualsAndHashCodeExample {
      private String name;
      private double score;
      private String[] tags;
      
      ...
      
      @Override public boolean equals(Object o) {
          // 1. 자기 자신인지 검사
          if (o == this) return true;
          
          // 2. 자료형 검사
          if (!(o instanceof EqualsAndHashCodeExample)) return false;
          
          // 3. 자료형 변환
          EqualsAndHashCodeExample other = (EqualsAndHashCodeExample) o;
          
          // canEqual 검사
          if (!other.canEqual((Object)this)) return false;
          
          // 4. 중요 필드 비교
          if (this.getName() == null ? other.getName() != null : !this.getName().equals(other.getName())) return false;
          if (Double.compare(this.score, other.score) != 0) return false;
          if (!Arrays.deepEquals(this.tags, other.tags)) return false;
          return false;
      }
      
      protected boolean canEqual(Object other) {
          return other instanceof EqualsAndHashCodeExample;
      }
  }
  ```
