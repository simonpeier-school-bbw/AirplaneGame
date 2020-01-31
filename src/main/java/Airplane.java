public class Airplane {
    private String color;
    private boolean isBack;

    public Airplane(String color, boolean isBack) {
        this.color = color;
        this.isBack = isBack;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBack() {
        return isBack;
    }

    public void setBack(boolean back) {
        isBack = back;
    }

    @Override
    public String toString() {
        String part;
        if (isBack){
            part = "back";
        }else {
            part = "front";
        }
        return color + "," + part;
    }
}
