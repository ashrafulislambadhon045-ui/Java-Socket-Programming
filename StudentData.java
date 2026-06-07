import java.io.Serializable;

// Serializable class for data transfer between Client and Server
public class StudentData implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    int[] marks;
}
