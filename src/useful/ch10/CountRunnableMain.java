package useful.ch10;

public class CountRunnableMain {

    public static void main(String[] args) {

        System.out.println("쓰레드 시작");

        CountRunnable countRunnable = new CountRunnable();

       Thread thread = new Thread(countRunnable);
       thread.start();


        System.out.println("쓰레드 종료");


    }
}
