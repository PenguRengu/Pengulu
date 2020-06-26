package com.pengu.pengulu;

import java.util.ArrayList;

public class InventoryManager {
	private static ArrayList<ItemTemplate> items = new ArrayList<ItemTemplate>();
	
	public static void addItem(ItemTemplate item) {
		items.add(item);
	}
	
	public static ItemTemplate getItemById(String id) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId().equals(id)) {
				return items.get(i);
			}
		}
		return null;
	}
	
	public static int getItemCount(ItemTemplate item) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId().equals(item.getId())) {
				return items.get(i).getCount();
			}
		}
		return -1;
	}
	
	public static void incrementItem(ItemTemplate item, int amount) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId().equals(item.getId())) {
				items.get(i).incrementCount(amount);
			}
		}
	}
	public static void incrementItem(ItemTemplate item) {
		incrementItem(item, item.getCount());
	}
	
	public static boolean decrementItem(ItemTemplate item, int amount) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId().equals(item.getId())) {
				return items.get(i).decrementCount(amount);
			}
		}
		return false;
	}
	public static boolean decrementItem(ItemTemplate item) {
		return decrementItem(item, item.getCount());
	}
	
	public static void display() {
		for (int i = 0; i < items.size(); i++) {
			items.get(i).display();
		}
	}
}
