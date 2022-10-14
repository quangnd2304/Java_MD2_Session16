package ra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Write_ReadObject {
    public static void main(String[] args) {
//        List<Student> listStudents = new ArrayList<>();
//        Student st1 = new Student("SV001", "Nguyen Van A", 20);
//        Student st2 = new Student("SV002", "Nguyen Van B", 19);
//        Student st3 = new Student("SV003", "Nguyen Van A", 21);
//        listStudents.add(st1);
//        listStudents.add(st2);
//        listStudents.add(st3);
//        writeObjectToFile(listStudents, "listStudent.txt");
        readObjectFromFile("listStudent.txt");

    }

    public static void writeObjectToFile(List<Student> listStudent, String path) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //1. Khoi tao doi tuong file
            file = new File(path);
            //2. Khoi tao cac doi tuong OutputStream
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            //3. Ghi du lieu ra file
            oos.writeObject(listStudent);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //4. Dong cac ket noi
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }

    public static void readObjectFromFile(String path) {
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            //1. Khoi tao doi tuong file
            file = new File(path);
            //2. Khoi tao cac doi tuong InputStream
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            //3. Doc doi tuong tu file va luu o bien
            List<Student> listStudentRead = (List<Student>) ois.readObject();
            System.out.println("Danh sach sinh vien doc duoc tu file:");
            for (Student st : listStudentRead) {
                System.out.printf("Ma SV: %s - ten SV: %s - Tuoi: %d\n",st.getStudentId(),st.getStudentName(),st.getAge());
            }
        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            //4. Dong cac ket noi
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }

}
