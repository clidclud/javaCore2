package les5;

import org.checkerframework.checker.units.qual.A;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        writeToFile(writeZero(array));
        int[] arr = readFile("src/main/resources/test.txt");
        for (int val : arr) {
            System.out.println(val);
        }
    }

    public static void writeToFile(String arr) throws IOException {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/test.txt")) {
            fileWriter.write(arr);
        }
    }

    public static String writeZero(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append("0");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }

    public static int[] readFile(String path) throws IOException {
        ArrayList<Integer> array = new ArrayList<>();
        try (FileReader reader = new FileReader(path)) {
            int n;
            boolean flag = true;
            while ((n = reader.read()) != -1) {
                char temp = (char) n;
                if (temp == '0' && flag)
                    flag = false;
                else if (temp != '0' || (temp == '0' && !flag)) {
                    flag = true;
                    try {
                        array.add(Integer.parseInt(String.valueOf(temp)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        int[] result = new int[array.size()];
        int index = 0;
        for (Integer integer : array) {
            result[index++] = integer.intValue();
        }
        return result;
    }
}

