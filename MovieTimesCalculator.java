package movietimes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;

public class MovieTimesCalculator {

    private ArrayList<Movie> movieslist = new ArrayList<Movie>();
    private ArrayList<Movie> path = new ArrayList<Movie>();

    public void moviePrompt() {
        boolean cont = true;
        ArrayList<JTextField> JTextArr = new ArrayList<JTextField>();
        while (cont) {
            ArrayList<Integer> morningshow = new ArrayList<Integer>();
            ///////////////////////////////////////////////Time Initializations//////////////////////////////////////
            boolean time = true;
            ArrayList<Integer> beghours = new ArrayList<Integer>();
            ArrayList<Integer> begminutes = new ArrayList<Integer>();
            //////////////////////////////////////////////Input movie data/////////////////////////////////////////
            JTextArr = JOptionPaneMultiInput("Enter Movie Name: ", "Enter Movie Length (Hours): ", "Enter Movie Length(Minutes): ");
            String name = (JTextArr.get(0)).getText();
            int hours = Integer.parseInt(JTextArr.get(1).getText());
            int minutes = Integer.parseInt(JTextArr.get(2).getText());;
            /////////////////////////////////////////////Time Loop///////////////////////////////////////////////////
            while (time) {
                JTextArr = JOptionPaneMultiInput("Enter beginning time (hours): ", "Enter beginning time (minutes): ", "Add another showtime ?? : (y or n)");
                beghours.add(Integer.parseInt(JTextArr.get(0).getText()));
                begminutes.add(Integer.parseInt(JTextArr.get(1).getText()));
                String timeprompt = (JTextArr.get(2)).getText();
                if (timeprompt.equals("y")) {
                    time = true;
                } else {
                    time = false;
                }
               /* int morningshowint = JOptionPane.showConfirmDialog(null, "Morning??", "Is this a morning show(AM)?", JOptionPane.YES_NO_OPTION);
                if (morningshowint == JOptionPane.YES_OPTION) {
                    morningshow.add(1);
                } else {
                    morningshow.add(0);
                }*/
            }
            ///////////////////////////////////////////////////////////////////
            //Movie movie = new Movie(name, hours, minutes, beghours, begminutes, morningshow);
            Movie movie = new Movie(name, hours, minutes, beghours, begminutes);
            movieslist.add(movie);
            int reply = JOptionPane.showConfirmDialog(null, "Add Another Movie??", "Another Movie?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                cont = true;
            } else {
                cont = false;
            }
        }
    }

    public ArrayList JOptionPaneMultiInput(String s1, String s2, String s3) {
        JTextField in1 = new JTextField(5);
        JTextField in2 = new JTextField(5);
        JTextField in3 = new JTextField(5);
        JPanel p = new JPanel(new BorderLayout(5, 5));

        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        labels.add(new JLabel(s1, SwingConstants.RIGHT));
        labels.add(new JLabel(s2, SwingConstants.RIGHT));
        labels.add(new JLabel(s3, SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        controls.add(in1);
        controls.add(in2);
        controls.add(in3);
        p.add(controls, BorderLayout.CENTER);
        JOptionPane.showConfirmDialog(null, p, "Please Enter Movie Data", JOptionPane.OK_CANCEL_OPTION);
        ArrayList<JTextField> a = new ArrayList<JTextField>();
        a.add(in1);
        a.add(in2);
        a.add(in3);
        return a;
    }

  /*  public void findmovieorder() {
        for (int i = 0; i < movieslist.size(); i++) {
            Movie movie = movieslist.get(i);
            if (!movie.getdisplayed()) {
                ArrayList<Integer> endhours = movie.getendhours24();
                ArrayList<Integer> endminutes = movie.getendminutes24();
                movie.calculateend24();
                int leastendindex = findleastendhour(movie);
            
            }
        }
    }

    public int findleastendhour(Movie movie) {
        int least = 0;
        ArrayList<Integer> endhours = movie.getendhours24();
        ArrayList<Integer> endminutes = movie.getendminutes24();
        for (int m = 1; m < endhours.size(); m++) {
            if (endhours.get(m) < endhours.get(m - 1)) {
                least = m;
            } else if (endhours.get(m) == endhours.get(m - 1)) {
                if (endminutes.get(m) < endminutes.get(m - 1)) {
                    least = m;
                }
            }
        }
        return least;
    }

    /*
    public int findLeastMovie(ArrayList<Integer> arr) {
        int least = 0;
        for (int i = 1; i < movieslist.size(); i++) {
            Movie movie = movieslist.get(i);
            ArrayList<Integer> endhours = movie.getendhours24();
            if (endhours.get(arr.get(i)) < endhours.get(arr.get(i - 1))) {
                least = i;
            }
        }

        return least;
    }*/
  /*  public Movie findNext(Movie prev) {
        ArrayList<Integer> prevendhours = prev.getendhours24();
        int nextIndex = 0;
        int nextShow = 0;
        for (int i = 0; i < movieslist.size(); i++) {
            Movie movie = movieslist.get(i);
            if (!movie.getdisplayed()) {
                ArrayList<Integer> movBegHours = movie.getbeghours24();
                ArrayList<Integer> movBegMins = movie.getbegminutes();
                for (int m = 0; m < movie.getbeghours().size(); m++) {
                    for (int prevlp = 0; prevlp < prev.getendhours24().size(); prevlp++) {
                        //Find the closest beginning Hour of that movie to the previous one
                        //Compare beginning hours of those fitlered
                        if (prevendhours.get(prevlp) < movBegHours.get(m)) {//Filter
                            int least = 0;
                            if (m > 0) {
                                if (movBegHours.get(m) < movBegHours.get(m - 1)) {
                                    least = m;
                                } else if (movBegHours.get(m) == movBegHours.get(m - 1)) {
                                    if (movBegMins.get(m) < movBegMins.get(m - 1)) {
                                        least = m;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }*/

    public void displayScreenTime() {
        String out = " Movie            RunTime            Start Time            End Time";
        for (int i = 0; i < movieslist.size(); i++) {
            Movie movie = movieslist.get(i);
            movie.calculateend();
            ArrayList<Integer> endhours = movie.getendhours();
            ArrayList<Integer> endminutes = movie.getendminutes();
            ArrayList<Integer> beghours = movie.getbeghours();
            ArrayList<Integer> begminutes = movie.getbegminutes();
            out += "\n" + movie.getname() + "            " + movie.gethours() + ":" + movie.getminutes();
            for (int m = 0; m < beghours.size(); m++) {
                if (m == 0) {
                    out += "\n" + "                                                            " + beghours.get(m) + ":" + begminutes.get(m) + "                        " + endhours.get(m) + ":" + endminutes.get(m);
                } else {
                    out += "\n" + "                                                            " + beghours.get(m) + ":" + begminutes.get(m) + "                        " + endhours.get(m) + ":" + endminutes.get(m);
                }
            }
        }
        JOptionPane.showMessageDialog(null, out);
    }
}
