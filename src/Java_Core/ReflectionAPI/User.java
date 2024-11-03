package Java_Core.ReflectionAPI;

import java.time.LocalDate;

public class User extends Person implements Comparable{

    private String ligin;

    private LocalDate lastLoginDate;

    private boolean isActive;

    private String pwd = "secret_password";

    public User(String name, int age){
        super(name,age);
    }
@Deprecated()
    public synchronized void purchase(){
        System.out.println("Купил");
    }

    public String getLigin() {
        return ligin;
    }

    public void setLigin(String ligin) {
        this.ligin = ligin;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
