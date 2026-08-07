package com.oop10;

public class StaticRuleTest {

    private String version = "1.0.0"; // 인스턴스 변수
    private static String appName = "로또 번호 생성기"; // static 변수

    // 인스턴스 메소드
    public String getVersion() {
        System.out.println(appName);
        System.out.println(version);
        System.out.println(makeMessage());
        return version;
    }

    // static 메소드
    public static String makeMessage() {
        System.out.println(appName); // appName <-- static 변수
        // 아직 객체가 생성되지 않은 상태 일 수 있기 때문에 사용 못 하게 막음.
        // System.out.println(version); // 불가능                  version <-- 인스턴스 변수
        // System.out.println(getVersion()); // 불가능
        // System.out.println(this.); // 불가능

        return appName + "입니다";
    }


}
