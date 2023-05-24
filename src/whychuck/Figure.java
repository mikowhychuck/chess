package whychuck;

public abstract class Figure {

	public boolean wasMoved;
	
	private boolean isMine;

    public Figure(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isMine() {
        return isMine;
    }

    //public abstract String toString();
    public abstract boolean move(Board board, int currentIndex, int targetIndex);
    public abstract String getSymbol();

}
