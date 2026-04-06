package lab_2.problem_1.part_c;

import java.util.Objects;

public class Store {
    private String name;
    private String owner;
    private String customer;

    public Store() {
    }

    public Store(String name, String owner, String customer) {
        this.name = name;
        this.owner = owner;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name) && Objects.equals(owner, store.owner) && Objects.equals(customer, store.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner, customer);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
