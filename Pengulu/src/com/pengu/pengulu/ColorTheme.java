package com.pengu.pengulu;

import java.awt.*;

public class ColorTheme {
	private Color background;
	private Color foreground;
	private Color inputBackground;
	private Color inputForeground;
	private Color caretColor;
	
	public ColorTheme(Color background, Color foreground, Color inputBackground, Color inputForeground, Color caretColor) {
		this.background = background;
		this.foreground = foreground;
		this.inputBackground = inputBackground;
		this.inputForeground = inputForeground;
		this.caretColor = caretColor;
	}
	
	public Color getBackground() {
		return background;
	}
	
	public Color getForeground() {
		return foreground;
	}
	
	public Color getInputBackground() {
		return inputBackground;
	}
	
	public Color getInputForeground() {
		return inputForeground;
	}
	
	public Color getCaretColor() {
		return caretColor;
	}
	
	public static final ColorTheme monochrome = new ColorTheme(Color.BLACK, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.WHITE);
	public static final ColorTheme mist = new ColorTheme(new Color(137, 143, 142), new Color(190, 190, 190), new Color(161, 173, 171), new Color(240, 240, 240), Color.WHITE);
	public static final ColorTheme ocean = new ColorTheme(new Color(0, 20, 80), new Color(0, 140, 150), new Color(0, 100, 200), new Color(0, 200, 200), Color.CYAN);
}
