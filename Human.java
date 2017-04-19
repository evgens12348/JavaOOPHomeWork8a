package com.gmail.s12348.evgen;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Human implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String sex;
	private int old;

	public Human(String name, String surname, String sex, int old) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.old = old;
	}

	public Human() {
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void inputName() throws MyExeption {
		name = "";
		for (;;) {
			name = String.valueOf(JOptionPane.showInputDialog("Input name"));
			if (name == "null")
				throw new MyExeption();
			if (checkString(name) != true) {
				JOptionPane.showMessageDialog(null, "Input Error");
			} else {
				break;
			}
		}
	}

	public void inputSurname() throws MyExeption {
		surname = "";
		for (;;) {
			surname = String.valueOf(JOptionPane.showInputDialog("Input surname"));
			if (surname == "null")
				throw new MyExeption();
			if (checkString(surname) != true) {
				JOptionPane.showMessageDialog(null, "Input Error");
			} else {
				break;
			}
		}
	}

	public String inputSex() {
		int s = JOptionPane.showConfirmDialog(null, surname + " " + name + " man?");
		if (s == 0) {
			sex = "man";
		} else if (s == 1) {
			sex = "woman";
		}
		return sex;
	}

	public void inputOld() {
		for (;;) {
			try {
				old = Integer.valueOf(JOptionPane.showInputDialog("Enter the age"));
				if (old <= 0)
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

	public boolean checkString(String string) {
		if (string.length() == 0) {
			return false;
		} else {
			Pattern p = Pattern.compile("^([a-zA-Z- ¹]+)");
			Matcher m = p.matcher(string);

			return m.matches();
		}
	}

	public void print() {
		System.out.printf("Human " + name + " " + surname + ", " + sex + ", age " + old);
	}

	@Override
	public String toString() {

		return surname + " " + name + ", " + sex + ", age " + old;
	}

}
