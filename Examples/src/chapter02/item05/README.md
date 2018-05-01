## 규칙 5. 불필요한 객체는 만들지 말라
### 불필요한 객체 생성 예제 (String 생성 예제)
 1. 생성자를 호출하는 방식
    * 생성자는 호출할 때마다 새 객체를 만든다. (Heap 영역에 존재)
 ```
 String s = new String("stringette");
 ```
 2. 리터럴을 이용한 방식
    * 리터럴을 이용할 경우 string constant pool 영역에 존재하게 된다.
    * String을 리터럴로 선언할 경우 내부적으로 String intern() 메소드 호출: intern 메소드는 주어진 문자열이 string constant pool에 있는지 검색 후 해당 주소값 반환. 없을 경우 string constant pool에 넣고 새로운 주소값 반환.
    * 따라서, 리터럴 방식은 실행할 때마다 객체를 만드는 대신, 동일한 String 객체를 사용한다.
 ```
 String s = "stringette"
 ```
 
### 생성자와 정적 팩터리 메소드를 함께 제공하는 변경 불가능 클래스의 경우, 생성자 대신 정적 팩터리 메서드를 이용 (Boolean 클래스 예제)
 * new Boolean(String)대신 Boolean.valueof(String)을 이용하면 불필요한 객체 생성을 피할 수 있다.
 
### 메소드 내부에서 동일 객체를 항상 생성하는 코드는 정적 초기화 블록(static initializer)을 통해 개선
