package com.oop14;

// extends 상속을 받을때 쓴다
public class C extends A {

    // 여기 코드에는 보이지는 않지만 자동으로 A에 선언된 필드들을 물려 받는다
    // 단, 접근 제어 지시자는 그대로 동작 한다.

    int level;
    String nickName;

}
