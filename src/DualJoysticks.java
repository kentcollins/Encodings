/**
 * Encodes joystick data from two players as a bit field (one byte)
 */

public class DualJoysticks {

    public static final String KEY = "DRUL";  // indexOf direction yields amount of left bitshift

    public static int encode(String position){
        return (int) Math.pow(2, KEY.indexOf(position));
    }

    public static String decode(int number) {
        int p1Index = Integer.numberOfTrailingZeros((number & 0xF0) >> 4);
        int p2Index = Integer.numberOfTrailingZeros(number & 0x0F);
        return ""+ KEY.charAt(p1Index) + KEY.charAt(p2Index);
    }

    public static void main(String[] args) {
        String p1 = "RDDRRDDDRRDDLLLU";
        String p2 = "LDLLUULULDDLLLDD";
        for (int i = 0; i<p1.length(); i++) {
            int p1v = encode(p1.substring(i, i+1)) << 4; // left nibble of byte
            int p2v = encode(p2.substring(i, i+1));  // right nibble of byte
            int result = p1v + p2v;
            System.out.println(result + "\t"+Integer.toHexString(result) + "\t"+decode(result));
        }
    }
}
