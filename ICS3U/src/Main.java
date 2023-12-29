import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    static double findNthFibonacci(int n) {
    	if (n == 1) return 1;
        double phi = (1 + Math.sqrt(5)) / 2.0;
        double phi2 = (1 - Math.sqrt(5)) / 2.0;
        return (Math.pow(phi, n) + Math.pow(phi2, n)) / Math.sqrt(5);
    }

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int N = 10;
        double result = findNthFibonacci(N);
        System.out.println(result);
    }
}