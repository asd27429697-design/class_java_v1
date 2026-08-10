package useful.ch14;

import java.util.*;

public class LottoGameSet {

    public static void main(String[] args) {

        Set<Integer> lotto = new HashSet<>();
        Random random = new Random();
        int count = 0;
        // (5)(1)(2)(3)(4)(9)  <- lotto.size() < 6 0 --> false
        while (lotto.size() < 6) {
            int number = random.nextInt(45) + 1;
            lotto.add(number);
            count++;
        }
        System.out.println("이번주 로또 번호: " + lotto);
        System.out.println("while 문 반복 횟수: " + count);

        System.out.println("--------------------------------------------------");
        // ArrayList 생성자 안에 Set 계열을 넣어서 List 계열의 객체를 생성할 수 있다.
        List<Integer> sortedLotto = new ArrayList<>(lotto);
        System.out.println(sortedLotto);
        System.out.println("--------------------------------------------------");
        // 오름 차순 정렬 (ArrayList)
        Collections.sort(sortedLotto);
        System.out.println("오름 차순 된 로또 번호: " + sortedLotto);

        // 도전 과제 - 내림 차순으로 정렬하는 코드를 작성하시오 (문서 api, 구글링, Ai)
        System.out.println("--------------------------------------------------");
        Collections.sort(sortedLotto, Collections.reverseOrder());
        System.out.println("내림 차순 된 로또 번호: " + sortedLotto);




    } // end of main
}
