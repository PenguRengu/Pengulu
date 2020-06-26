package com.pengu.pengulu.testrun;

import com.pengu.pengulu.*;

public class TestRun extends Game implements UniversalChoiceListener {
	
	public static void main(String[] args) {
		new TestRun().go();
	}
	
	void go() {
		Node.setGame(this);
		Node.setUniversalChoices(new String[] {"display inventory"});
		addNode(new Forest());
		addNode(new Plains());
		addNode(new Cave());
		addNode(new Mountains());
		
		InventoryManager.addItem(new Log(0));
		InventoryManager.addItem(new Cobblestone(0));
		InventoryManager.addItem(new Coal(0));
		
		setCurrentNode(Game.getNodeById("forest"));
		start();
	}

	@Override
	public void respond(String choice) {
		Game.displayln("" + Node.getUniversalChoiceIndex(choice));
		InventoryManager.display();
	}
	
}
