package attributes;

public interface Colorable {
	
	enum Color {
		BLACK, WHITE, GRAY, RED, BLUE, GREEN, YELLOW, NONE;
	
	}
	
	
	
	Color getColor();
	
	
	
	void setColor(Color color);
	
}
