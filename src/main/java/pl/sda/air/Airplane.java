package pl.sda.air;

public class Airplane {
    final static int LIMIT = 1000000;
    private final String name;
    private int height;

    public Airplane(String name, int height) {
        if (height >= 0 && height <= LIMIT) {
            this.height = height;
        } else if (height < 0) {
            this.height = 0;
        } else {
            this.height = LIMIT;
        }
        this.name = name;
    }

    public void ascent(int value) {
        if (value + this.height < 0) {
            this.height = 0;
        } else {
            this.height = Math.min(value + this.height, LIMIT);
        }
    }

    public void descent(int value) {
        // alt + enter on ? to replace with a normal if
        if (this.height - value > LIMIT) {
            this.height = LIMIT;
        } else {
            this.height = value <= this.height ? this.height - value : 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
