package useful.ch14;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        // 순서가 없고 중복된 값을 저장하지 않는다.
        Set<String> set = new HashSet<>();

        // 추가
        set.add("철수");
        set.add("영희");
        set.add("철수"); // 중복된 값은 덮어쓰기 됨 !
        System.out.println(set.toString());
        System.out.println(set.size()); // 2개

        // 포함 여부
        System.out.println(set.contains("철수"));
        System.out.println(set.contains("민준"));

        // 삭제
        set.remove("철수");
        System.out.println("----------------------------");
        // 전체 순회
        for (String name : set) {
            System.out.println(name);
        }


    } // end of main
}
