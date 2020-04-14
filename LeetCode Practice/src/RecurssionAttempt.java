public class RecurssionAttempt {
    public static void reverseString(char[] s) {
        helper(0, s, s.length);
    }
    private static void helper(int index, char [] str, int index2) {
        if (str == null || index >= str.length) {
            return;
        }
        System.out.print(str[index2-1]);
        helper(index + 1, str, index2 - 1);
    }

    public static void main(String[] args) {
        char[] s2 = {'H','e','l','l','o'};
        reverseString(s2);
    }
}

