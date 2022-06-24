public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardExcepition("O tabuleiro deve ter ao menos 1 row e/ou 1 coluna");
        } else {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
        }
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position)){
            throw new BoardExcepition("Está posição não existe no tabuleiro");
        }
        return piece(position) != null;
    }

    public void PlacePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)){
            throw new BoardExcepition("Existe uma peça nesta posição");
        }
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
    }

    public Piece piece(Position position) {
        if(!positionExists(position)){
            throw new BoardExcepition("Está posição não existe no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)){
            throw new BoardExcepition("Está posição não existe no tabuleiro");
        }
        return pieces[row][column];
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardExcepition("Posição não existe");
        }
        if(piece(position) == null){
            return null;
        }

        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
