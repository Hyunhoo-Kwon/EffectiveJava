## 규칙6. 유효기간이 지난 객체 참조는 폐지하라
### 메모리 누수 예제
 * 의도치 않은 객체 보유(unintentional object retention) [[코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter02/item06/MyStack.java)
   * 스택이 커졌다가 줄어들면서 제거한 객체들을 쓰레기 수집기(garbage collection)가 처리하지 못해서 메모리 누수 발생
   * 스택을 사용하는 프로그램이 그 객체를 더 이상 참조하지 않지만, 스택이 그런 객체에 대한 만기 참조(obsolete referenct)를 제거하지 않기 때문
 ```
 public void push(Object e) {
     elements[size++] = e;
 }
 ```
 * 해결 방법: 객체 사용이 끝나면 객체 참조를 null 처리한다
   * 실제로 사용되는 부분은 있는 원소가 참조하는 객체는 할당된 객체지만, 나머지 원소가 참조하는 객체는 반환 가능한 개체들이다
   * 하지만 쓰레기 수집기 입장에서는 elements 내의 참조들은 전부 유효해 보이기 때문에, 사용하지 않는 참조들을 즉시 null 처리하면 반환해도 좋은 객체가 어떤 것인지 알 수 있다
 ```
 public void push(Object e) {
     elements[size++] = e;
     elements[size] = null // 만기 참조 
 }
 ```

### 자체적으로 관리하는 메모리가 있는 클래스를 만들 때는 메모리 누수가 발생하지 않도록 주의해야 한다
 * 더 이상 사용되지 않는 원소 안에 있는 객체 참조는 반드시 null로 바꿔 주어야 한다
