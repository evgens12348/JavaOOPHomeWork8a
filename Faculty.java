package com.gmail.s12348.evgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Faculty implements Serializable {

	private static final long serialVersionUID = 1L;
	private Group groupOne = new Group();
	private Group groupTwo = new Group();
	private File fileOne = new File("GroupOne");
	private File fileTwo = new File("GroupTwo");

	public Faculty() {
		super();
	}

	public Group readGroupFromFile(File file) {
		Group group = new Group();
		if (file.exists() == true) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				group = (Group) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println(e);
			}
		}
		return group;
	}

	public void writeGroupToFile(Group group, File file) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(group);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public int selectGroup() {
		int n = 0;
		for (;;) {
			try {
				n = Integer.valueOf(JOptionPane
						.showInputDialog("Enter the group number (GroupOne-1, GroupTwo-2, GroupOne&GroupTwo-3)."));
				if (n < 1 & n > 3)
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
		return n;
	}

	public void selectionReadFile() {
		int s = 0;
		s = JOptionPane.showConfirmDialog(null, "You need to read information from a file?");
		if (s == 0) {
			switch (selectGroup()) {
			case 1:
				groupOne = readGroupFromFile(fileOne);
				break;
			case 2:
				groupTwo = readGroupFromFile(fileTwo);
				break;
			case 3:
				groupOne = readGroupFromFile(fileOne);
				groupTwo = readGroupFromFile(fileTwo);
				break;
			}
		}
	}

	public void selectionWriteFile() {
		int s = 0;
		s = JOptionPane.showConfirmDialog(null, "You need to write information to file?");
		if (s == 0) {
			switch (selectGroup()) {
			case 1:
				writeGroupToFile(groupOne, fileOne);
				break;
			case 2:
				writeGroupToFile(groupTwo, fileTwo);
				break;
			case 3:
				writeGroupToFile(groupOne, fileOne);
				writeGroupToFile(groupTwo, fileTwo);
				break;
			}
		}
	}

	public void selectionEnterStudent() {
		int s = 0;
		s = JOptionPane.showConfirmDialog(null, "Want to enter a new student into the group?");
		if (s == 0) {
			switch (selectGroup()) {
			case 1:
				groupOne.zanesenieStudent(groupOne.proverkaGroup());
				groupOne.enterStudent();
				break;
			case 2:
				groupTwo.zanesenieStudent(groupTwo.proverkaGroup());
				groupTwo.enterStudent();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "GroupOne");
				groupOne.zanesenieStudent(groupOne.proverkaGroup());
				groupOne.enterStudent();
				JOptionPane.showMessageDialog(null, "GroupTwo");
				groupTwo.zanesenieStudent(groupTwo.proverkaGroup());
				groupTwo.enterStudent();
				break;
			}
		}
	}

	public void selectionDelete() {
		int s = JOptionPane.showConfirmDialog(null, "Do I need to remove a student from the group?");
		if (s == 0) {
			switch (selectGroup()) {
			case 1:
				groupOne.requestDeleteStudent();
				break;
			case 2:
				groupTwo.requestDeleteStudent();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "GroupOne");
				groupOne.requestDeleteStudent();
				JOptionPane.showMessageDialog(null, "GroupTwo");
				groupTwo.requestDeleteStudent();
				break;
			}
		}
	}

	public void selectionFind() {
		int s = JOptionPane.showConfirmDialog(null, "Need to find a student on the list?");
		if (s == 0) {
			switch (selectGroup()) {
			case 1:
				groupOne.poiskStudent(groupOne.zaprosPoiskStudent());
				break;
			case 2:
				groupTwo.poiskStudent(groupTwo.zaprosPoiskStudent());
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "GroupOne");
				groupOne.poiskStudent(groupOne.zaprosPoiskStudent());
				JOptionPane.showMessageDialog(null, "GroupTwo");
				groupTwo.poiskStudent(groupTwo.zaprosPoiskStudent());
				break;
			}

		}
	}

	public void selectionSort() {
		int s = JOptionPane.showConfirmDialog(null, "Do I need to sort the group?");
		if (s == 0) {
			switch (selectGroup()) {
			case 1:
				groupOne.sortArray();
				break;
			case 2:
				groupTwo.sortArray();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "GroupOne");
				groupOne.sortArray();
				JOptionPane.showMessageDialog(null, "GroupTwo");
				groupTwo.sortArray();
				break;
			}
		}
	}

	public void selectionPrintInfoGroup() {
		int s = JOptionPane.showConfirmDialog(null, "Output information to the console?");
		if (s == 0) {
			switch (selectGroup()) {
			case 1:
				System.out.println(groupOne.toString());
				System.out.println("The military commissar chose:");
				groupOne.prizivnik();
				break;
			case 2:
				System.out.println(groupTwo.toString());
				System.out.println("The military commissar chose:");
				groupTwo.prizivnik();
				break;
			case 3:
				System.out.println("GroupOne:");
				System.out.println(groupOne.toString());
				System.out.println("The military commissar chose:");
				groupOne.prizivnik();
				System.out.println();
				System.out.println("GroupTwo:");
				System.out.println(groupTwo.toString());
				System.out.println("The military commissar chose:");
				groupTwo.prizivnik();
				break;
			}
		}
	}

	public void zapuskInterface() {
		selectionReadFile();
		selectionEnterStudent();
		selectionDelete();
		selectionFind();
		selectionSort();
		selectionPrintInfoGroup();
		selectionWriteFile();
	}

}
