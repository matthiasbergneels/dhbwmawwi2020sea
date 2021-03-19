package lecture.chapter10;

import javax.swing.*;

public class MyFirstUI {

    public static void main(String[] args) {

        JFrame myJFrame = new JFrame("Mein erstes UI");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel myLabel = new JLabel("Hallo Welt!");
        myJFrame.add(myLabel);

        JButton myButton = new JButton("Send me to mars");
        myJFrame.add(myButton);

        //myJFrame.setBounds(100, 100, 200, 100);
        myJFrame.pack();
        myJFrame.setVisible(true);
    }
}
