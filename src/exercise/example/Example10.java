package exercise.example;


import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
//        문제1: 총 무게가 450g인 피자 한 판의 칼로리가 총 1125.5 kcal입니다.
//        피자 총 무게는 정수 변수(int), 총 칼로리는 실수 변수(double)에 각각 저장하세요.
//        그 후, 피자 1g당 칼로리(실수)를 계산하여 화면에 출력하는 프로그램을 작성하세요.

        int weight = 450;
        double calorie = 1125.5;

        double sum = calorie / weight;
        System.out.println("피자 1g당: " + sum + "칼로리");

        System.out.println("---------------------------------");

//        문제2: 나이를 뜻하는 정수 변수 int age = 13;
//        과 버스 카드가 대여용 카드인지 일반 카드인지 판별하는
//        논리형 변수 boolean isRental = false;를 선언하세요.
//        다음 조건에 맞게 버스 요금 메시지를 출력하는 프로그램을 작성하세요.
//        나이가 6세 미만이거나, 나이가 65세 이상이면: "복지 대상자로 무료 승차입니다."
//        나이가 8세 이상이고 19세 이하이면서, 대여용 카드가 아닐 때
//        (isRental == false): "청소년 할인 요금이 적용됩니다."
//        그 외의 모든 경우: "일반 성인 요금이 부과됩니다."

        int age = 13;
        boolean isRental = false;

        if (age < 6 || age >= 65) {
            System.out.println("복지 대상자로 무료 승차입니다.");
        } else if (age >= 8 && age <= 19 && isRental == false) {
            System.out.println("청소년 할인 요금이 적용됩니다.");
        } else {
            System.out.println("일반 성인 요금이 부과됩니다.");
        }

        System.out.println("----------------------------------");

//        문제3: for 반복문을 사용하여 숫자를 1부터 20까지 출력하되,
//        4의 배수(4, 8, 12, 16, 20)를 만났을 때는 숫자를 화면에 출력하지 않고
//        그냥 건너뛰는(continue) 프로그램을 작성하세요.

        for (int i = 1; i <= 20; i++) {
            if (i % 4 == 0) {
                continue;
            }
            System.out.println(i);
        }

//   문제4: 배달 앱 장바구니 총합을 뜻하는 int totalCart = 0; 변수를 while문 밖에 만드세요.
//   while(true) 문 안에서 Scanner를 통해 추가할 음식의 가격을 계속 입력받습니다.
//   사용자가 음식 가격을 입력할 때마다 장바구니 총합에 누적해서 더합니다.
//   음식을 더한 직후, 장바구니 총합이 최소 주문 금액인 15,000원을
//   넘어서는 순간(>= 15000), "최소 주문 금액이 충족되었습니다! 배달 주문을 시작합니다."
//   를 출력하고 break로 탈출하세요.반복문이 완전히 끝난 바깥에서
//   "최종 결제 금액: [총합]원"을 딱 한 번만 깔끔하게 출력하세요.
        Scanner sc = new Scanner(System.in);
        System.out.println("--- 배달 앱 장바구니 시스템 --- ");
        int totalCart = 0;

        while (true) {
            System.out.println("추가할 음식 가격을 입력하세요: ");
            int sum1 = sc.nextInt();

            totalCart = totalCart + sum1;
            if (totalCart >= 15000) {
                System.out.println("최소 주문 금액이 충족되었습니다. 배달 주문을 시작합니다");
                break;
            }
        }
        System.out.println("최종 결제 금액: " + totalCart + "원");

    }
}
