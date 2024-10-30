package Games.Chess.piece;

import Games.Chess.Coordinates;
import Games.Chess.Color;

public abstract class Piece {
    public Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
