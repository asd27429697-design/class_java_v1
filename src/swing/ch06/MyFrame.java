package swing.ch06;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {

    private JLabel backgroundMap;
    private JLabel player;

    // 플레이어 이미지 L, R
    ImageIcon playerIconL = new ImageIcon("images/playerL.png");
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");

    // 이동 설정 값
    private final int MOVE_STEP = 10; // 플레이어 이동 픽셀

    public MyFrame() {
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
        playerIconL = new ImageIcon("images/playerL.png");
        player = new JLabel(playerIconL);
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

    private void addEventListener() {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = player.getX();
                int y = player.getY();

               // 제어문 -- switch
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP :
                        if (y > 0) {
                            y -= MOVE_STEP;
                        }
                        break;
                    case  KeyEvent.VK_LEFT :
                        player.setIcon(playerIconL);
                        if (x > 40) {
                            x -= MOVE_STEP;
                        }
                        break;
                    case  KeyEvent.VK_RIGHT :
                        player.setIcon(playerIconR);
                        if (x < 870) {
                            x += MOVE_STEP;
                        }
                        break;
                    case  KeyEvent.VK_DOWN :
                        if (y < 510) {
                            y += MOVE_STEP;
                            break;
                        }
                    default:
                        return;
                } // end of switch

                // 화살표 이벤트를 받아서 다시 플레이어의 좌표값 지정
                player.setLocation(x, y);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        this.setFocusable(true);
        this.requestFocusInWindow();

    }

    public static void main(String[] args) {
        new MyFrame();
    }

}














