package Java_Core.InputOutputTests;

import java.io.*;
import java.util.Objects;

//static и trancient поля не участвуют в сериализации
public class SerializationEx {
    public static void main(String[] args) {
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/user.dat"))) {
                User user = new User("Anton K");
                oos.writeObject(user);
            }
            System.out.println("Object user was Serialized Succesfully!");

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res/user.dat"))) {
                User user2 = ((User) ois.readObject());
                System.out.println("Object user was Deserialized Succesfully!");
                System.out.println("User2 name " + user2.getName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

class User implements Serializable {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
