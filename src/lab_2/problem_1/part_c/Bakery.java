package lab_2.problem_1.part_c;

import java.util.Objects;

public class Bakery extends Store{
    private String cakes;
    private String cookies;
    public Bakery(){

    }

    public Bakery(String name, String owner, String customer, String cakes, String cookies) {
        super(name, owner, customer);
        this.cakes = cakes;
        this.cookies = cookies;
    }

    public String getCakes() {
        return cakes;
    }

    public void setCakes(String cakes) {
        this.cakes = cakes;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bakery bakery = (Bakery) o;
        return Objects.equals(cakes, bakery.cakes) && Objects.equals(cookies, bakery.cookies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cakes, cookies);
    }

    @Override
    public String toString() {
        return "Bakery{" +
                "cakes='" + cakes + '\'' +
                ", cookies='" + cookies + '\'' +
                "} " + super.toString();
    }
}
