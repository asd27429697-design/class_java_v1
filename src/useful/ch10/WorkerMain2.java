package useful.ch10;

public class WorkerMain2 {

    // 메인 쓰레드
    public static void main(String[] args) {

        System.out.println("------- main 쓰레드 시작 ---------");

        Worker2 worker2 = new Worker2();
        // tip 쓰레드를 동작 시킬려면 무조건 Thread 의 start(); 호출 해야 한다
        // worker2.start(); <----- start() 없는 상태 임.

//        new Thread(worker2).start();
//        t.start();
        new Thread(worker2).start();


        System.out.println("------- main 쓰레드 종료 ---------");

    } // end of main
}
