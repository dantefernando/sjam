
// package start;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
    private static void createAndShowGUI() { 
        JFrame jFrame = new JFrame("About me"); // Make Frame
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); // Make Panel
        jFrame.add(panel); // Add panel to jFrame

        JLabel label0 = new JLabel("aboutMeBox"); // Make Label0

        Border border = BorderFactory.createLineBorder(Color.RED);
        label0.setBorder(border);
        label0.setPreferredSize(new Dimension(300, 50));

        String labelText = "<html>Basic Information about Dante:<br>"
          + "Name: Dante F<br>"
          + "School: Laurel Heights Secondary School</html>";

        label0.setText(labelText);
        label0.setHorizontalAlignment(JLabel.CENTER);
        label0.setVerticalAlignment(JLabel.CENTER);



        JLabel label1 = new JLabel("activitiesBox");

        Border border1 = BorderFactory.createLineBorder(Color.BLACK);
        label1.setBorder(border1);
        label1.setPreferredSize(new Dimension(150, 80));

        String label1Text = "<html>Activities:<br>"
          + "Going to the Gym<br>"
          + "Learning about Cars<br>"
          + "Fixed Gear Bicycles<br>"
          + "Playing Basketball</html>";

        label1.setText(label1Text);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);


        // jFrame.add(label0);
        // jFrame.add(label1);
        panel.add(label0);
        panel.add(label1);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
          }
      });
  }

// public static void main(String[] args) {
//         javax.swing.SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 createAndShowGUI();
//           }
//       });
//   }


}

