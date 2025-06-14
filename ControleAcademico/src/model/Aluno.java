package model;

public class Aluno {
    private String name;
    private String address;
    private int age;
    private int registrationNumber;

    // Cunstructors

    public Aluno(String name, String address, int age, int registrationNumber) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.registrationNumber = registrationNumber;
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

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    // Methods and Functions

    @Override
    public String toString() {
        return "Aluno [name=" + name + ", Address=" + address + ", age=" + age + ", registrationNumber="
                + registrationNumber + "]";
    }

    public void visualizar() {
        System.out.println("name=" + name + "\nAddress=" + address + "\nage=" + age + "\nregistrationNumber=" + registrationNumber); 

        /**
         * ou
         * System.out.println("name=" + name);
         * System.out.println("address=" + address);
         * System.out.println("age=" + age);
         * System.out.println("registrationNumber=" + registrationNumber);
         */
    }
}