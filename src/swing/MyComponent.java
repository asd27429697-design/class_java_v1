package swing;

import javax.swing.*;
import java.awt.*;

public class MyComponent extends JFrame {

    private JButton button;
    private JLabel label;
    private JTextField textField;
    private JPasswordField passwordField;
    private JCheckBox checkBox;

    // get/set
    public JTextField getTextField() {
        return textField;
    }

    MyComponent() {
        setTitle("컴포넌트 확인");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initData() {
        button = new JButton("버튼1");
        label = new JLabel("글자나 이미지 아이콘등을 사용");
        textField = new JTextField("아이디를 입력하세요", 10);
        passwordField = new JPasswordField("비밀번호를 입력하세요", 10);
        checkBox = new JCheckBox("동의");
    }

    public void setInitLayout() {
        setLayout(new FlowLayout(FlowLayout.LEFT,20,100));
        add(button);
        add(label);
        add(textField);
        add(passwordField);
        add(checkBox);
        // 화면에 보일 수 있도록 설정
        setVisible(true);
    }

    // 탬플릿 메서드 설계
    public final void run() {
        initData();
        setInitLayout();

    }
}
