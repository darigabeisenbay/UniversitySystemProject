package lab_2.problem_1.part_a;

import java.util.Objects;

public class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return (4/3)*Math.PI*Math.pow(radius,3.0);
    }

    @Override
    public double surfaceArea() {
        return 4*Math.PI*Math.pow(radius,2.0);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                "} ";
    }
}
