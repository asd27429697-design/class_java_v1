package useful.ch01;

import javax.swing.*;
import java.awt.*;

public class MyBoarderFrame extends JFrame {

    private JButton button[] = new JButton[5];
    String[] positions = {
            BorderLayout.NORTH,
            BorderLayout.SOUTH,
            BorderLayout.CENTER,
            BorderLayout.WEST,
            BorderLayout.EAST
    };
    private BorderLayout borderLayout;

    public MyBoarderFrame() {

        setTitle("boarderLayout 연습");
        setSize(600, 400);
        setVisible(true);
        // x 누르면 동시에 프로그램도 종료 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initData();
        setInitLayout();
    }

    public void initData() {
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("버튼" + (i + 1));
        }

        borderLayout  = new BorderLayout();
    }

    public void setInitLayout() {
        // 배치 관리자 선정을 하고 Frame 설정해 보자.
        setLayout(borderLayout); // Frame에 배치관리자 설정
        // 보더 레이아웃은 add 할때 동 서 남 북 가운데 를 명시해주어야 한다.
        for (int i = 0; i < button.length; i++) {
            add(button[i], positions[i]);
        }
    }

}
