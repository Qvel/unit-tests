package entity;

import java.io.Serializable;
import java.util.Objects;

public class Human implements Serializable {


    public Human() {
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                Objects.equals(getName(), human.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Human{" + "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
