package exercise.example;

public class Example03 {
    public static void main(String[] args) {
        int score = 100;
        double temperature = -5.5;
        int num1 = 15;
        int num2 = 40;

//        score 변수 값에 1을 더한 후 값을 변경하여 출력하세요. (단, 단항 연산자 사용)
        score++;
        System.out.println("score: " + score);
//        temperature 변수의 값을 5.5(양수)로 화면에 출력하세요.
//        (단, 변수 자체의 원본 값은 절대 변경하지 마세요.)
        System.out.println(-temperature);

//        변수 score와 temperature, 관계(비교) 연산자를 사용하여
//        result1 변수에 최종적으로 false가 담기도록 식을 만들고 출력하세요.
       boolean result1 = (score < temperature);
        System.out.println("result1: " + result1);


//        변수 result2를 새로 선언하고, num1과 num2의 합이 숫자 50보다 작은지
//        비교 연산자를 사용해서 결과를 담고 출력하세요.
        boolean result2 = (num1 + num2) < 50;
        System.out.println("result2: " + result2);

//        num1과 num2 값 중 더 작은 수를 구하여 min 변수에 담고 출력하세요.
//        (단, 삼항 연산자 사용)
        int min;

        min = (num1 < num2) ? num1 : num2;
        System.out.println("min: " + min);
    }
}
