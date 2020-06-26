package com.pengu.pengulu;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JFrame implements ActionListener {
	
	private static JTextArea displayArea;
	private static JTextField inputField;
	private static JButton submitButton;
	private static JScrollPane scrollPane;
	private static ColorTheme colorTheme = ColorTheme.monochrome;
	
	private static Node currentNode;
	private static ArrayList<Node> nodes = new ArrayList<Node>();
	
	public void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		makeGui();
		
		currentNode.request();
		
		setSize(1000, 800);
		setVisible(true);
	}
	
	private void makeGui() {
		displayArea = new JTextArea();
		displayArea.setEditable(false);
		displayArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		
		scrollPane = new JScrollPane(displayArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		
		inputField = new JTextField();
		inputField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		inputField.addActionListener(this);
		
		
		bottomPanel.add(inputField, BorderLayout.CENTER);
		
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		submitButton.addActionListener(this);
		bottomPanel.add(submitButton, BorderLayout.EAST);
		
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		updateColors();
		
	}
	
	private static void updateColors() {
		displayArea.setBackground(colorTheme.getBackground());
		displayArea.setForeground(colorTheme.getForeground());
		displayArea.setSelectedTextColor(colorTheme.getForeground());
		displayArea.setSelectionColor(colorTheme.getInputBackground());
		
		scrollPane.getVerticalScrollBar().setBackground(colorTheme.getBackground());
		scrollPane.getHorizontalScrollBar().setBackground(colorTheme.getBackground());
		setScrollBarColor(scrollPane.getVerticalScrollBar(), colorTheme.getForeground());
		setScrollBarColor(scrollPane.getHorizontalScrollBar(), colorTheme.getForeground());
		
		inputField.setBackground(colorTheme.getInputBackground());
		inputField.setForeground(colorTheme.getInputForeground());
		inputField.setSelectedTextColor(colorTheme.getInputBackground());
		inputField.setSelectionColor(colorTheme.getInputForeground());
		inputField.setCaretColor(colorTheme.getCaretColor());
		inputField.setBorder(new LineBorder(colorTheme.getInputBackground(), 0, false));
		
		submitButton.setBackground(colorTheme.getInputBackground());
		submitButton.setForeground(colorTheme.getInputForeground());
		submitButton.setBorder(new LineBorder(colorTheme.getInputForeground(), 2, false));
	}
	
	private static void setScrollBarColor(JScrollBar bar, Color color) {
		bar.setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = color;
		    }
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		displayln("> " + inputField.getText());
		if (currentNode.getInputRequested()) {
			currentNode.setInputRequested(false);
			currentNode.respondToInput(inputField.getText());
		} else {
			if (currentNode.respondToUniversalChoice(inputField.getText())) {
				currentNode.runAgain();
			} else {
				currentNode.respond(inputField.getText());
			}
			
		}
		inputField.setText("");
		
	}
	
	public static void setCurrentNode(Node node) {
		if (currentNode != null) {
			Node.setPreviousNodeId(currentNode.getId());
		}
		
		currentNode = node;
	}
	static Node getCurrentNode() {
		return currentNode;
	}
	public static void addNode(Node node) {
		nodes.add(node);
	}
	public static Node getNodeById(String id) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getId().equals(id)) {
				return nodes.get(i);
			}
		}
		return currentNode;
	}
	
	public static void setColorTheme(ColorTheme colorTheme) {
		Game.colorTheme = colorTheme;
		updateColors();
	}
	
	public static void display(String message) {
		displayArea.append(message);
		displayArea.setCaretPosition(displayArea.getDocument().getLength());
	}
	public static void displayln(String message) {
		display(message + "\n");
	}
	public static void displayln() {
		display("\n");
	}
}
