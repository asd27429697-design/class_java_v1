package useful.ch15;

import java.util.HashMap;
import java.util.Map;

public class ScoreHashMap {

    public static void main(String[] args) {
        //    키       값
        Map<String, Integer> scores = new HashMap<>();

        // 추가 (put)
        scores.put("철수", 90);
        scores.put("영희", 85);
        scores.put("민준", 92);
        scores.put("철수", 100);
        // put() 사용해서 키값이 중복이 된다면 덮어씌우기가 된다
        // 이 특징을 활용하면 업데이트 기능을 구현 할 수 있다.
        System.out.println(scores);

        // 조회 (get)
        System.out.println(scores.get("철수")); // 키가 있으면 Value 반환
        System.out.println(scores.get("없는키")); // 키가 없으면 null 반환

        // 포함 여부
        System.out.println(scores.containsKey("철수")); // true (키 존재 여부)
        System.out.println(scores.containsValue(85)); // true (값 존재 여부)

        // 삭제
        int removedResult = scores.remove("철수");
        System.out.println(removedResult + "가 삭제 되었습니다");
        System.out.println(scores);

        // 크기 확인
        System.out.println(scores.size());

        // 전체 순회
        for (String k : scores.keySet()) {
            System.out.println(k + ": " + scores.get(k) + "점");
        }


    } // end of main
} // end of class
