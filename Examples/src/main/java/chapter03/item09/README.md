## 규칙 9. equals를 재정의할 때는 반드시 hashCode도 재정의하라

### hashCode
 * equals 메서드를 재정의하는 클래스는 반드시 hashCode 메서드도 재정의 해야 한다
 * 그렇지 않으면 hashCode의 일반 규약을 어기게 되므로, hash 기반 컬렉션과 함께 사용하면 오동작하게 된다
   * equals 메서드가 같다고 판단한 두 객체라 해도 Object의 hashCode 입장에서 보면 다른 두 객체이다
   * 따라서 Object의 hashCode 메서드는 규약대로 같은 정수를 반환하는 대신, 무작위로 선택된 것처럼 보이는 두 개의 정수를 반환한다
 * 좋은 해시 함수는 다른 객체에는 다른 해시 코드를 반환한다
   * 따라서 이상적인 해시 함수는 서로 다른 객체들을 모든 가능한 해시 값에 균등하게 배분해야 한다
 
### hashCode 일반 규약
 * equals(Object) 같은 두 객체의 hashCode 값은 같아야 한다
 * equals(Object) 메서드가 다른 두 개체의 hashCode 값은 꼭 다를 필요는 없다
   * 그러나 서로 다른 hashCode 값이 나오면 해시 테이블의 성능이 향상될 수 있다
   
### hashCode 메서드 구현 지침
 1. 0이 아닌 int 상수를 result로 지정
 2. 객체 안의 필드(equals 메서드가 사용하는 필드) f에 대해:
    1. 해당 필드에 대한 int 해시 코드 c를 계산한다
        1. boolean: `(f ? 1:0)`
        2. byte, char, short, int: `(int) f`
        3. long: `(f^(f>>>32))`
        4. float: `Float.floatToIntBits(f)`
        5. double: `Double.doubleToLongBits(f)`
        6. 필드가 객체 참조이고 equals 메서드가 해당 필드의 equals 메서드를 재귀적으로 호출하는 경우: hashCode 메서드 재귀적으로 호출. 필드 값이 null일 경우 0 반환
        7. 필드가 배열인 경우 배열의 각 원소가 별도 필드인 것처럼 계산
    2. 계산된 해시 코드 c를 result에 결합
      ```
      result = 31 * result + c;
      ```
 3. result를 반환한다
 4. hashCode 구현이 끝났다면, 동치 관계에 있는 객체의 해시 코드 값이 같은지 검토 및 단위 테스트
 
### hashCode 구현 시 주의사항
 * equals 계산에 쓰이지 않는 필드는 반드시 제외
 * 0이 아닌 상수를 result로 지정하는 이유: 해시 값 c가 0인 필드도 result에 영향을 준다. 그 결과로 해시 충돌(collision)을 낮춘다.
 * result 곱셈은 필드 순서에 따라 계산 결과가 달라지도록 만든다
   * result 곱셈이 없을 경우 순서만 바뀐 모든 문자열의 해시 코드는 동일했을 것이다
   
