package com.pengu.pengulu.testrun;

import com.pengu.pengulu.*;

public class Cave extends Node implements InputListener {
	
	private String itemToMine;
	
	public Cave() {
		super(new String[] {"forest", "mine stone", "mine coal ore"}, new String[] {"forest"}, "cave");
	}
	
	@Override
	public void respond(String choice) {
		int choiceIndex = getChoiceIndex(choice);
		if (choiceIndex == 0) {
			runNode(choiceIndex);
		} else {
			if (choiceIndex == 1) {
				itemToMine = "cobblestone";
			}
			if (choiceIndex == 2) {
				itemToMine = "coal";
			}
			Game.displayln("how many?");
			requestInput();
		}
	}
	
	@Override
	public void onInput(String inputText) {
		int itemCount = Integer.parseInt(inputText);
		if (itemCount > 5) {
			Game.displayln("number of items can't be greater than 5");
		} else {
			Game.displayln("mining " + itemCount + " " + itemToMine + "...");
			InventoryManager.incrementItem(InventoryManager.getItemById(itemToMine), itemCount);
		}
		runAgain();
	}
	
}
