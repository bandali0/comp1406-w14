public class Seat {
    public static int[] PRICING = { 74, 47, 32, 19 };

    private byte section;
    private char row;
    private byte number;
    private boolean selected;

    public Seat(byte s, char r, byte n) {
        section = s;
        row = r;
        number = n;
    }

    public byte getSection() { return section; }
    public char getRow() { return row; }
    public byte getNumber() { return number; }
    public int getPrice() { return PRICING[section - 1]; }
    public boolean isSelected() { return selected; }
    public void setSelected(boolean s) { selected = s; }
}
