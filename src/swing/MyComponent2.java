package swing;

import javax.swing.*;
import java.awt.*;

public class MyComponent2 extends JFrame {

    private JButton button;
    private JLabel label;
    private JTextField textField;
    private JPasswordField passwordField;
    private JCheckBox checkBox;

    public void NaverLogin() {
        setTitle("네이버 로그인");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initData();
        setInitLayout();
        setVisible(true);
    }


    private void initData() {
        button = new JButton("로그인");
        label = new JLabel("NAVER");
        textField = new JTextField("아이디", 20);
        passwordField = new JPasswordField("비밀번호", 20);
        checkBox = new JCheckBox("로그인 상태 유지");
    }

    public void setInitLayout() {
        setLayout(new GridLayout(5, 1, 10, 10));

        add(button);
        add(label);
        add(textField);
        add(passwordField);
        add(checkBox);
        // 화면에 보일 수 있도록 설정

    }

}
