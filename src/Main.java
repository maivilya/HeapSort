import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = fill(14, 1, 70);

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
}














