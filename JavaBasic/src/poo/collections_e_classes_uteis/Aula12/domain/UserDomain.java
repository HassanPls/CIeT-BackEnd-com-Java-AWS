package poo.collections_e_classes_uteis.Aula12.domain;

public class UserDomain extends GenericDomain<Integer>{
    private String name;
    private int age;
    
    public UserDomain(Integer id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }
    public UserDomain(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public UserDomain() {}
    public String getName() {
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDomain other = (UserDomain) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "UserDomain [name=" + this.getName() + ", age=" + this.getAge() + "]";
    }
    
    
}
