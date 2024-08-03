package assignment;

import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.print("1番目の数字を入力してください: ");
      double num1 = scanner.nextDouble();

      System.out.print("演算子を入力してください (+, -, *, /): ");
      String operator = scanner.next();

      System.out.print("2番目の数字を入力してください: ");
      double num2 = scanner.nextDouble();

      double result = 0;
      boolean validOperation = true;

      switch (operator) {
        case "+":
          result = num1 + num2;
          break;
        case "-":
          result = num1 - num2;
          break;
        case "*":
          result = num1 * num2;
          break;
        case "/":
          if (num2 != 0) {
            result = num1 / num2;
          } else {
            System.out.println("エラー: 0で割ることはできません。");
            validOperation = false;
          }
          break;
        default:
          System.out.println("エラー: 無効な演算子です。");
          validOperation = false;
          break;
      }

      if (validOperation) {
        System.out.println("計算結果: " + num1 + " " + operator + " " + num2 + " = " + result);
      }
    } catch (Exception e) {
      System.out.println("エラー: 入力が無効です。");
    } finally {
      scanner.close();
    }
  }
}

