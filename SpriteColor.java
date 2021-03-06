package SpriteMe;

import java.awt.Color;

import SpriteManipulator.SpriteManipulator;

public class SpriteColor {
	
	private String n;
	private byte[] RGB;
	private Color c;
	/**
	 * Makes a new color with a name and 3 RGB values.
	 * @param name
	 * @param r
	 * @param g
	 * @param b
	 */
	public SpriteColor(String name, byte r, byte g, byte b) {
		n = name;
		RGB = new byte[] { r, g, b };
		roundSelf();
		c = new Color(
					Byte.toUnsignedInt(RGB[0]),
					Byte.toUnsignedInt(RGB[1]),
					Byte.toUnsignedInt(RGB[2])
				);
	}
	
	/**
	 * Makes a new color with a name and 3 RGB values, but with integers to allow unsigned values.
	 * @param name
	 * @param r
	 * @param g
	 * @param b
	 */
	public SpriteColor(String name, int r, int g,  int b) {
		this(name, (byte) r, (byte) g, (byte) b );
	}

	/**
	 * 
	 * @return
	 */
	public Color toColor() {
		return c;
	}

	/**
	 * 
	 */
	private void roundSelf() {
		RGB[0] = (byte) SpriteManipulator.roundVal(RGB[0]);
		RGB[1] = (byte) SpriteManipulator.roundVal(RGB[1]);
		RGB[2] = (byte) SpriteManipulator.roundVal(RGB[2]);
	}
	
	/**
	 * 
	 */
	public String toString() {
		return n;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toFullString() {
		return String.format("%s (RGB{%s,%s,%s})",
				n,
				Byte.toUnsignedInt(RGB[0]),
				Byte.toUnsignedInt(RGB[1]),
				Byte.toUnsignedInt(RGB[2]));
	}

	public byte[] getRGB() {
		return new byte[] { RGB[0], RGB[1], RGB[2] };
	}
	/**
	 * 
	 * @return
	 */
	// TODO : Some formula that works better
	public ColorPair makeShadedPair() {
		int r2 = Byte.toUnsignedInt(RGB[0]);
		int g2 = Byte.toUnsignedInt(RGB[1]);
		int b2 = Byte.toUnsignedInt(RGB[2]);
		r2 = r2 * 6 / 8;
		g2 = g2 * 6 / 8;
		b2 = b2 * 6 / 8;
		SpriteColor shade = new SpriteColor(n + "shaded",r2, g2, b2);
		return new ColorPair(n, this, shade);
	}
	
	/*
	 * Some color constants
	 */

	// Skin colors
	public static final SpriteColor WHITE_SKIN_LT =
			new SpriteColor("White skin", 240, 160, 104);
	public static final SpriteColor LEIUTENANT_FACE = WHITE_SKIN_LT;
	public static final SpriteColor WHITE_SKIN_DK =
			new SpriteColor("White skin shade", 184, 104, 32);
	public static final SpriteColor PALE_SKIN =
			new SpriteColor("Pale skin", 248, 232, 168);
	public static final SpriteColor HISPANIC_SKIN =
			new SpriteColor("Hispanic skin", 216, 136, 80);
	public static final SpriteColor BROWN_SKIN =
			new SpriteColor("Brown skin", 168, 88, 24);
	public static final SpriteColor BLACK_SKIN =
			new SpriteColor("Black skin", 96, 48, 8);
	
	// THE BEST COLORS
	public static final SpriteColor RASPBERRY =
			new SpriteColor("Raspberry", 152, 0, 64);
	public static final SpriteColor RASPBERRY_DK =
			new SpriteColor("Raspberry shade", 112, 0, 56);
	public static final SpriteColor MIKES_ORANGE =
			new SpriteColor("Mike's orange", 248, 176, 0);
	public static final SpriteColor NUMPTY_BLUE =
			new SpriteColor("Numpty blue", 56, 152, 216);

	// A beautiful rainbow
	public static final SpriteColor BRIGHT_RED =
			new SpriteColor("Bright red", 248, 0, 0);
	public static final SpriteColor BRIGHT_ORANGE =
			new SpriteColor("Bright orange", 248, 128, 0);
	public static final SpriteColor BRIGHT_YELLOW =
			new SpriteColor("Bright yellow", 248, 248, 0);
	public static final SpriteColor BRIGHT_GREEN =
			new SpriteColor("Bright green", 0, 248, 0);
	public static final SpriteColor BRIGHT_CYAN =
			new SpriteColor("Bright cyan", 0, 248, 248);
	public static final SpriteColor BRIGHT_BLUE =
			new SpriteColor("Bright blue", 0, 0, 248);
	public static final SpriteColor BRIGHT_PURPLE =
			new SpriteColor("Bright indigo", 128, 0, 248);
	
	// other colors
	public static final SpriteColor BLACK =
			new SpriteColor("Black", 72, 72, 72);
	public static final SpriteColor OFFWHITE =
			new SpriteColor("Off-white", 232, 232, 232);
}