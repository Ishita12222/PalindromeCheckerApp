import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String text = "racecar";
        Stack<Character> stack = new Stack<>();

        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}