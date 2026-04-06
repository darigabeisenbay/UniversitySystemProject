package lab_1.problem_1_2;

import java.util.Scanner;
public class Data{
    private double sum;
    private double maxi;
    private int count;

    public Data(){
        sum = 0;
        maxi = -Double.MAX_VALUE;
        count = 0;
    }
    public void add(double value){
        sum += value;
        if (count == 0 || value > maxi){
            maxi = value;
        }
        count++;
    }
    public double getAvg (){
        if (count == 0) return 0;
        return sum / count;
    }
    public double getMaxi(){
        if(count == 0) return 0;
        return maxi;
    }
}
class   Analyzer{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Data dataset = new Data();

        while(true){
            System.out.println("Enter a number or Q to quit: ");
            String input = sc.next();
            if(input.equalsIgnoreCase("Q") ){
                break;
            }
            try{
                double value = Double.parseDouble(input);
                dataset.add(value);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input, please enter a number or a letter: ");
            }
        }
        System.out.println("Average is " + dataset.getAvg());
        System.out.println("Maximum is " + dataset.getMaxi());
    }

}
