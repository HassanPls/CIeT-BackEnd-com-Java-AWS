package poo.interfaces_e_lambda.Aula3.keyword;

public class Client {
    private static String staticName;
    protected String name;
    protected int age;
    protected Address address = new Address();

    public String getName() {
        System.out.println(address.description);
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public static String getStaticName() {
        return staticName;
    }
    public static void setStaticName(String staticName) {
        Client.staticName = staticName;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

}
