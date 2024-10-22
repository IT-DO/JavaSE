import java.util.*;

public class PalindromeDetector {
    public static void main(String[] args) {

        System.out.println("Введите слово для проверки на палиндром: ");
        Scanner scanner = new Scanner(System.in);
        String enter = scanner.nextLine();

        LinkedList<Character> list = new LinkedList<>();
        for (char ch : enter.toCharArray()) {
            list.add(ch);//
        }

        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> iteratorReverse = list.listIterator(list.size());

        boolean isPalindrome = true;
        while (iterator.hasNext() && iteratorReverse.hasPrevious()) {
            if (!iterator.next().equals(iteratorReverse.previous())) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Палиндром найден!!!!");
        } else {
            System.out.println("ЭТО НЕ ПАЛИНДРОМ...");
        }
    }
}

