package org.webonise.listapp;

/**
 * Created by webonise on 15/9/16.
 */
public class Users {
    private int id=0;
    private String firstName="";
    private String lastName="";
    private String email="";
    private int age=-1;

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    private int salary=0;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void showDetails(){
        System.out.print(id+"\t"+firstName+"\t"+lastName+"\t");
        System.out.println(age+"\t"+email+"\t"+salary);
    }
}
