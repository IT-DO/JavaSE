package Java_Core.ReflectionAPI;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user = new User("Anton", 34);
        Class<User> userClass = User.class; // создаем переменную userClass дял исследования объекта класса User через ReflectionAPI
        System.out.println(userClass.getSuperclass());

        Class<? extends User> userClassObject = user.getClass();
        System.out.println(userClassObject.equals(userClass));

        Field field = userClass.getDeclaredField("pwd"); // создаем объект для работы с полями объекта класса User
        field.setAccessible(true);
        System.out.println(field.get(user));

        field.set(user, "public_pwd"); // изменяет private поле объекта класса user

        System.out.println(user.getPwd());  // получаем измененнный пароль объекта класса user

        Method method = userClass.getDeclaredMethod("purchase"); // создаем переменную для исслеждования метода "purchase" в объекте классе User

        System.out.println(method.getName());
        System.out.println(method.getReturnType());
        System.out.println(Arrays.toString(method.getDeclaredAnnotations()));
        int modifier = method.getModifiers(); // создаем переменную для исследования модификаторов метода
        System.out.println("Метод public: " + Modifier.isPublic(modifier));
        System.out.println("Метод static: " + Modifier.isStatic(modifier));
        System.out.println("Метод synchronized: " + Modifier.isSynchronized(modifier));
        method.invoke(user); // вызов исследуемого метода
    }
}
