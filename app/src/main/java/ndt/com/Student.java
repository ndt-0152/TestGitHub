package ndt.com;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private int age;
    private float point;
    private List<String> hobbies;

    public Student(String name, int age, float point, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.point = point;
        this.hobbies = hobbies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", point=" + point +
                ", hobbies=" + hobbies +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getPoint() {
        return point;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}
