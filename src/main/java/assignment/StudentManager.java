package assignment;

import java.util.*;

public class StudentManager {
  private static Map<String, Integer> studentScores = new HashMap<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学生の情報を表示");
      System.out.println("6. 終了");
      System.out.print("選択してください: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          addStudent(scanner);
          break;
        case 2:
          removeStudent(scanner);
          break;
        case 3:
          updateScore(scanner);
          break;
        case 4:
          calculateAverage();
          break;
        case 5:
          displayAllStudents();
          break;
        case 6:
          System.out.println("プログラムを終了します。");
          scanner.close();
          return;
        default:
          System.out.println("無効な選択です。");
          break;
      }
    }
  }

  private static void addStudent(Scanner scanner) {
    System.out.print("学生の名前を入力してください: ");
    String name = scanner.nextLine();
    System.out.print(name + "の点数を入力してください: ");
    int score = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    studentScores.put(name, score);
    System.out.println(name + "が追加されました。");
  }

  private static void removeStudent(Scanner scanner) {
    System.out.print("削除する学生の名前を入力してください: ");
    String name = scanner.nextLine();

    if (studentScores.remove(name) != null) {
      System.out.println(name + "が削除されました。");
    } else {
      System.out.println(name + "は存在しません。");
    }
  }

  private static void updateScore(Scanner scanner) {
    System.out.print("点数を更新する学生の名前を入力してください: ");
    String name = scanner.nextLine();

    if (studentScores.containsKey(name)) {
      System.out.print(name + "の新しい点数を入力してください: ");
      int score = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      studentScores.put(name, score);
      System.out.println(name + "の点数が更新されました。");
    } else {
      System.out.println(name + "は存在しません。");
    }
  }

  private static void calculateAverage() {
    if (studentScores.isEmpty()) {
      System.out.println("学生がいません。");
      return;
    }

    double total = 0;
    for (int score : studentScores.values()) {
      total += score;
    }
    double average = total / studentScores.size();
    System.out.println("平均点: " + average + "点");
  }

  private static void displayAllStudents() {
    if (studentScores.isEmpty()) {
      System.out.println("学生がいません。");
      return;
    }

    System.out.println("学生一覧:");
    for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue() + "点");
    }
  }
}

