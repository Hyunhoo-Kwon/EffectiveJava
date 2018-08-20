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
 * string constant pool 참고: [https://medium.com/@joongwon - Java String 의 메모리에 대한 고찰](https://medium.com/@joongwon/string-%EC%9D%98-%EB%A9%94%EB%AA%A8%EB%A6%AC%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0-57af94cbb6bc)
 
### 생성자와 정적 팩터리 메소드를 함께 제공하는 변경 불가능 클래스의 경우, 생성자 대신 정적 팩터리 메서드를 이용 (Boolean 클래스 예제)
 * new Boolean(String)대신 Boolean.valueof(String)을 이용하면 불필요한 객체 생성을 피할 수 있다.
 
### 메소드 내부에서 동일 객체를 항상 생성하는 코드는 정적 초기화 블록(static initializer)을 통해 개선
 1. Person 클래스 예제 [[코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter02/item05/Person.java) [[테스트 코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/test/java/chapter02/item05/PersonTest.java)
    * isBabyBoomer 메소드는 호출될 때마다 Calender 객체 하나, TimeZone 객체 하나, Date 객체 두 개 생성
    * isBabyBoomer 100만번 호출 성능: 1.079070247s
 2. PersonRefactor 클래스 예제 (정적 초기화 블록을 통해 개선) [[코드]](https://github.com/Hyunhoo-Kwon/EffectiveJava/blob/master/Examples/src/main/java/chapter02/item05/PersonRefactor.java)
    * Calneder, TimeZone, Date 객체를 클래스가 초기화 될 때 한번 만든다.
    * isBabyBoomer 100만번 호출 성능: 0.014479830s
    
### 자동 객체화(autoboxing)로 인한 불필요한 객체 생성
 * 불필요한 객체 생성 예제
   * sum은 long이 아닌 Long으로 선언되어 있는데, 이 때문에 Integer.MAX_VALUE개의 Long 객체가 생성됨.
 ```
 Long sum = OL;
 for(long i; i<Integer.MAX_VALUE; i++)
   sum += i;
 ```
