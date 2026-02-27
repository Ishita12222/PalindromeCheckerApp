// File: PalindromeCheckerApp.java
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("Racecar");
        if (checker.checkPalindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}

// Non-public class in same file
class PalindromeChecker {

    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean checkPalindrome() {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}