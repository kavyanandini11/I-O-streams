import java.io.*;
import java.util.Scanner;

public class CharacterCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter the character to be counted: ");
        char ch = Character.toLowerCase(sc.next().charAt(0));

        int count = 0;

        try {

            FileReader fr = new FileReader(fileName);

            int data;

            while ((data = fr.read()) != -1) {

                char fileChar = Character.toLowerCase((char) data);

                if (fileChar == ch) {
                    count++;
                }
            }

            fr.close();

            System.out.println("File '" + fileName + "' has " + count +
                    " instances of letter '" + ch + "'.");

        }

        catch (IOException e) {
            System.out.println("File not found.");
        }

        sc.close();
    }
}