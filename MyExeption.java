package com.gmail.s12348.evgen;

import javax.swing.JOptionPane;

public class MyExeption extends Exception {

	public void nameNull(String name) {
		if (name == "null") {
			JOptionPane.showMessageDialog(null, "Canseled set as default");
			name = "NoName";
		}
	}
}
