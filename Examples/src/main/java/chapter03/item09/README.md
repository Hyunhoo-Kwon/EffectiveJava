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
