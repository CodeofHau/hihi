package tx2;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
    private String studentID;
    private double diemM1;
    private double diemM2;
    private double diemTB;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public double getDiemM1() {
		return diemM1;
	}

	public void setDiemM1(double diemM1) {
		this.diemM1 = diemM1;
	}

	public double getDiemM2() {
		return diemM2;
	}

	public void setDiemM2(double diemM2) {
		this.diemM2 = diemM2;
	}

	public double getDiemTB() {
		return diemTB;
	}

    public void setDiemTB(double diemM1, double diemM2) {
    	this.diemTB = (diemM1+diemM2)/2;
    }

	public Student(String name, String studentID, double diemM1, double diemM2) {
		this.name = name;
		this.studentID = studentID;
		this.diemM1 = diemM1;
		this.diemM2 = diemM2;
		this.diemTB = (diemM1 + diemM2)/2;
	} 
	
	public String toString() {
		return "ID: " + studentID + "\nName: " + name 
		+ "\nDiem 1: " + diemM1 + "\nDiem 2: " + diemM2 + "\nDiem trung binh: " + diemTB;
	}
}
