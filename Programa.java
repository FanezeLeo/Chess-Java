import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();
        
        while(true){
            UI.printBoard(chessMatch.getPieces());
            ChessPosition source = UI.redChessPosition(in);

            ChessPosition target = UI.redChessPosition(in);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        }
    }
}