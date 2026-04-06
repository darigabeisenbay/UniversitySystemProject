package lab_1.problem_1_2;

enum FuelType{
    GASOLINE, ELECTRIC, DIESEL, HYBRID;
}

public class Car{
    public static int totalCarsProduced = 0;
    public static final String MANUFACTURER = "Toyota";
    private final String vin;
    private String model;
    private FuelType fuel;
    private int horsePower;
    {
        totalCarsProduced++;
        System.out.println("Preparing + 1 car ");
    }
    public Car(String vin){
        this(vin, "Base Model", FuelType.GASOLINE, 100);
    }

    public Car(String vin, String model, FuelType fuel, int horsePower){
        this.vin = vin;
        this.model = model;
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public void startEngine(){
        System.out.println("Engine started for " + this.model);
    }

    public void startEngine(int temperature){
        System.out.println("Engine pre-heating to " + temperature + " of Celcius");
    }
    public static int getTotalCarsProduced(){
        return totalCarsProduced;
    }

    public String getVin(){
        return vin;
    }

    public static void main(String[] args) {
        Car car1 = new Car("VIN987654");
        Car car2 = new Car("VIN111222", "SportX", FuelType.ELECTRIC, 500);

        car1.startEngine();
        car2.startEngine(-10);

        System.out.println("Manifacturer is " + Car.MANUFACTURER);
        System.out.println("Total cars: " + Car.getTotalCarsProduced());


    }

}