package useful.ch15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordBook {

    public static void main(String[] args) {
        // apple, -> 사과
        Map<String, String> words = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        words.put("apple", "사과");
        words.put("banana", "바나나");
        words.put("cherry", "체리");

        while (true) {
            System.out.println("\n===영한 단어장===");
            System.out.println("1. 단어 추가 2. 단어 검색 3. 전체 출력 4. 종료");
            System.out.println("선택: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.println("영어 단어를 입력하세요");
                String english = sc.nextLine();
                System.out.println("한글 단어를 입력하세요");
                String korean = sc.nextLine();
                words.put(english, korean);
                System.out.println("단어가 추가 되었습니다");

            } else if (choice.equals("2")) {
                System.out.println("검색할 단어를 입력하세요");
                String search = sc.nextLine();
                System.out.println(words.get(search));

            } else if (choice.equals("3")) {
                System.out.println(words);

            } else if (choice.equals("4")) {
                System.out.println("종료");
                break;
            } else {
                System.out.println("잘못 된 검색입니다. 다시 검색하세요.");
            }
        }


        // 자원 닫기
        sc.close();


    }
}
