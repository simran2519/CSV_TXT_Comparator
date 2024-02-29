package Weekly_Assignment.FileComparator2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("choose file type");
        System.out.println("0.exit");
        System.out.println("1. Text");
        System.out.println("2. CSV ");
        int filetype = sc.nextInt();
        sc.nextLine();
        if (filetype == 0) {
            return;
        }
        switch (filetype) {
            case 1: {
                compareTextFiles(sc);
                break;
            }
            case 2: {

                compareCSVFiles(sc);
                break;
            }
            default: {
                System.out.println("Invalid choice");
                break;
            }
        }
    }
    private static void compareTextFiles(Scanner sc) {
        System.out.println("Enter the location of file1:");
        String file1 = sc.nextLine();
        System.out.println("Enter the location of file2:");
        String file2 = sc.nextLine();

        TxtFileComparator comparator = new TxtFileComparator();
        try {
            boolean areEqual = comparator.comparefiles(file1, file2);
            if (areEqual) {
                System.out.println("Files are equal.");
            } else {
                System.out.println("Files are different and difference is written in outputFile1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void compareCSVFiles(Scanner sc) throws IOException {
        System.out.println("Enter the location of file1:");
        String file1 = sc.nextLine();
        System.out.println("Enter the location of file2:");
        String file2 = sc.nextLine();

        CSVFileComparator comparator = new CSVFileComparator();

        if (comparator.compareFiles(file1, file2)) {
            System.out.println("Files are same");
        } else {
            System.out.println("Files are different and their difference is written in ouputFile1 ");
        }
    }
}