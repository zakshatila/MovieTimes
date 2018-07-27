package movietimes;

import java.util.ArrayList;

public class Movie {

    private String name;
    private int hours;
    private int minutes;
    //private boolean displayed =false;
    private ArrayList<Integer> morningShow= new ArrayList<Integer>();;
    private ArrayList<Integer> beghours = new ArrayList<Integer>();
    //private ArrayList<Integer> beghours24 = new ArrayList<Integer>();
    private ArrayList<Integer> begminutes = new ArrayList<Integer>();
    private ArrayList<Integer> endhours = new ArrayList<Integer>();
    //private ArrayList<Integer> endhours24 = new ArrayList<Integer>();
    //private ArrayList<Integer> endminutes24 = new ArrayList<Integer>();
    private ArrayList<Integer> endminutes = new ArrayList<Integer>();

    public Movie(String nam, int hour, int minute, ArrayList beghour, ArrayList begminute) {
        name = nam;
        hours = hour;
        minutes = minute;
        beghours = beghour;
        begminutes = begminute;
        //morningShow = morningshow;
    }

    public int gethours() {
        return hours;
    }

    public String getname() {
        return name;
    }

    public int getminutes() {
        return minutes;
    }
    /*public boolean getdisplayed(){
        return displayed;
    }
    public void setdisplayed(boolean set){
        displayed = set;
    }
    */
    /////moviecalculations()
    public void calculateend() {
        for (int i = 0; i < beghours.size(); i++) {
            int temphour = beghours.get(i) + hours;
            int tempmin = begminutes.get(i) + minutes;
            if (tempmin >= 60) {
                temphour = 1 + temphour;
                tempmin = tempmin - 60;
            }
            if (temphour > 12) {
                temphour = temphour - 12;
            }
            endhours.add(temphour);
            endminutes.add(tempmin);
        }
    }

    public ArrayList getendhours() {
        return endhours;
    }

    public ArrayList getendminutes() {
        return endminutes;
    }

    public ArrayList getbeghours() {
        return beghours;
    }

    public ArrayList getbegminutes() {
        return begminutes;
    }

    /*public ArrayList getMorningShowValidity() {
        return morningShow;
    }
*/
    //24 hour Format
    /*
    public ArrayList getbeghours24() {
        return beghours24;
    }

    public void calculatebeg24() {
        for (int i = 0; i < beghours.size(); i++) {
            if(morningShow.get(i)==0){
                int temp= beghours.get(i)+12;
                beghours24.add(temp);
            }
        }
    }

    public ArrayList getendhours24() {
        return endhours24;
    }

    public ArrayList getendminutes24() {
        return endminutes24;
    }

    public void calculateend24() {
        for (int i = 0; i < beghours.size(); i++) {
            int temphour = beghours.get(i) + hours;
            int tempmin = begminutes.get(i) + minutes;
            if (tempmin >= 60) {
                temphour = 1 + temphour;
                tempmin = tempmin - 60;
            }
            if (morningShow.get(i)==0) {
                temphour = temphour + 12;
            }
            endhours24.add(temphour);
            endminutes24.add(tempmin);
        }
    }*/
    
}
