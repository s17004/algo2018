import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class En3_7 {
  static class PhyscData {
    private String name;
    private int    height;
    private double vision;
    public PhyscData(String name, int height, double vision) {
      this.name = name;  this.height = height;  this.vision = vision;
    }
    public String toString() {
      return name + " " + height + " " + vision;
    }
    public static final Comparator<PhyscData> VISION_ORDER =
      new VisionOrderComparator();
    private static class VisionOrderComparator
        implements Comparator<PhyscData> {
        public int compare(PhyscData d1, PhyscData d2) {
          return (d1.vision > d2.vision) ?  1 :
            (d1.vision < d2.vision) ? -1 : 0;
        }
    }
  }
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    PhyscData[] x = {
      new PhyscData("赤坂忠雄", 162, 0.3),
      new PhyscData("長浜良一", 168, 0.4),
      new PhyscData("松富明雄", 169, 0.8),
      new PhyscData("武田信也", 171, 1.5),
      new PhyscData("加藤富明", 173, 0.7),
      new PhyscData("浜田哲明", 174, 1.2),
      new PhyscData("斉藤正二", 175, 2.0),
    };
    System.out.print("探す視力は：");
    double vision = stdIn.nextDouble();
    int idx = Arrays.binarySearch(
        x,
        new PhyscData("", 0, vision),
        PhyscData.VISION_ORDER
        );

    if (idx < 0)
      System.out.println("その値の要素は存在しません。");
    else {
      System.out.println("その値は"+"x["+ idx + "]にあります。");
      System.out.println("データ：" + x[idx]);
    }
  }
}
