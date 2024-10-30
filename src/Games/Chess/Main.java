package Games.Chess;



public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
        board.setupDefaultPiecesPosition();
        boardConsoleRenderer.render(board);
    }
}
