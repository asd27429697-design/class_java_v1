package com.oop10;

import java.util.Random;

public class LottoNumberMaker {

    // static 변수 활용
    // 난수 생성기 하만 만들어서 계속 재사용해보자.
    private static Random random = new Random();

    // static 메소드 - 1 부터 45 사이의 번호를 하나 만들어서 반환 한다
    public static int makeNumber() {
        // 0 ~ 44 -> + 1 ex) 0 + 1 --> 1 , 44 + 1 = 45
        return random.nextInt(45) + 1;
    }
}
