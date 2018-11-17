package com.jinux.agilejava.chess.pieces;

public class Piece {

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';

    private Color mColor;
    private Character representation;
    private Type type;

    private Piece(Color color, Type type, char representation) {
        this.mColor = color;
        this.type = type;
        this.representation = representation;
    }

    public static Piece createWhite(Type type, char representation) {
        return new Piece(Color.WHITE, type, representation);
    }

    public static Piece createBlack(Type type, char representation) {
        return new Piece(Color.BLACK, type, representation);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK, ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK, ROOK_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT, KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT, KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP, BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP, BISHOP_REPRESENTATION);
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN, PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN, PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING, KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING, KING_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN, QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN, QUEEN_REPRESENTATION);
    }

    public static Piece noPiece() {
        return new Piece(Color.WHITE, Type.NO_PIECE, '.');
    }

    public boolean isWhite() {
        return mColor == Color.WHITE;
    }

    public boolean isBlack() {
        return mColor == Color.BLACK;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        if (mColor == Color.WHITE) {
            return representation;
        } else {
            return Character.toUpperCase(representation);
        }
    }

    public Color getColor() {
        return mColor;
    }

    public enum Color {WHITE, BLACK}

    public enum Type {
        ROOK, BISHOP, KNIGHT, KING, QUEEN, NO_PIECE, PAWN
    }
}
