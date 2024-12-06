package tx2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        QuanLySV ql = new QuanLySV();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("CHUONG TRINH QUAN LY SINH VIEN");
            System.out.println("1. Nhap sinh vien");
            System.out.println("2. Hien thi sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Sua sinh vien");
            System.out.println("5. Tim kiem sinh vien");
            System.out.println("6. Doc file DAT: ");
            System.out.print("Chon chuc nang: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                	try {
                        ql.themSinhVien();
                    } catch (IOException e) {
                        // Handle the exception
                        e.printStackTrace(); // Print the stack trace for debugging
                        System.out.println("Lỗi khi thêm sinh viên!");
                    }
                	break;
                case 2:
                    ql.hienThiDanhSach();
                    break;
                case 3:
                	try {
                    System.out.println("Nhap id: ");
                    String id = sc.nextLine();
                    ql.xoaSinhVien(id);
                	} catch (IOException e) {
                        // Handle the exception
                        e.printStackTrace(); // Print the stack trace for debugging
                        System.out.println("Lỗi khi thêm sinh viên!");
                    }
                    break;
                case 4:
                	try {
                	System.out.println("Nhap id: ");
                    String id1 = sc.nextLine();
                    ql.suaSinhVien(id1);
                	} catch (IOException e) {
                        // Handle the exception
                        e.printStackTrace(); // Print the stack trace for debugging
                        System.out.println("Lỗi khi thêm sinh viên!");
                    }
                	break;
                case 5:
                	System.out.println("Nhap id: ");
                    String id11 = sc.nextLine();
                    ql.timKiemSinhVien(id11);
                    break;    
                case 6:
                	try {
                	System.out.println("Doc file DAT: ");
                	ql.readDAT();
                	} catch (IOException e) {
                        // Handle the exception
                        e.printStackTrace(); // Print the stack trace for debugging
                        System.out.println("Lỗi khi thêm sinh viên!");
                    }
                	break;
                case 7:
                	System.out.println("Kết thúc chương trình. ");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
