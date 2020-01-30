public class Card {
    private Airplane top;
    private Airplane right;
    private Airplane bottom;
    private Airplane left;

    public Card(Airplane top, Airplane right, Airplane bottom, Airplane left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public Airplane getTop() {
        return top;
    }

    public void setTop(Airplane top) {
        this.top = top;
    }

    public Airplane getRight() {
        return right;
    }

    public void setRight(Airplane right) {
        this.right = right;
    }

    public Airplane getBottom() {
        return bottom;
    }

    public void setBottom(Airplane bottom) {
        this.bottom = bottom;
    }

    public Airplane getLeft() {
        return left;
    }

    public void setLeft(Airplane left) {
        this.left = left;
    }

    public Card rotated90DegreesToRight() {
        return new Card(this.left, this.top, this.right, this.bottom);
    }

    public Card clone() {
        return new Card(top, right, bottom, left);
    }

    @Override
    public String toString() {
        return "Card{" +
                "top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                ", left=" + left +
                '}';
    }
}
