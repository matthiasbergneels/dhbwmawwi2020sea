package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {

    private BorderLayoutExample(){
        super("Border Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        JButton topLabel = new JButton("Oben");

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton centerLabel = new JButton("Mitte");
        centerPanel.add(centerLabel);

        JButton bottomLabel = new JButton("Unten");
        JButton leftLabel = new JButton("Links");
        JButton rightLabel = new JButton("Rechts");


        this.add(topLabel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomLabel, BorderLayout.SOUTH);
        this.add(leftLabel, BorderLayout.WEST);
        this.add(rightLabel, BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutExample();
    }
}
