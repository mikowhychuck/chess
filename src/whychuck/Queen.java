package whychuck;

public class Queen extends Figure {
	public Queen(boolean isMine) {
		super(isMine);
	}
	public String getSymbol() {
		return "♕";
	}
	
    public boolean move(Board board, int currentIndex, int targetIndex) {
        int currentRow = currentIndex / 8;
        int currentCol = currentIndex % 8;
        int targetRow = targetIndex / 8;
        int targetCol = targetIndex % 8;

        // Sprawdź czy ruch jest na tej samej linii poziomej, pionowej lub na przekątnej
        if (currentRow == targetRow || currentCol == targetCol || Math.abs(currentRow - targetRow) == Math.abs(currentCol - targetCol)) {
            // Sprawdź czy nie ma przeszkód na drodze
            int rowDiff = Integer.compare(targetRow, currentRow);
            int colDiff = Integer.compare(targetCol, currentCol);

            int row = currentRow + rowDiff;
            int col = currentCol + colDiff;
            while (row != targetRow || col != targetCol) {
                Cell cell = board.getCell(row * 8 + col);
                if (cell.getFigure() != null) {
                    // Istnieje przeszkoda na drodze
                    return false;
                }
                row += rowDiff;
                col += colDiff;
            }

            // Wykonaj ruch
            Figure targetFigure = board.getCell(targetIndex).getFigure();
            if (targetFigure != null && targetFigure.isMine() == isMine()) {
                // Nie można zbijać własnych figur
                return false;
            }
            board.setFigure(currentIndex, null);
            board.setFigure(targetIndex, this);
            return true;
        }

        return false; // Ruch nie jest możliwy dla Hetmana
    }

}
