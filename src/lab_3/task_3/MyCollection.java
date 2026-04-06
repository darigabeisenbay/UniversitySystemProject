package lab_3.task_3;

public interface MyCollection<T> {
    void add(T element);
    void remove(T element);
    boolean contains(T element);
    boolean isEmpty();
    int size();
    void clear();
}

class NaturalNumbers implements MyCollection<Integer> {
    private int[] elements = new int[100];
    private int count = 0;

    @Override
    public void add(Integer num) {
        if (num > 0) {
            elements[count] = num;
            count++;
            System.out.println(num + " added");
        } else {
            System.out.println(num + " is not a natural number!");
        }
    }

    @Override
    public void remove(Integer num) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == num) {
                elements[i] = elements[count - 1];
                count--;
                System.out.println(num + " removed");
                return;
            }
        }
        System.out.println(num + " not found");
    }

    @Override
    public boolean contains(Integer num) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == num) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        count = 0;
        System.out.println("Collection cleared");
    }
}