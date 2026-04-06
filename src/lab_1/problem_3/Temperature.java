package lab_1.problem_3;

public class Temperature{
    private double  value;
    private char scale;

    public Temperature(){
        this.value = 0.0;
        this.scale ='C';
    }
    public Temperature(double value){
        this.value = value;
        this.scale = 'C';
    }

    public Temperature(char scale){
        this.value = 0.0;
        this.scale = scale;
    }

    public Temperature(double value, char scale){
        this.value = value;
        this.scale = scale;
    }
    public char getScale(){
        return scale;
    }
    public double getCelcius(){
        if (scale == 'C'){
            return value;
        }else{
            return 5 * (value - 32) / 9;
        }
    }
    public double getFarenheit(){
        if (scale == 'F'){
            return value;
        }else{
            return (9 * value / 5) + 32;
        }
    }
    public void setValue(double value){
        this.value = value;
    }
    public void setScale(char scale){
        this.scale = scale;
    }
    public void setTemperature (double value, char scale){
        this.value = value;
        this.scale = scale;
    }

    public static void main(String[] args) {
        Temperature temp = new Temperature(36.6, 'C');

        System.out.println("Celcius: " + temp.getCelcius());
        System.out.println("Farenheit: " + temp.getFarenheit());

        temp.setTemperature(100, 'F');

        System.out.println("try again, data were updated");
        System.out.println("Celcius: " + temp.getCelcius());
        System.out.println("Farenheit: " + temp.getFarenheit());

    }
}