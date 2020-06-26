package com.pengu.pengulu;

public class ItemTemplate {
	private int count;
	private String id;
	
	public ItemTemplate(int count, String id) {
		this.count = count;
		this.id = id;
	}
	
	public int getCount() {
		return count;
	}
	public void incrementCount(int amount) {
		count += amount;
	}
	public boolean decrementCount(int amount) {
		if (count - amount < 0) {
			return false;
		}
		count -= amount;
		return true;
	}
	
	public String getId() {
		return id;
	}
	
	public void display() {
		Game.displayln(id + ": " + count);
	}
}
