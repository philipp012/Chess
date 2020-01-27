public class MoveResponse {
    private boolean valid;
    private boolean castlingKing;
    private boolean castlingQueen;
    private boolean enPassant;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isCastlingKing() {
        return castlingKing;
    }

    public void setCastlingKing(boolean castlingKing) {
        this.castlingKing = castlingKing;
    }

    public boolean isCastlingQueen() {
        return castlingQueen;
    }

    public void setCastlingQueen(boolean castlingQueen) {
        this.castlingQueen = castlingQueen;
    }

    public boolean isEnPassant() {
        return enPassant;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }
}
