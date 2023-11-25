package menu.enumeration;

public enum CategoryType {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private int num;
    private String category;

    CategoryType(int num, String category) {
        this.num = num;
        this.category = category;
    }

    public int getNum() {
        return num;
    }

    public String getCategory() {
        return category;
    }
}
