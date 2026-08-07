package swing.ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListenerFrame extends JFrame {

    private final int FREAM_SIZE = 500;
    private JTextArea textArea;

    public KeyEventListenerFrame() throws HeadlessException {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(FREAM_SIZE,FREAM_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // 사용자가 마우스로 크기를 조정 못 하게 막음

        textArea = new JTextArea();
    }

    private void setInitLayout() {
        add(textArea);
        setVisible(true);
    }

    private void addEventListener() {
    // 이벤트 리스너 등록 - 익명 내부 클래스로 처리
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("키 누름: " + e.getKeyCode());
                // 도전 - 이벤트를 받아서 위 쪽 화살표면 위쪽 화살표 출력
                if (e.getKeyCode() == 38) {
                    textArea.append("⬆ 위\n");
                } else if (e.getKeyCode() == 37) {
                    textArea.append("⬅ 왼쪽\n");
                } else if (e.getKeyCode() == 39) {
                    textArea.append("➡ 오른쪽\n");
                } else if (e.getKeyCode() == 40) {
                    textArea.append("⬇ 아래\n");
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased 발생: " + e.getKeyCode());
            }
        });

    }

    public static void main(String[] args) {
        new KeyEventListenerFrame();
    }

}
