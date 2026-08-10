package useful.ch13;

import java.util.Vector;

public class ChatRoomStore {

    private static Vector<String> users = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        // 사전 기반 지식 - stack (고유 자기 메모리(다른 스레드가 접근 못함))

        System.out.println("==== 채팅방 접속자 시뮬레이션 ====");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("철수");
                System.out.println("[접속] 철수: 현재: " + users.size() + "명");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("영희");
                System.out.println("[접속] 영희: 현재: " + users.size() + "명");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("민준");
                System.out.println("[접속] 민준: 현재: " + users.size() + "명");
            }
        });

        t1.start();
        t2.start();
        t3.start();
        // 내 스레드가 동작 끝날 때 까지 메인 쓰레드에게 대기해 (동기화 처리)
        t1.join();
        t2.join();
        t3.join();
        System.out.println("최종 접속자: " + users);

        users.remove("영희"); // 영희 퇴장

        // 브로드 캐스트(방송한다) 모든 접속한 사용자들에게 메세지 보내...
        for (String u : users) {
            System.out.println("-> " + u + " 에게 전송: 안녕하세요");
        }

    } // end of main
}
