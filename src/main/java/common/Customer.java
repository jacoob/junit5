package common;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */
public class Customer {
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean contain(String name){
        return this.name.equals(name);
    }

    public RuntimeException getException(){
        throw new MyException("My Exception. please be polite!");
    }
}
