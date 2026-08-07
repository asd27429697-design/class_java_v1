package swing.ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveLabelFrame extends JFrame {

    private JLabel label;
    private final int MOVE_STEP = 10;

    public MoveLabelFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("방향키로 별 움직이기 연습");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        label = new JLabel("☆");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        // 좌표 기반 - 크기, 위치 (직접 설정 해야 함)
        label.setSize(50, 50); // 사이즈
        label.setLocation(200, 200); // 시작 위치
    }

    private void setInitLayout() {
        setLayout(null); // null -> 좌표 기반
        add(label);
        setVisible(true);
    }

    private void addEventListener() {

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode  = e.getKeyCode();
                int x = label.getX();
                int y = label.getY();
                label.setText("☆");

                if (keyCode == KeyEvent.VK_UP) {
                    label.setLocation(x, y - MOVE_STEP);
                } else if(keyCode == KeyEvent.VK_LEFT) {
                    label.setLocation(x - MOVE_STEP, y);
                } else if(keyCode == KeyEvent.VK_RIGHT) {
                    label.setLocation(x + MOVE_STEP, y);
                } else if(keyCode == KeyEvent.VK_DOWN) {
                    label.setLocation(x , y + MOVE_STEP);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("★");
            }
        });


        // 버그 발생을 한다면 아래 코드 추가해보세요
        // 키보드 이벤트를 받기 위해 프레임이 포커스를 가질 수 있게 합니다.
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new MoveLabelFrame();
    }
}
