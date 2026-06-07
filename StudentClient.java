import java.io.*;
import java.net.*;
import java.util.*;

public class StudentClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            System.out.println("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            System.out.println("Enter 3 marks: ");
            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) marks[i] = sc.nextInt();

            StudentData data = new StudentData();
            data.id = id;
            data.name = name;
            data.marks = marks;

            oos.writeObject(data);
            System.out.println("Data sent to server!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
