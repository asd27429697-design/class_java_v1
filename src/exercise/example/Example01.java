package exercise.example;

public class Example01 {
    public static void main(String[] args) {
        // 1. 실수 3.14159를 float 타입의 piBox 이름으로 변수에 선언하고 초기화해 보세요.
        float piBox = 3.14159F;


        // 2. 정수 30억을 populationBox 이름으로 변수에 담아 보세요.
        long populationBox = 3000000000L;

        // 3. 문자열 "Hello Java"를 messageBox 이름으로 변수에 담아 보세요. (힌트: 참조 타입 String 사용)
        String messageBox = "Hello Java";

        // 4. boolean 타입의 isPassed 변수를 선언하고 true로 초기화한 뒤,
        //    다음 줄에서 false로 변경해 보세요.
        boolean isPassed = true;
        isPassed = false;

        // 5. 기본 데이터 타입(8가지) 중 정수를 담을 수 있는 타입 4가지와
        //    실수를 담을 수 있는 타입 2가지를 크기가 작은 순서대로 적어보세요.
        // 정수형 (작은 것부터) : byte, short, int, long
        // 실수형 (작은 것부터) : float, double

        // 1. int 타입 변수 num1에 100을 넣고,
        //    double 타입 변수 num2에 num1을 담아보세요. (자동 형변환 복습)
        int num1 = 100;
        double num2 = num1;


        // 2. double 타입 변수 pi에 3.14를 넣고,
        //    int 타입 변수 intPi에 pi를 강제로 변환(명시적 형변환)해서 담아보세요.
        double pi = 3.14;
        int intPi = (int) pi;


        // 3. char 타입 변수 ch1에 문자 'A'를 담고,
        //    int 타입 변수 chCode에 ch1을 담아서 출력했을 때 어떤 숫자가 나올지 예측하여 주석으로 적어보세요.
        char ch1 = 'A';
        int chCode = ch1;
        // 답: 65


        // 4. int a = 10; int b = 20; 선언 후,
        //    System.out.println("결과: " + a + b); 의 출력 결과를 예측해서 주석으로 적어보세요.
        int a = 10;
        int b = 20;
        System.out.println("결과: " + a + b);
        // 답: 1020


        // 5. 다음 중 컴파일 에러(오류)가 발생하는 줄을 모두 찾아서 이유를 서술해 보세요.
        // A) byte b = 128;
        // B) float f = 3.14;
        // C) long l = 100;
        // D) char c = "A";
        // -> 에러가 나는 기호(A~D)와 이유:

        //A)는 이유: byte가 담을 수 있는 정수 범위는 -128 ~ 127까지입니다!
        // 128은 1이 넘어가서 범위 초과(Overflow)로 에러가 납니다.
        // (-를 붙이지 않아도 127까지만 담을 수 있어요!)
        //B)는 float은 소숫점이면 3.14하고 값 뒤에 F나 f를 붙여야한다
        //C)는 정답
        //D) char는 "A"가 아니라 'A' 여야 합니다



        // 1. 당신의 현재 나이(예: 25)를 age 이름의 변수에 담아 보세요.
        int age = 25;


        // 2. 대한민국 인구수 약 5100만(51000000)을 population 이름의 변수에 담아 보세요.
        long population = 51000000L;

        // 3. 원주율 값 3.1415926535를 pi 이름의 변수에 담아 보세요. (double 타입 활용)
        double pi1 = 3.1415926535;

        // 4. 알파벳 대문자 'Z'를 lastLetter 이름의 변수에 담아 보세요.
        char lastLetter = 'Z';


        // 5. '로그인 성공 여부'를 나타내는 isLoggedIn 변수를 선언하고, 참(true) 값을 담아 보세요.
        boolean isLoggedIn = true;

    }
}
