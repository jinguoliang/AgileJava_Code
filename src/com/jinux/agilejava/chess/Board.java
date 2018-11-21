package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import com.jinux.agilejava.utils.StringUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * a chess board we can play on it
 */
public class Board {
    public static final int COLUMN_COUNT = 8;
    public static final int ROW_COUNT = COLUMN_COUNT;
    public static final int LAST_INDEX = COLUMN_COUNT - 1;
    public static final int SECOND_INDEX = 1;
    public static final int SCORE_PAWN = 1;
    public static final float SCORE_PAWN_WHEN_HAVE_OTHER_PAWN_IN_SAME_COLUMN = 0.5f;
    public static final float SCORE_ROOK = 5;
    public static final float SCORE_QUEEN = 9;
    public static final float SCORE_BISHOP = 3;
    public static final float SCORE_KNIGHT = 2.5f;
    public static final float SCORE_ZERO = 0;
    public static final int FIRST_ROW_INDEX = 0;
    private static final int SECOND_LAST_INDEX = LAST_INDEX - 1;

    private List<List<Piece>> mPieces = new ArrayList<>();

    private boolean isInvert = false;
    private EnumMap<Piece.Type, Float> scoreMap;

    Board() {
        initWithBlankPiece();
    }

    private void initWithBlankPiece() {
        IntStream.range(0, ROW_COUNT).forEach(i -> mPieces.add(createSpaceRow()));
    }

    public void initialize() {
        List<Piece> mRow1 = mPieces.get(FIRST_ROW_INDEX);
        mRow1.clear();
        mRow1.add(Piece.createWhiteRook());
        mRow1.add(Piece.createWhiteKnight());
        mRow1.add(Piece.createWhiteBishop());
        mRow1.add(Piece.createWhiteQueen());
        mRow1.add(Piece.createWhiteKing());
        mRow1.add(Piece.createWhiteBishop());
        mRow1.add(Piece.createWhiteKnight());
        mRow1.add(Piece.createWhiteRook());

        List<Piece> mRow8 = mPieces.get(LAST_INDEX);
        mRow8.clear();
        mRow8.add(Piece.createBlackRook());
        mRow8.add(Piece.createBlackKnight());
        mRow8.add(Piece.createBlackBishop());
        mRow8.add(Piece.createBlackQueen());
        mRow8.add(Piece.createBlackKing());
        mRow8.add(Piece.createBlackBishop());
        mRow8.add(Piece.createBlackKnight());
        mRow8.add(Piece.createBlackRook());

        List<Piece> mRow2 = mPieces.get(SECOND_INDEX);
        List<Piece> mRow7 = mPieces.get(SECOND_LAST_INDEX);
        IntStream.range(0, COLUMN_COUNT).forEach(i -> {
            mRow2.set(i, Piece.createWhitePawn());
            mRow7.set(i, Piece.createBlackPawn());
        });
    }

    private List<Piece> createSpaceRow() {
        return IntStream.range(0, COLUMN_COUNT)
                .mapToObj(i -> Piece.noPiece())
                .collect(Collectors.toList());
    }


    public int getPieceCount(Piece.Color color, Piece.Type type) {
        return (int) mPieces.stream().flatMap(Collection::stream)
                .filter(piece -> piece.getColor() == color
                        && piece.getType() == type)
                .count();
    }


    public String getRowToPrint(int i) {
        List<Piece> list = mPieces.get(i - 1);

        StringBuilder builder = new StringBuilder();
        list.forEach(piece -> builder.append(piece.getRepresentation()));
        return builder.toString();
    }

    public String getPrintFormat() {
        StringBuilder builder = new StringBuilder();
        for (int i = 8; i >= 1; i--) {
            builder.append(StringUtil.appendNewLine(getRowToPrint(i)));
        }
        return builder.toString();
    }

    public Piece getPieceAtPosition(String pos) {
        Position position = Position.by(pos);
        int row = getRowIndexFrom(position.getRow());
        int column = getColumnIndexFrom(position.getColumn());
        return mPieces.get(row).get(column);
    }

    private int getColumnIndexFrom(int pos) {
        return isInvert ? getInvertIndex(pos) : pos;
    }

    private int getRowIndexFrom(int pos) {
        return isInvert ? getInvertIndex(pos) : pos;
    }

    private int getInvertIndex(int index) {
        return LAST_INDEX - index;
    }

    public boolean getInvert() {
        return isInvert;
    }

    public void setInvert(boolean isInversion) {
        this.isInvert = isInversion;
    }

    public int getTotalCount() {
        return (int) mPieces.stream().flatMap(Collection::stream)
                .filter(piece -> piece.getType() != Piece.Type.NO_PIECE)
                .count();
    }

    public void setPieceAtPosition(String posStr, Piece.Color color, Piece.Type type) {
        Position position = Position.by(posStr);
        mPieces.get(position.getRow()).set(position.getColumn(), Piece.create(color, type));
    }

    public float getAllScore(Piece.Color color) {
        Optional<Float> optionalFloat = mPieces.stream()
                .flatMap(Collection::stream)
                .filter(piece -> piece.getColor() == color)
                .map(this::getPieceScore).reduce((sum, n) -> sum + n);
        float excludePawn = optionalFloat.isPresent() ? optionalFloat.get() : 0;
        return excludePawn + computePawnScore(color);
    }

    private float getPieceScore(Piece piece) {
        if (scoreMap == null) {
            loadScoreMap();
        }
        return scoreMap.get(piece.getType());
    }

    private void loadScoreMap() {
        scoreMap = new EnumMap<>(Piece.Type.class);
        scoreMap.put(Piece.Type.ROOK, SCORE_ROOK);
        scoreMap.put(Piece.Type.QUEEN, SCORE_QUEEN);
        scoreMap.put(Piece.Type.BISHOP, SCORE_BISHOP);
        scoreMap.put(Piece.Type.KNIGHT, SCORE_KNIGHT);
        scoreMap.put(Piece.Type.KING, SCORE_ZERO);
        scoreMap.put(Piece.Type.PAWN, SCORE_ZERO);
        scoreMap.put(Piece.Type.NO_PIECE, SCORE_ZERO);
    }

    float computePawnScore(Piece.Color color) {
        float score = 0;
        for (int column = 0; column < COLUMN_COUNT; column++) {
            score += computeOneColumnPawnScore(color, column);
        }
        return score;
    }

    float computeOneColumnPawnScore(Piece.Color color, int column) {
        int count = computeOneColumnPawnCount(color, column);

        if (count == 1) {
            return SCORE_PAWN;
        }
        if (count > 1) {
            return count * SCORE_PAWN_WHEN_HAVE_OTHER_PAWN_IN_SAME_COLUMN;
        }
        return 0;
    }

    int computeOneColumnPawnCount(Piece.Color color, int column) {
        int count = 0;
        for (int row = 0; row < ROW_COUNT; row++) {
            Piece piece = mPieces.get(row).get(column);
            if (piece.getType() == Piece.Type.PAWN
                    && piece.getColor() == color) {
                count++;
            }
        }
        return count;
    }
}
