public class ChessMatch {
    private Board board;

    public ChessMatch(){
        board = new Board(8, 8);
        InitialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows();i++){
            for(int j = 0; j < board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("Não existe peça na posição");
        }
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targePosition){
        Position source = sourcePosition.toPosition();
        Position target = targePosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    public Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.PlacePiece(p, target);
        return capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void InitialSetup(){
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
    }
}
