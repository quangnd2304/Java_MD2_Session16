package ra;

import java.io.*;
import java.util.Scanner;

public class BufferedWriter_BufferReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        writeDataToFile(sc, "D:/RikkeiAcademy/SourceCode/Session16_File/demo.txt");
        readDataFromFile("demo.txt");
    }

    public static void writeDataToFile(Scanner sc, String path) {
        //1. Khoi tao doi tuong File
        File file = new File(path);
        //2. Khoi tao cac doi tuong outputStream
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        //3. Thuc hien nhap du lieu tu ban phim va luu ra file
        do {
            System.out.println("Nhap mot dong du lieu: ");
            String line = sc.nextLine();
            //Ghi ra file
            try {
                bw.write(line);
                bw.flush();
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ban co muon ghi du lieu tiep khong: ");
            System.out.println("1. Co");
            System.out.println("2. Khong");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1) {
                break;
            }
        } while (true);
        //4. Dong cac ket noi
        try {
            bw.close();
            osw.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readDataFromFile(String path) {
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            //1. Khoi tao doi tuong file
            file = new File(path);
            //2. Khoi tao cac doi tuong InputStream
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            //3. Doc du lieu tu file
            System.out.println("Cac du lieu trong file la: ");
            String line = br.readLine();
            while (line!=null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch (RuntimeException ex1) {
            ex1.printStackTrace();
        } catch (FileNotFoundException ex2) {
            ex2.printStackTrace();
        } catch (IOException ex3) {
            ex3.printStackTrace();
        } finally {
            try {
                if (br!=null) {
                    br.close();
                }
                if(isr!=null) {
                    isr.close();
                }
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
