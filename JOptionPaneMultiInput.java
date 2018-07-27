package movietimes;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;

public class JOptionPaneMultiInput {

    public static void main(String[] args) {
        JTextField movieName = new JTextField(5);
        JTextField movieLengthHrs = new JTextField(5);
        JTextField movieLengthMns = new JTextField(5);
        JPanel p = new JPanel(new BorderLayout(5, 5));

        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        labels.add(new JLabel("Movie Name:", SwingConstants.RIGHT));
        labels.add(new JLabel("Movie Length(Hours):", SwingConstants.RIGHT));
        labels.add(new JLabel("Movie Length(Minutes)", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        controls.add(movieName);
        controls.add(movieLengthHrs);
        controls.add(movieLengthMns);
        p.add(controls, BorderLayout.CENTER);
        int result = JOptionPane.showConfirmDialog(null, p,
               "Please Enter Movie Data", JOptionPane.OK_CANCEL_OPTION);
       /* if (result == JOptionPane.OK_OPTION) {
            System.out.println("Movie Name: " + movieName.getText());
            System.out.println("Movie Length(Hours): " + movieLengthHrs.getText());
            System.out.println("Movie Length(Mins): " + movieLengthMns.getText());
        }
    */}
}
