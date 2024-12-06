package tx2;

import java.io.*;
import java.util.ArrayList;

public class SinhVienDAO {
    private  String FILE_NAME = "sinhvien.dat";

    public void ghiDanhSachSinhVien(ArrayList<Student> danhSach) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(danhSach);
        oos.close();
        fos.close();
    }

    public ArrayList<Student> docDanhSachSinhVien() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Student> danhSach = (ArrayList<Student>) ois.readObject();
        ois.close();
        fis.close();
        return danhSach;
    }
}