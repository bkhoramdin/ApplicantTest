/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author Babak
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    
     public static boolean isPalindrome(String stringToTest) {
    String workingCopy = removeSpace(stringToTest);
    String reversedCopy = reverse(workingCopy);

    return reversedCopy.equalsIgnoreCase(workingCopy);
  }

  protected static String removeSpace(String string) {
    int i; 
    int len = string.length();
    StringBuffer word = new StringBuffer(len);
    char character;

    for (i = (len - 1); i >= 0; i--) {
      character = string.charAt(i);
      if (Character.isLetterOrDigit(character)) {
        word.append(character);
      }
    }

    return word.toString();
  }

  protected static String reverse(String string) {
    StringBuffer sb = new StringBuffer(string);

    return sb.reverse().toString();
  }
    public static void main(String[] args) {
      
   
     String string = "Amy, must I jujitsu my Ma?";

    System.out.println();
    System.out.println("Testing whether the following "
        + "string is a palindrome:");
    System.out.println("    " + string);
    System.out.println();

    if (isPalindrome(string)) {
      System.out.println("It is a palindrome");
    } else {
      System.out.println("It is not a palindrome");
    }
    System.out.println();
  }
    
    
    
    
}
