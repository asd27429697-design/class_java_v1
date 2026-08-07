package useful.ch10;

// 2. 쓰레드를 사용하는 방법 2번째 - Runnable 인터페이스를 구현해서 만들 수 있다.
public class Worker2 implements Runnable{

    // run() - 위임 시키고자 하는 일을 명시하는 곳 (미리 약속 되어 있음)
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(i + "\t");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
