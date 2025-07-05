package model;

import java.util.Random;

public class Professor {
    private String name;
    private String address;
    private int age;
    private int registrationNumber;
    private String CPF;
    private String acting;

    // Constructors

    public Professor() {
    }

    public Professor(String name, String address, int age, String cPF, String acting) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.registrationNumber = this.generateRegistrationNumber();
        CPF = cPF;
        this.acting = acting;
    }

    // To String Method

    @Override
    public String toString() {
        return "Professor [name=" + name + ", address=" + address + ", age=" + age + ", registrationNumber="
                + registrationNumber + ", CPF=" + CPF + ", acting=" + acting + "]";
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getActing() {
        return acting;
    }

    public void setActing(String acting) {
        this.acting = acting;
    }
}
