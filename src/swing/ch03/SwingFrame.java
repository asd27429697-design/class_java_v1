package swing.ch03;

import javax.swing.*;
import java.awt.*;

// 중첩 클래스 활용
public class SwingFrame extends JFrame {

    SwingPanel swingPanel;

    public SwingFrame() {

        setTitle("집 꾸미기");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        swingPanel = new SwingPanel();
        add(swingPanel);


        setVisible(true);

    }

   static class SwingPanel extends JPanel {

       @Override
       public void paint(Graphics g) {
           super.paint(g);

           g.drawLine(150, 180, 250, 100);
           g.drawLine(250,100,350,180);
           g.drawLine(150,180,350,180);
           g.drawRect(170,180,160,150);
           g.drawRect(230,250,30,80);
           g.drawRect(180,210,40,40);



       }
   }


    public static void main(String[] args) {
        new SwingFrame();
    }
}
