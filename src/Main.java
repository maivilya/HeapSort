import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = fill(getLengthTerminal(), getMinValueTerminal(), getMaxValueTerminal());
        print(arr);

    }

    private static void print(int[] arr) {
        int length = arr.length;
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i] + "]");
            }
        }
    }


    private static int[] fill(int len, int min, int max) {
        int[] array = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
        return array;
    }

    private static int getLengthTerminal(){
        System.out.print("Enter length of the array: ");
        return scanner.nextInt();
    }
    private static int getMinValueTerminal(){
        System.out.print("Enter min value of the array: ");
        return scanner.nextInt();
    }
    private static int getMaxValueTerminal(){
        System.out.print("Enter max value of the array: ");
        return scanner.nextInt();
    }
}














