package Chess.piece;

import Chess.Coordinates;
import Chess.Color;

public abstract class Piece {
    public Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
