public class PersonModel {
    private String name;
    private int age;

    public PersonModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void rename(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void birthday() {
        age++;
    }
}
