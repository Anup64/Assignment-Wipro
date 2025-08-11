import java.util.Scanner;
class StringUtility {

    public int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public int countConsonants(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch) && "aeiou".indexOf(ch) == -1) {
                count++;
            }
        }
        return count;
    }

    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public String replaceWord(String str, String oldWord, String newWord) {
        return str.replace(oldWord, newWord);
    }
}

public class Assignment2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringUtility util = new StringUtility();

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char repeat;

        do {
            System.out.println("\n********** MENU **********");
            System.out.println("1. Count Vowels");
            System.out.println("2. Count Consonants");
            System.out.println("3. Check Palindrome");
            System.out.println("4. Reverse String");
            System.out.println("5. Convert to Uppercase");
            System.out.println("6. Convert to Lowercase");
            System.out.println("7. Replace a Word");
            System.out.println("8. Exit");
            System.out.println("***************************");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Number of vowels: " + util.countVowels(str));
                    break;

                case 2:
                    System.out.println("Number of consonants: " + util.countConsonants(str));
                    break;

                case 3:
                    if (util.isPalindrome(str)) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                    break;

                case 4:
                    System.out.println("Reversed string: " + util.reverseString(str));
                    break;

                case 5:
                    System.out.println("Uppercase: " + util.toUpperCase(str));
                    break;

                case 6:
                    System.out.println("Lowercase: " + util.toLowerCase(str));
                    break;

                case 7:
                    System.out.print("Enter the word to replace: ");
                    String oldWord = sc.nextLine();
                    System.out.print("Enter the new word: ");
                    String newWord = sc.nextLine();
                    str = util.replaceWord(str, oldWord, newWord);
                    System.out.println("Updated string: " + str);
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.print("\nBack to Menu? (Y/N): ");
            repeat = sc.next().charAt(0);
            sc.nextLine(); // consume leftover newline

        } while (repeat == 'Y' || repeat == 'y');

        sc.close();
        System.out.println("Program terminated.");
    }
}


