package com.jinux.agilejava.chess.pieces;

public class Piece {

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';
    public static final char BLANK_REPRESENTATION = '.';

    private Color mColor;
    private Type type;

    private Piece(Color color, Type type) {
        this.mColor = color;
        this.type = type;
    }

    public static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    public static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece noPiece() {
        return new Piece(Color.WHITE, Type.NO_PIECE);
    }

    public static Piece create(Color color, Type type) {
        return new Piece(color, type);
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
            return type.representation;
        } else {
            return Character.toUpperCase(type.representation);
        }
    }

    public Color getColor() {
        return mColor;
    }

    public enum Color {WHITE, BLACK}

    public enum Type {
        ROOK(ROOK_REPRESENTATION),
        BISHOP(BISHOP_REPRESENTATION),
        KNIGHT(KNIGHT_REPRESENTATION),
        KING(KING_REPRESENTATION),
        QUEEN(QUEEN_REPRESENTATION),
        PAWN(PAWN_REPRESENTATION),
        NO_PIECE(BLANK_REPRESENTATION);
        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }
    }
}
