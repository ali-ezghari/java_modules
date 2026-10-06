
package ex01;

import java.util.Scanner;

public class Program {

    static int steps = 0;

    public static boolean isPrimeNumber(int num) {
        int i = 3;

        if (num == 2) {
            steps++;
            return true;
        } else if (num % 2 == 0) {
            steps++;
            return false;
        }

        while (i * i <= num) {
            steps++;
            if (num % i == 0)
                return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Print a number");
        int num = scanner.nextInt();

        if (num < 2) {
            System.err.println("IllegalArgument");
            scanner.close();
            System.exit(-1);
        }

        if (isPrimeNumber(num))
            System.out.println("true - " + steps);
        else
            System.out.println("false - " + steps);

        scanner.close();

    }
}