package tx2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySV {
	    private SinhVienDAO dao = new SinhVienDAO();
	    private ArrayList<Student> danhSachSV = new ArrayList<>();    
        Scanner sc = new Scanner(System.in);

	    public Student taoSinhVien() {
	        System.out.print("Nhap ho ten: ");
	        String name = sc.nextLine();
	        
	        System.out.print("Nhap id: ");
	        String studentID = sc.nextLine();
	        
	        System.out.print("Nhap diem 1: ");
	        double diemM1 = sc.nextDouble();
	        sc.nextLine();
	        
	        System.out.print("Nhap diem 2: ");
	        double diemM2 = sc.nextDouble();
	        sc.nextLine();

	        Student sv = new Student(name, studentID, diemM1, diemM2);
	        return sv;
	    }

	    public void themSinhVien() throws IOException {
	        Student sv = taoSinhVien();
	        danhSachSV.add(sv);
	        System.out.println("Ghi thanh cong");
	        
	        dao.ghiDanhSachSinhVien(danhSachSV);
	    }

	    public void suaSinhVien(String maSV) throws IOException{
	        if (danhSachSV == null || danhSachSV.isEmpty()) {
	            System.out.println("Danh sách sinh viên rỗng.");
	            return;
	        }

	        if (maSV == null || maSV.trim().isEmpty()) {
	            System.out.println("Mã sinh viên không hợp lệ.");
	            return;
	        }

	        for (Student sv : danhSachSV) {
	            if (sv.getStudentID().equals(maSV)) {

	                System.out.print("Nhập tên mới: ");
	                String tenMoi = sc.nextLine();
	                sv.setName(tenMoi);
	                		
	                System.out.print("Nhập điểm 1: ");
	                double diem1 = sc.nextDouble();
	                sc.nextLine();
	                sv.setDiemM1(diem1);
	                
	                System.out.println("Nhập điểm 2: ");
	                double diem2 = sc.nextDouble();
	                sc.nextLine();
	                sv.setDiemM2(diem2);
	                
	                sv.setDiemTB(diem1, diem2);
	                System.out.println("Thông tin sinh viên đã được cập nhật.");
	                return;
	            }
	        }
	        dao.ghiDanhSachSinhVien(danhSachSV);

	        System.out.println("Không tìm thấy sinh viên có mã " + maSV);
	    }
	    
	    public void xoaSinhVien(String maSV) throws IOException {
            if (danhSachSV != null && !danhSachSV.isEmpty()) {
                boolean removed = danhSachSV.removeIf(sv -> sv.getStudentID().equals(maSV));
                
                if (removed) {
                    System.out.println("Sinh viên đã được xóa.");
                    dao.ghiDanhSachSinhVien(danhSachSV);
                } else {
                    System.out.println("Không tìm thấy sinh viên có mã " + maSV);
                }
            } else {
                System.out.println("Danh sách sinh viên rỗng.");
            }   
	    }

	    public void timKiemSinhVien(String maSV) {
	        if (danhSachSV == null || danhSachSV.isEmpty()) {
	            System.out.println("Danh sách sinh viên rỗng.");
	            return;
	        }

	        boolean found = false;
	        for (Student sv : danhSachSV) {
	            if (sv.getStudentID().equals(maSV)) {
	                System.out.println(sv);
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("Không tìm thấy sinh viên thỏa mãn.");
	        }
	    }
	    
	    public void hienThiDanhSach() {
	        for (Student sv : danhSachSV) {
	            System.out.println(sv.toString());
	        }
	    }
	    
	    public void readDAT() throws IOException, ClassNotFoundException {
	            ArrayList<Student> danhSach = dao.docDanhSachSinhVien(); 
	            if (danhSach.isEmpty()) {
	                System.out.println("Không có sinh viên nào trong danh sách.");
	                return;
	            }

	            System.out.println("Danh sách sinh viên:");
	            for (Student student : danhSach) {
	                System.out.println(student); // Assuming Student class has a meaningful toString() method
	            }
	         }
}

