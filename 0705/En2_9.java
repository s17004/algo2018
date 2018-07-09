// 年内の経過日数を求める
import java.util.Scanner;
class En2_9 {
//--- 各月の日数 ---//
  static int[][] mdays = {
    {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},	// 平年
    {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},	// 閏年
  };

//--- 西暦year年は閏年か（閏年：1／平年：0） ---//
  static int isLeap(int year) {
    return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
  }

//--- 西暦y年m月d日の年内の残り日数を求める ---//
  static int leftDayOfYear(int y, int m, int d) {
    int remdars = mdays[isLeap(y)][m] - d;
    for(int i = 12; i>=m; i--){
      remdars += mdays[isLeap(y)][i-1];
    }
    return remdars;
  }
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int retry;					// もう一度？
    System.out.println("年内の経過日数を求めます。");
    do {
      System.out.print("年：");  int year  = stdIn.nextInt();	// 年
      System.out.print("月：");  int month = stdIn.nextInt();	// 月
      System.out.print("日：");  int day   = stdIn.nextInt();	// 日
      System.out.printf("年内の残りは%d日です。\n",
          leftDayOfYear(year, month, day));

      System.out.print("もう一度しますか（1…はい／0…いいえ）：");
      retry = stdIn.nextInt();
    } while (retry == 1);
  }
}
