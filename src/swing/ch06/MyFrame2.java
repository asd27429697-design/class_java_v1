package swing.ch06;
import javax.swing.*;

public class MyFrame2 extends JFrame {

    private JLabel backgroundMap;
    private JLabel player;

    public MyFrame2() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("이미지 겹치기 연습");
        setSize(1000, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배경 이미지 설정해보기
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        // 배치 관리자 좌표 ==> 컴포넌트 사이즈와 위치를 직접 지정해야 한다.
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        // 플레이어 이미지 초기화
        ImageIcon playerIcon = new ImageIcon("images/playerL.png");
        player = new JLabel(playerIcon);
        player.setSize(100, 100);
        player.setLocation(200, 510);

    }

    private void setInitLayout() {
        // 루트 패널에 설정
        setLayout(null);
        add(backgroundMap);

        backgroundMap.add(player);
        setVisible(true);
    }

    private void addEventListener() {}


    // 테트스 코드
    public static void main(String[] args) {
        new MyFrame2();
    }

}
