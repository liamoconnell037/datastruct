import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact> {
    private String name;
    private String phoneNumber;
    private int age;
    private String email;
    public static final long serialVersionUID = -2338626292552177485L;
    public Contact() {
        this.name = "";
        this.phoneNumber = "";
        this.age = -1;
        this.email = "-1";
    }
    public Contact(String name, String phoneNumber) 
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber, int age, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }
}
