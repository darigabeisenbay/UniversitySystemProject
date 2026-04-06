package lab_2.problem_1.part_a;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Shape3D> shapes = new ArrayList<>();
        Cube cube = new Cube(3.0);
        Sphere sphere = new Sphere(3.0);
        Cylinder cylinder = new Cylinder(3.0, 2.0);

        shapes.add(cube);
        shapes.add(sphere);
        shapes.add(cylinder);
        for(Shape3D s : shapes){
            System.out.println( "Surface area of " + s + " " + s.surfaceArea());
            System.out.println("Volume of " + s + " " +s.volume());
            System.out.println();

        }
    }
}
