package com.gmail.s12348.evgen;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class Student extends Human implements Serializable {

	private static final long serialVersionUID = 1L;
	private String highSchool;
	private String department;
	private int kurs;
	private String type;
	private double assessment;

	public Student(String name, String surname, String sex, int old, String highSchool, String department, int kurs,
			String type, double assessment) {
		super(name, surname, sex, old);
		this.highSchool = highSchool;
		this.department = department;
		this.kurs = kurs;
		this.type = type;
		this.assessment = assessment;
	}

	public Student() {

	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getKurs() {
		return kurs;
	}

	public void setKurs(int kurs) {
		this.kurs = kurs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAssessment() {
		return assessment;
	}

	public void setAssessment(double assessment) {
		this.assessment = assessment;
	}

	public void inputHighSchool() throws MyExeption {
		highSchool = "";
		for (;;) {
			highSchool = String.valueOf(JOptionPane.showInputDialog("Input name High School"));
			if (highSchool == "null")
				throw new MyExeption();
			if (checkString(highSchool) != true) {
				JOptionPane.showMessageDialog(null, "Input Error");
			} else {
				break;
			}
		}
	}

	public void inputDepartment() throws MyExeption {
		department = "";
		for (;;) {
			department = String.valueOf(JOptionPane.showInputDialog("Input name Department"));
			if (department == "null")
				throw new MyExeption();
			if (checkString(department) != true) {
				JOptionPane.showMessageDialog(null, "Input Error");
			} else {
				break;
			}
		}
	}

	public void inputType() {
		int s = JOptionPane.showConfirmDialog(null, "This student is a full-time student?");
		if (s == 0) {
			type = "full-time";
		} else if (s == 1) {
			type = "correspondence";
		} else {
			type = "Unknown form of training";
		}

	}

	public void inputKurs() {
		for (;;) {
			try {
				kurs = Integer.valueOf(JOptionPane.showInputDialog("Enter the course of study"));
				if (kurs <= 0)
					throw new MyNegativeExeption();
				break;
			} catch (MyNegativeExeption e) {
				e.negativeNumber();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canseled set as default");
				break;
			}
		}

	}

	public void inputAssessment() {
		for (;;) {
			try {
				assessment = Double.valueOf(JOptionPane.showInputDialog("Enter the student's progress"));
				if (assessment <= 0)
					throw new MyNegativeExeption();
				break;
			} catch (MyNegativeExeption e) {
				e.negativeNumber();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canseled set as default");
				break;
			}
		}

	}

	@Override
	public String toString() {

		return "Student " + super.toString() + " educational institution " + highSchool + ", department " + department
				+ ", kurs " + kurs + ", type of training " + type + ", academic performance " + assessment;
	}

}
