package lab_2.problem_4;

public class Parallel extends Circuit {
    private Circuit circuit1;
    private Circuit circuit2;
    private double vTotal;

    public Parallel(Circuit c1, Circuit c2) {
        this.circuit1 = c1;
        this.circuit2 = c2;
    }

    @Override
    public double getResistance() {
        double r1 = circuit1.getResistance();
        double r2 = circuit2.getResistance();
        return (r1 * r2) / (r1 + r2);
    }

    @Override
    public double getPotentialDiff() {
        return vTotal;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.vTotal = V;
        // In parallel, voltage is the same for all branches
        circuit1.applyPotentialDiff(V);
        circuit2.applyPotentialDiff(V);
    }
}