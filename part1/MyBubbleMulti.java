import Speed.*;
import java.util.Scanner;

public class MyBubbleMulti {

    public static void bubbleSort(double[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = start; j < end - (i - start); j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("+++++++++++++++++++Welcome to Parallel Processing Environment++++++++++++++++++++");

        System.out.println("Enter size of array");
        int n = sc.nextInt();

        System.out.println("Enter middle position of array");
        int mid = sc.nextInt();

        System.out.println("Enter upper bound and lower bound (limit) of random numbers entered in the array");
        int lower = sc.nextInt();
        int upper = sc.nextInt();

        DataStructure ds = new DataStructure();
        ds.setSize(n);
        ds.initArrayRandom(lower, upper, n);

        double[] arr = ds.getArray();

        RunTime rt = new RunTime();
        rt.startTimer();

        Thread t1 = new Thread(() -> bubbleSort(arr, 0, mid - 1));
        Thread t2 = new Thread(() -> bubbleSort(arr, mid, n - 1));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        Sort merger = new Sort(ds, "merge");
        merger.setStart(0);
        merger.setMid(mid - 1);
        merger.setEnd(n - 1);
        merger.merge();

        rt.stopTimer();
    }
}
