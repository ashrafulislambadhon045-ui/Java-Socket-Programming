import java.io.*;
import java.net.*;
import java.util.*;

public class StudentServer {
    public static void main(String[] args) {
        HashMap<Integer, Integer[]> marksMap = new HashMap<>();
        String[] names = new String[10]; // Array for names

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            StudentData data = (StudentData) ois.readObject();

            Integer[] marksBoxed = new Integer[data.marks.length];
            for (int i = 0; i < data.marks.length; i++) {
                marksBoxed[i] = data.marks[i];
            }
            marksMap.put(data.id, marksBoxed);
            names[0] = data.name;

            // Display
            System.out.println("\nReceived Student:");
            System.out.println("ID: " + data.id + ", Name: " + data.name);
            System.out.print("Marks: ");
            for (int m : data.marks) System.out.print(m + " ");
            System.out.println();

            ois.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
