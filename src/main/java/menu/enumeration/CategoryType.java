package menu.enumeration;

public enum CategoryType {
    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

    private int num;

    CategoryType(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
