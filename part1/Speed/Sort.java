package Speed;

public class Sort implements Runnable {

    private DataStructure ds;
    private int start, end, mid;
    private String algo;

    public Sort(DataStructure ds, String algo) {
        this.ds = ds;
        this.algo = algo.toLowerCase();
        this.start = 0;
        this.end = ds.getSize() - 1;
        this.mid = (start + end) / 2;
    }

    public void setStart(int s) { this.start = s; }
    public void setEnd(int e) { this.end = e; }
    public void setMid(int m) { this.mid = m; }

    public int getStart() { return start; }
    public int getEnd() { return end; }

    public void selectionSort() {
        double[] a = ds.getArray();
        for (int i = start; i <= end; i++) {
            int minPos = i;
            for (int j = i + 1; j <= end; j++) {
                if (a[j] < a[minPos]) minPos = j;
            }
            double t = a[i];
            a[i] = a[minPos];
            a[minPos] = t;
        }
    }

    public int findMinPos(int s, int e) {
        double[] a = ds.getArray();
        int minPos = s;
        for (int i = s + 1; i <= e; i++) {
            if (a[i] < a[minPos]) minPos = i;
        }
        return minPos;
    }

    public void merge() {
        double[] a = ds.getArray();
        int n1 = mid - start + 1;
        int n2 = end - mid;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; i++) L[i] = a[start + i];
        for (int j = 0; j < n2; j++) R[j] = a[mid + 1 + j];

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
        }

        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    @Override
    public void run() {
        if (algo.equals("selection"))
            selectionSort();
        else
            selectionSort(); 
    }
}
