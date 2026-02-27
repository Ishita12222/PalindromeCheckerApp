public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String text = "A man a plan a canal Panama";
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}