## 규칙 5. 불필요한 객체는 만들지 말라
### String 생성 예제
 1. 생성자를 호출하는 방식
    * 생성자는 호출할 때마다 새 객체를 만든다. (Heap 영역에 존재)
 ```
 String s = new String("stringette");
 ```
 2. 리터럴을 이용한 방식
    * 리터럴을 이용할 경우 string constant pool 영역에 존재하게 된다.
    * String을 리터럴로 선언할 경우 내부적으로 String intern() 메소드 호출: intern 메소드는 주어진 문자열이 string constant pool에 있는지 검색 후 해당 주소값 반환. 없을 경우 string constant pool에 넣고 새로운 주소값 반환.
 ```
 String s = "stringette"
 ```
