package com.gmail.s12348.evgen;

import javax.swing.JOptionPane;

public class MyNegativeExeption extends Exception {

	public void negativeNumber() {
		JOptionPane.showMessageDialog(null, "Not the correct number");
	}
}
