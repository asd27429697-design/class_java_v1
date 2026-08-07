package useful.ch10;

public class WorkerMain {

    // 메인 쓰레드
    public static void main(String[] args) {
        // 2. 사용하는 방법
        System.out.println("----- main 쓰레드 시작 -----");
        System.out.println(Thread.currentThread());

        // 필요하다면 작업자(쓰레드)를 만들어서 작업을 시킬 수 있다.
        Worker worker1 = new Worker("작업자1");

        // 약속. 쓰레드에게 위임한 일을 시작 시킬려면 Thread 안에 있는 start() 메서드를
        // 반드시 호출해서 run() 안에 정의된 로직이 시작이 된다.
        worker1.start(); // <----
        // 너가 받은 일을 시작해 ...

        System.out.println("----------- main 쓰레드 종료 -------------");

    }
}
