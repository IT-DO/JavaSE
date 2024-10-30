package Games.Chess;

import java.util.HashMap;

import Games.Chess.piece.Knight;
import Games.Chess.piece.Pawn;
import Games.Chess.piece.Piece;
import Games.Chess.piece.Rock;
import Games.Chess.piece.Bishop;
import Games.Chess.piece.King;
import Games.Chess.piece.Queen;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiece (Coordinates coordinates){
        return pieces.get(coordinates);
    }




    public void setupDefaultPiecesPosition() {
        //set pawn
        for (File file : File.values()) {
            setPiece(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPiece(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));
        }
        //set rock
            setPiece(new Coordinates(File.A,1), new Rock(Color.WHITE, new Coordinates(File.A,1)));
            setPiece(new Coordinates(File.A,8), new Rock(Color.BLACK, new Coordinates(File.A,8)));
            setPiece(new Coordinates(File.H,1), new Rock(Color.WHITE, new Coordinates(File.H,1)));
            setPiece(new Coordinates(File.H,8), new Rock(Color.BLACK, new Coordinates(File.H,8)));

        //set Knight
            setPiece(new Coordinates(File.B,1), new Knight(Color.WHITE, new Coordinates(File.B, 1)));
            setPiece(new Coordinates(File.B,8), new Knight(Color.BLACK, new Coordinates(File.B, 8)));
            setPiece(new Coordinates(File.G,1), new Knight(Color.WHITE, new Coordinates(File.G, 1)));
            setPiece(new Coordinates(File.G,8), new Knight(Color.BLACK, new Coordinates(File.G, 8)));

        //set Bishop
        setPiece(new Coordinates(File.C,1), new Bishop(Color.WHITE, new Coordinates(File.C, 1)));
        setPiece(new Coordinates(File.C,8), new Bishop(Color.BLACK, new Coordinates(File.C, 8)));
        setPiece(new Coordinates(File.F,1), new Bishop(Color.WHITE, new Coordinates(File.F, 1)));
        setPiece(new Coordinates(File.F,8), new Bishop(Color.BLACK, new Coordinates(File.F, 8)));

        //set King
        setPiece(new Coordinates(File.D,1), new King(Color.WHITE, new Coordinates(File.D, 1)));
        setPiece(new Coordinates(File.D,8), new King(Color.BLACK, new Coordinates(File.D, 8)));

        //set Queen
        setPiece(new Coordinates(File.E,1), new Queen(Color.WHITE, new Coordinates(File.E, 1)));
        setPiece(new Coordinates(File.E,8), new Queen(Color.BLACK, new Coordinates(File.E, 8)));

    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal()+1)+coordinates.rank) % 2) == 0 ? true : false;
    }
}
