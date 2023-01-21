/**
 * Encodes joystick data from two players as a bit field (one byte)
 */

public class DualJoysticks {

    public static final int ONE_LEFT = 128;
    public static final int ONE_UP = 64;
    public static final int ONE_RIGHT = 32;
    public static final int ONE_DOWN = 16;
    public static final int TWO_LEFT = 8;
    public static final int TWO_UP = 4;
    public static final int TWO_RIGHT = 2;
    public static final int TWO_DOWN = 1;

    public static final String KEY = "LURD";

    public static byte state(int... positions){
        byte info = 0b0;
        for (int i:positions) {
            info |= i;
        }
        return info;
    }

    public static void main(String[] args) {
        String p1 = "RDDRRDDDRRDDLLLU";
        String p2 = "LDLLUULULDDLLLDD";
        for (int i = 0; i<p1.length(); i++) {
            int p1v = value(p1.substring(i, i+1)) << 4; // left nibble of byte
            int p2v = value(p2.substring(i, i+1));  // right nibble of byte
            int result = p1v + p2v;
            System.out.println(result);
        }
        System.out.println("Complete");
    }

    public static int value(String position){
        return (int) Math.pow(2, KEY.indexOf(position));
    }


}
