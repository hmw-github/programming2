package chapter3;

abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	abstract public void makeSound();
//	public void makeSound() {
//		throw new RuntimeException("implement this in subclass!");
//	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
    void bark() {
        System.out.printf("%s: Woof! Woof!\n", getName());
    }
	public void makeSound() {
		bark();
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
    void miau() {
        System.out.printf("%s: Miau!\n", getName());
    }
	public void makeSound() {
		miau();
	}
}

class Fish extends Animal {

	public Fish(String name) {
		super(name);
	}
	public void makeSound() {
        System.out.printf("%s: Blubb!\n", getName());
	}
}

public class AnimalSounds {
    private static void makeSound(Animal animal) {
    	if (animal instanceof Dog) {
    		Dog d = (Dog) animal;
    		d.bark();
    	} else if (animal instanceof Cat c) {
    		c.miau();
    	} else if (animal instanceof Fish f) {
    		f.makeSound();
    	}
    }
    
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Zoe"), new Cat("Tom"), new Fish("Nemo") };
        
        for (Animal animal : animals) {
            makeSound(animal);
            animal.makeSound();
        }
    }
}
