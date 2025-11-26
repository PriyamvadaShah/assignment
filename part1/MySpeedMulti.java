
import Speed.*;
import java.util.Scanner;

public class MySpeedMulti {
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

        Sort left = new Sort(ds, "selection");
        left.setStart(0);
        left.setEnd(mid - 1);

        Sort right = new Sort(ds, "selection");
        right.setStart(mid);
        right.setEnd(n - 1);

        RunTime rt = new RunTime();
        rt.startTimer();

        Thread t1 = new Thread(left);
        Thread t2 = new Thread(right);

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
