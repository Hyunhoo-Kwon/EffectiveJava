## 규칙 3. private 생성자나 enum 자료형은 싱글턴 패턴을 따르도록 설계하라
### 싱글턴 패턴을 구현하는 방법
 1. public static 멤버 + private 생성자를 이용하는 방법
 ```
 public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {...}
 }
 ```
 2. private static 멤버 + private 생성자를 이용하는 방법 + 정적 팩토리 메서드를 이용하는 방법
 ```
 public class Elvis {
    private static final Elvis INSTANCE;
    private Elvis() {...}
    public static Elvis getInstance() { 
      if(INSTANCE == null)
        INSTANCE = new Elvis(); 

      return INSTANCE;
    }
 }
 ```
 3. Enum 싱글턴
 ```
 public Enum Elvis {
    INSTANCE;
 }
 ```
