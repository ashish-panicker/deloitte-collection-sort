package demo1.ioc;

public class Color {

	private String paint = "green";

	public Color(String paint) {
		this.paint = paint;
	}

	public Color() {
		System.out.println("Color class constructor.");
	}

	public String getPaint() {
		return paint;
	}

	public void setPaint(String paint) {
		this.paint = paint;
	}

	public void init() {
		System.out.println("Color class init method.");
	}

	public void destroy() {
		System.out.println("Color class destroy method.");
	}
}