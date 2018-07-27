/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movietimes;

public class Run {
    public static void main (String[] args){
        MovieTimesCalculator obj = new MovieTimesCalculator();
        obj.moviePrompt();
        obj.displayScreenTime();
    }
}
