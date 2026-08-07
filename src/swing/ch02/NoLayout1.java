package swing.ch02;

import javax.swing.*;

public class NoLayout1 extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;

    public NoLayout1() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initData();
        setInitLayout();
    }

    public void initData() {
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        button3 = new JButton("button3");
    }

    private void  setInitLayout() {
        // setInitLayout -> null 값을 주면 좌표기반으로 배치할 수 있다.
        setLayout(null);
        // 주의저: 좌표기반 배치관리자를 사용하면
        // 반드시 컴포넌트의 크기를 지정해야하고 x,y축 를 지정해야 한다.

        button1.setSize(100,100);
        button1.setLocation(200,200);

        button2.setSize(100,100);
        button2.setLocation(10,10);

        button3.setSize(100,100);
        button3.setLocation(350,350);

        // 주의 - 프레임에 add를 해줘야 한다
        add(button1);
        add(button2);
        add(button3);


        setVisible(true);
    }
}


