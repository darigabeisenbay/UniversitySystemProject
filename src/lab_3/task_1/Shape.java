package lab_3.task_1;
// We use abstract classes when we have the same logic for all extended classes
public abstract class Shape {
    int a;
    String color;
    Shape(String color, int a) {
        this.color = color;
        this.a = a;
    }
    public String showColor(){
      return this.color;       // don't need to override it
    }
    public abstract double perimeter();  // need to add its own way to calculate perimeter
    public abstract double area();       // need to add its own way to calculate area

}
class Square extends Shape{
    Square(String color, int a){
        super(color, a);
    }
    @Override
    public double perimeter(){
        return 4*a;
    }
    @Override
    public double area(){
        return Math.pow(a,2);
    }
}

