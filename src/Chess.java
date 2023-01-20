public class Chess {

    public static final byte BLACK = (byte) Math.pow(2, 6);
    public static final byte KING = (byte) Math.pow(2, 5);
    public static final byte QUEEN = (byte) Math.pow(2, 4);
    public static final byte ROOK = (byte) Math.pow(2, 3);
    public static final byte BISHOP = (byte) Math.pow(2, 2);
    public static final byte KNIGHT = (byte) Math.pow(2, 1);
    public static final byte PAWN = (byte) Math.pow(2, 0);

    public static void main(String[] args) {
        byte[][] board = new byte[8][8];
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (r == 0 || r == 1) board[r][c] |= BLACK;
                if (r == 1 || r == 6) board[r][c] |= PAWN;
            }
        }

        board[0][0] |= ROOK;
        board[7][0] |= ROOK;
        board[0][1] |= KNIGHT;
        board[7][1] |= KNIGHT;
        board[0][2] |= BISHOP;
        board[7][2] |= BISHOP;
        board[0][3] |= QUEEN;
        board[7][3] |= QUEEN;
        board[0][4] |= KING;
        board[7][4] |= KING;
        board[0][5] |= BISHOP;
        board[7][5] |= BISHOP;
        board[0][6] |= KNIGHT;
        board[7][6] |= KNIGHT;
        board[0][7] |= ROOK;
        board[7][7] |= ROOK;

       for (byte[] arr:board) {
           for (byte b: arr) {
               System.out.print(String.format("%1$02x ", b));
           }
           System.out.println();
       }
    }


    //

}