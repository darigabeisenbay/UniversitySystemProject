package lab_3.task_6;

class Cat extends Animal {
    public Cat(String name, int age) { super(name, age); }

    @Override
    public String getSound() { return "Meow"; }
}

class Dog extends Animal {
    public Dog(String name, int age) { super(name, age); }

    @Override
    public String getSound() { return "Woof"; }
}

class Fish extends Animal {
    public Fish(String name, int age) { super(name, age); }

    @Override
    public String getSound() { return "...blub..."; }
}

class Bird extends Animal {
    public Bird(String name, int age) { super(name, age); }

    @Override
    public String getSound() { return "Tweet"; }
}