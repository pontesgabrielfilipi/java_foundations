package model;

import java.util.Random;

public class Pessoa {
    private String name;
    private Endereco address;
    private int age;
    private int registrationNumber;

    // Gets and Sets

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Endereco getAddress() {
        return address;
    }

    public void setAddress(Endereco adrress) {
        this.address = adrress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRegistrationNumber() {
        this.registrationNumber = this.generateRegistrationNumber();
        return this.registrationNumber;
    }

    public int generateRegistrationNumber() {
        Random rand = new Random();
        int RN = rand.nextInt(9999) + 1;
        return RN;
    }

    // Constructors

    public Pessoa() {
    }

    public Pessoa(String name, Endereco adrress, int age) {
        this.name = name;
        this.address = adrress;
        this.age = age;
        this.registrationNumber = this.generateRegistrationNumber();
    }

    // ToString

    @Override
    public String toString() {
        return "Pessoa [name=" + name + ", address=" + address + ", age=" + age + ", registrationNumber="
                + registrationNumber + "]";
    }
}
