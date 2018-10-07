# EffectiveJava
이팩티브 자바 스터디

### chapter01. 서론

### chapter02. 객체의 생성과 삭제
 > 객체를 만들어야 하는 시점과 그 방법, 객체 생성을 피해야 하는 경우와 그 방법, 적절한 순간에 객체가 삭제되도록 보장하는 방법, 그리고 삭제 전에 반드시 이루어져야 하는 청소 작업들을 관리하는 방법을 살펴본다.
 - [규칙 1.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter02/item01) 생성자 대신 정적 팩토리 메서드를 사용할 수 없는지 생각해 보라
 - [규칙 2.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter02/item02) 생성자 인자가 많을 때는 Builder 패턴 적용을 고려하라
 - [규칙 3.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter02/item03) private 생성자나 enum 자료형은 싱글턴 패턴을 따르도록 설계하라
 - [규칙 4.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter02/item04) 객체 생성을 막을 때는 private 생성자를 사용하라
 - [규칙 5.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter02/item05) 불필요한 객체는 만들지 말라
 - [규칙 6.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter02/item06) 유효기간이 지난 객체 참조는 폐지하라
 - [규칙 7.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter02/item07) 종료자 사용을 피하라

### chapter03. 모든 객체의 공통 메서드
 > Object 클래스에 정의된 비-final 메서드(equals, hashCode, toString, clone, finalize)와 Comparable.compareTo 메서드가 언제, 어떻게 재정의 하는지 일반 규약에 따라 살펴본다.
 - [규칙 8.](https://github.com/Hyunhoo-Kwon/EffectiveJava/tree/master/Examples/src/main/java/chapter03/item08) equals를 재정의할 때는 일반 규약을 따르라
