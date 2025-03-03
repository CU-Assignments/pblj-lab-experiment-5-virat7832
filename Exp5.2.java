import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L; 
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

   
    public void display() {
        System.out.println("Student ID: " + id + ", Name: " + name + ", GPA: " + gpa);
    }
}

public class StudentSerializationDemo {
    private static final String FILE_NAME = "student.ser";

    public static void main(String[] args) {
        // **Test Case 1: Serialize and Deserialize a valid student object**
        System.out.println("=== Test Case 1: Valid Serialization & Deserialization ===");
        Student student = new Student(1, "John Doe", 3.75);
        serializeStudent(student);
        Student deserializedStudent = deserializeStudent(FILE_NAME);
        if (deserializedStudent != null) {
            System.out.println("Deserialized Student Details:");
            deserializedStudent.display();
        }
        
        // **Test Case 2: Try to deserialize from a non-existent file**
        System.out.println("\n=== Test Case 2: Deserialize from a Non-Existent File ===");
        deserializeStudent("non_existent_file.ser");

        // **Test Case 3: Handle invalid class during deserialization**
        
        System.out.println("\n=== Test Case 3: Simulating ClassNotFoundException ===");
        deserializeInvalidClass();
    }

    
    public static void serializeStudent(Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(student);
            System.out.println("Student object has been serialized and saved to file.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error: IO Exception occurred during serialization.");
        }
    }

    public static Student deserializeStudent(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("Student object has been deserialized.");
            return (Student) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error: IO Exception occurred during deserialization.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found.");
        }
        return null;
    }

    public static void deserializeInvalidClass() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (!(obj instanceof Student)) {
                throw new ClassNotFoundException();
            }
            System.out.println("Unexpected successful deserialization.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error: IO Exception occurred during deserialization.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found.");
        }
    }
}
