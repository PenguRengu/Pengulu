package com.pengu.pengulu;

import java.lang.reflect.Array;

public class Node {
	
	private boolean inputRequested;
	private String[] choices;
	private String[] connections;
	private String id;
	private static String previousNodeId;
	private static Game game;
	private int universalChoicesStartIndex;
	private static String[] universalChoices = new String[] {};
	
	public Node(String[] choices, String[] connections, String id) {
		this.universalChoicesStartIndex = choices.length;
		this.choices = concatenate(choices, universalChoices);
		this.connections = connections;
		this.id = id;
	}
	
	public String getIntroText() {
		return null;
	}
	public String getId() {
		return id;
	}
	public static String getPreviousNodeId() {
		return previousNodeId;
	}
	static void setPreviousNodeId(String previousNodeId) {
		Node.previousNodeId = previousNodeId;
	}
	public static void setUniversalChoices(String[] universalChoices) {
		Node.universalChoices = universalChoices;
	}
	public static void setGame(Game game) {
		Node.game = game;
	}
	
	public void displayChoicesText() {
		for (int i = 0; i < choices.length; i++) {
			Game.displayln((i + 1) + ") " + choices[i]);
		}
		
	}
	
	void request() {
		Game.displayln();
		if (getIntroText() != null) {
			Game.displayln(getIntroText());
		}
		displayChoicesText();
	}
	
	public void requestInput() {
		inputRequested = true;
	}
	void setInputRequested(boolean inputRequested) {
		this.inputRequested = inputRequested;
	}
	boolean getInputRequested() {
		return inputRequested;
	}
	
	public void respondToInput(String inputText) {
		inputRequested = false;
		if (this instanceof InputListener) {
			((InputListener)this).onInput(inputText);
		}
	}
	
	private static int _getChoiceIndex(String choice, String[] choices) {
		int choiceIndex = 0;
		try {
			choiceIndex = Integer.parseInt(choice) - 1;
			if (choiceIndex > choices.length - 1) {
				choiceIndex = choices.length - 1;
			}
		} catch (NumberFormatException ex) {
			for (int i = 0; i < choices.length; i++) {
				if (choice.equals(choices[i])) {
					choiceIndex = i;
				}
			}
		}
		return choiceIndex;
	}
	public int getChoiceIndex(String choice) {
		return _getChoiceIndex(choice, choices);
	}
	public static int getUniversalChoiceIndex(String choice) {
		return  _getChoiceIndex(choice, universalChoices) - Game.getCurrentNode().universalChoicesStartIndex;
	}
	
	
	boolean respondToUniversalChoice(String choice) {
		int choiceIndex = getChoiceIndex(choice);
		if (universalChoices.length <= 0 || choiceIndex < universalChoicesStartIndex || !(game instanceof UniversalChoiceListener)) {
			return false;
		}
		((UniversalChoiceListener)game).respond(choice);
		
		return true;
	}
	public void respond(String choice) {
		runNode(getChoiceIndex(choice));
	}
	
	public void runNode(int choiceIndex) {
		Node node = Game.getNodeById(connections[choiceIndex]);
		node.request();
		Game.setCurrentNode(node);
	}
	public void runAgain() {
		request();
	}
	
	private static <T> T[] concatenate(T[] a, T[] b) {
	    int aLen = a.length;
	    int bLen = b.length;

	    @SuppressWarnings("unchecked")
	    T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
	    System.arraycopy(a, 0, c, 0, aLen);
	    System.arraycopy(b, 0, c, aLen, bLen);

	    return c;
	}
}
