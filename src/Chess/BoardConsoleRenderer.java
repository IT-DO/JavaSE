package Chess;

import Chess.piece.Piece;

public class BoardConsoleRenderer {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";

    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";


    public void render(Board board) {
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteFotEmptySquare(new Coordinates(file, rank));
                } else {
                    line += getPiecesSprite(board.getPiece(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark) {
        // format = background color +font color + text
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result;
    }

    private String getSpriteFotEmptySquare(Coordinates coordinates) {
        return colorizeSprite("    ", Color.WHITE, Board.isSquareDark(coordinates));
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "♟";

            case "King":
                return "♔";

            case "Knight":
                return "♘";

            case "Rock":
                return "♖";

            case "Queen":
                return "♕";

            case "Bishop":
                return "♝";

        }
        return "";
    }

    private String getPiecesSprite(Piece piece) {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSquareDark(piece.coordinates));
    }
}
