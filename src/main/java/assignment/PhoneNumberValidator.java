package assignment;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("携帯電話番号を入力してください: ");
    String phoneNumber = scanner.nextLine();

    if (isValidPhoneNumber(phoneNumber)) {
      System.out.println(phoneNumber + " は有効な携帯電話番号です。");
    } else {
      System.out.println(phoneNumber + " は無効な携帯電話番号です。");
    }

    scanner.close();
  }

  private static boolean isValidPhoneNumber(String phoneNumber) {
    String regex = "^0[789]0-\\d{4}-\\d{4}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNumber);
    return matcher.matches();
  }
}

