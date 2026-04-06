package lab_2.problem_4;

public class TestProgram {
    public static void main(String[] args) {
        // 1. Create individual Resistors
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b); 

        Circuit g = new Parallel(c, d); 

        Circuit h = new Series(g, e); 

        Circuit circuit = new Parallel(h, f);

        double mainVoltage = 12.0;
        circuit.applyPotentialDiff(mainVoltage);

        System.out.println("--- Circuit Analysis ---");
        System.out.printf("Total Equivalent Resistance: %.2f Ohms\n", circuit.getResistance());
        System.out.printf("Total Current (I):           %.2f Amps\n", circuit.getCurrent());
        System.out.printf("Total Power Dissipated:      %.2f Watts\n", circuit.getPower());

        System.out.printf("Resistor 'a' (3.0 Ohm) Voltage: %.2f V\n", a.getPotentialDiff());
        System.out.printf("Resistor 'c' (6.0 Ohm) Voltage: %.2f V\n", c.getPotentialDiff());
    }
}