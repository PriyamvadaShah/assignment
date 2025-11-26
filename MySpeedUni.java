import Speed.*;
import java.util.Scanner;

public class MySpeedUni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("+++++++++++++++++++Welcome to Uni-Processing Environment++++++++++++++++++++");

        System.out.println("Enter size of array");
        int n = sc.nextInt();

        System.out.println("Enter upper bound and lower bound (limit) of random numbers entered in the array");
        int lower = sc.nextInt();
        int upper = sc.nextInt();

        DataStructure ds = new DataStructure();
        ds.setSize(n);
        ds.initArrayRandom(lower, upper, n);

        RunTime rt = new RunTime();
        rt.startTimer();

        Sort s = new Sort(ds, "selection");
        s.setStart(0);
        s.setEnd(n - 1);
        s.selectionSort();

        rt.stopTimer();
    }
}
