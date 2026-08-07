package swing;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private JButton[] button1 = new JButton[3];

//
    // 문제2. 배열을 활용해서 코드를 수정해주세요.

    public MyFrame() {
        super.setTitle("배치 관리자 연습");
        super.setSize(600, 300);
        super.setVisible(true);

        initData();
        setInitLayout();
    }

    public void initData() {
        for (int i = 0; i < button1.length; i++) {
            button1[i] = new JButton("button" + (i + 1));
        }

    }

    public void setInitLayout() {
        // 배치 관리자 선언
        FlowLayout flowLayout = new FlowLayout();
        // 컴포넌트들을 수평, 수직으로 프레임 배치해 주는 녀셕이다.
        super.setLayout(flowLayout);
        for (int i = 0; i < button1.length; i++) {
            super.add(button1[i]);
        }
    }


    // 테스트 코드 작성
    public static void main(String[] args) {
       new MyFrame(); // 생성자 호출 --> 생성자에 있는 로직이 동작 한다.

    } // end of main

} // end of class
