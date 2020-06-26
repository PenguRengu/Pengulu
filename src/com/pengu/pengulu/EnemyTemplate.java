package com.pengu.pengulu;

public class EnemyTemplate {
	private int damage;
	private int health;
	private String id;
	
	public EnemyTemplate(int damage, int health, String id) {
		this.damage = damage;
		this.health = health;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public boolean takeDamage(int damage) {
		this.health -= damage;
		if (health <= 0) {
			return true;
		}
		return false;
	}
}
