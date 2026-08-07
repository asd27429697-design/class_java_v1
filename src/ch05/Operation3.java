package ch05;

/**
 * 복합 대입 연산자
 * 대입 연산자와 다른 연산자가 함께 쓰이는 것
 */
public class Operation3 {
    // 매인 함수
    public static void main(String[] args) {
        int n1 = 100;
        n1 = n1 + 1;
        n1 = n1 + 1; // 원래 값에서 +1씩 해주고 있다.
        n1 = n1 + 1; // 귀찮음 .... 간소화 하기 위해서 복합 대입 연사자를 활용할 수 있다.

        System.out.println("---------------------------------");

        // 시작 값 설정
        int score = 0;

        // score = score + 3;
        // 1. 점수 추가
        score += 3; // 복합 대입 연산자
        System.out.println("농구 점수 3점 추가 " + score);

        // 2. 점수 감점
        // score = score - 3;
        score -= 3;
        System.out.println("농구 점수 3점 감점 " + score);

        // 3. 점수 두배 증가 (복합대입 연산자 사용)
        int num1 = 5;
        num1 *= 4;
        System.out.println("점수 두배 증가 " + num1);


        // 4. 점수 반으로 감소 (복합대입 연산자 사용)
        int num2 = 6;
        num2 /= 2;
        System.out.println("점수 반으로 감소 " + num2);


        // 5. 점수에 대한 나머지 연산
        int num3 = 7;
        num3 %= 2;
        System.out.println("점수 나머지 계산 " + num3);

    } // end of main

} // end of class
