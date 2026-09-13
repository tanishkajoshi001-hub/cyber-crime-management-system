public class Person {

    protected String name;
    protected String phone;
    protected String email;

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void showDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
    }
}
