package useful.ch10;

// 1. 쓰레드를 추가로 만들어서 사용하는 방법 - 상속활용

public class Worker extends Thread{

    String name;

    public Worker(String name) {
        this.name = name;
    }

    // 약속되어 있는 부분 run() 추상메서드 안에서 작업자(쓰레드)에게
    // 어떤일을 시킬지 정의 해주어야 한다.
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("worker: " + name + ": " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
