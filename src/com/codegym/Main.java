package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file input: ");
        String fileName = scanner.nextLine();

        final String OUTPUT_FILENAME = "result.txt";

        try {
            ArrayList<Integer> integers = integersInFile(fileName);
            int max = maxInList(integers);
            writeToFile(OUTPUT_FILENAME, "Số nguyên lớn nhất là: ", max);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static ArrayList<Integer> integersInFile(String fileName) throws IOException {
        ArrayList<Integer> integers = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            try {
                int number = Integer.parseInt(line.trim());
//                System.out.println(number);
                integers.add(number);
            } catch (NumberFormatException e) {
                // do nothing
            }
        }
        bufferedReader.close();
        fileReader.close();
        return integers;
    }

    public static int maxInList(ArrayList<Integer> integers) {
        if (integers.size() == 0)
            return 0;
        int max = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if (max < integers.get(i))
                max = integers.get(i);
        }
        return max;
    }
    public static void writeToFile(String fileName, String msg, int value) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(msg + value);

        bufferedWriter.close();
        fileWriter.close();
    }
}
