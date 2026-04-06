package lab_2.problem_4;

public class Series extends Circuit {
    private Circuit circuit1;
    private Circuit circuit2;
    private double vTotal;

    public Series(Circuit c1, Circuit c2) {
        this.circuit1 = c1;
        this.circuit2 = c2;
    }

    @Override
    public double getResistance() {
        return circuit1.getResistance() + circuit2.getResistance();
    }

    @Override
    public double getPotentialDiff() {
        return vTotal;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.vTotal = V;
        double current = V / getResistance();
        // V = I * R for each sub-circuit
        circuit1.applyPotentialDiff(current * circuit1.getResistance());
        circuit2.applyPotentialDiff(current * circuit2.getResistance());
    }
}