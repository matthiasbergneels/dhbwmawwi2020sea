package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

    private FlowLayoutExample(){
        super("Flow Layout Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel myLabel = new JLabel("Let's go to Mars");
        JTextField myTextField = new JTextField(20);
        JButton myButton = new JButton("Send me to Mars!");

        this.add(myLabel);
        this.add(myTextField);
        this.add(myButton);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}
