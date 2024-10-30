package Java_Core.Collections;

import java.util.Stack;

public class StackEx2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("Anton");
        stack.add("Victor");
        stack.add("Vanya");
        stack.add("Igor");
        stack.add("Gera");
        System.out.println(stack);

        //вставка элемента происходит в самый конец с помощью метода .push()
        stack.push("Aleksei");
        stack.push("Kola");
        stack.push("Gera");
        System.out.println(stack);


        System.out.println("Stack peek is: " + stack.peek());
        System.out.println();

        //удаление элемента с самого конца происходит с помощью метода .pop()
        //сначала возвращает элемент, затем удаляет
        while (!stack.isEmpty()) {
            System.out.println(
                    "Popping element: " +
                            '"' + stack.pop() +
                            '"');

            System.out.println(stack);
        }
        System.out.println("Stack is EMPTY!");
    }
}
