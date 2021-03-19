package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

    private GridLayoutExample(){
        super("Grid Layout Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(0, 2));

        JLabel familyNameLabel = new JLabel("Name:");
        JTextField familyNameTextField = new JTextField(15);
        JLabel nameLabel = new JLabel("Vorname:");
        JTextField nameTextField = new JTextField(15);
        JLabel studentIdLabel = new JLabel("Matrikelnummer:");

        JPanel cellPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField studentIdTextField = new JTextField(15);
        cellPanel5.add(studentIdTextField);

        JLabel ageLabel = new JLabel("Alter:");

        JPanel cellPanel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField ageTextField = new JTextField(5);
        cellPanel7.add(ageTextField);

        this.add(familyNameLabel);
        this.add(familyNameTextField);
        this.add(nameLabel);
        this.add(nameTextField);
        this.add(studentIdLabel);
        this.add(cellPanel5);
        this.add(ageLabel);
        this.add(cellPanel7);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutExample();
    }
}
