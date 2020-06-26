package com.pengu.pengulu.testrun;

import com.pengu.pengulu.*;

public class Forest extends Node implements InputListener {
	
	public Forest() {
		super(new String[] {"plains", "cave", "mine trees"}, new String[] {"plains", "cave"}, "forest");
	}
	
	@Override
	public void respond(String choice) {
		int choiceIndex = getChoiceIndex(choice);
		if (choiceIndex == 2) {
			Game.displayln("how many?");
			requestInput();
		} else {
			runNode(choiceIndex);
		}
	}

	@Override
	public void onInput(String inputText) {
		int treeCount = Integer.parseInt(inputText);
		if (treeCount > 5) {
			Game.displayln("number of trees can't be greater than 5");
		} else {
			Game.displayln("mining " + treeCount + " trees...");
			InventoryManager.incrementItem(new Log(treeCount));
		}
		
		runAgain();
	}
	
}
