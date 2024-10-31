package Java_Core.Collections.FinalChallenge;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class User implements Comparator<User> {
    private String login;
    private String password;
    private LocalDate createdDate;

    public User(String login, String password, LocalDate createdDate) {
        this.login = login;
        this.password = password;
        this.createdDate = createdDate;
    }

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int compare(User o1, User o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getCreatedDate(), user.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getCreatedDate());
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
