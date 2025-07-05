package model;

import java.util.Random;

public class Aluno {
    private String name;
    private String address;
    private int age;
    private int registrationNumber;

    // Cunstructors

    public Aluno(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.registrationNumber = this.generateRegistrationNumber();
    }

    public Aluno() {
    }

    // Gets and Sets

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public int generateRegistrationNumber() {
        Random rand = new Random();
        int RN = rand.nextInt(9999) + 1;
        return RN;
    }

    // Methods and Functions

    @Override
    public String toString() {
        return "Aluno [name=" + name + ", Address=" + address + ", age=" + age + ", registrationNumber="
                + registrationNumber + "]";
    }

    public void visualizar() {
        System.out.println("name=" + name + "\nAddress=" + address + "\nage=" + age + "\nregistrationNumber="
                + registrationNumber);

        /**
         * ou
         * System.out.println("name=" + name);
         * System.out.println("address=" + address);
         * System.out.println("age=" + age);
         * System.out.println("registrationNumber=" + registrationNumber);
         */
    }
}