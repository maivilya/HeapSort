import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        // Консольный вариант
        int[] arr = fill(getLengthTerminal(), getMinValueTerminal(), getMaxValueTerminal());
        System.out.print("Unsorted array -> ");
        print(arr);
        heapSort(arr);
        System.out.print("Sorted array -> ");
        print(arr);
        System.out.println();

        // Вариант с файлом
        final String FILENAME = "src/input.txt";
        List<String> tempData = getDataFile(FILENAME);
        int[] unsortedArray = toArray(tempData);
        System.out.print("Unsorted array -> ");
        print(unsortedArray);
        heapSort(unsortedArray);
        System.out.print("Sorted array -> ");
        print(unsortedArray);
    }
    private static int convertToInt(String s){
        try{
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            return 0;
        }
    }
    private static int[] toArray(List<String> l){
        int length = l.size();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = convertToInt(l.get(i));
        }
        return array;
    }
    private static boolean isDigit(char c){
        try{
            String s = String.valueOf(c);
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    private static List<String> getDataFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> listOfStrings = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            listOfStrings.add(line);
        }
        return listOfStrings;
    }

    private static void heapSort(int[] array){
        int length = array.length;

        for (int i = length / 2 - 1; i >=0 ; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >=0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    private static void print(int[] arr) {
        int length = arr.length;
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
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
