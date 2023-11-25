package menu.enumeration;

public enum MenuType {
    GYUDON(CategoryType.JAPANESE, "규동"),
    UDONG(CategoryType.JAPANESE, "우동"),
    MISO_SIRU(CategoryType.JAPANESE, "미소시루"),
    SUSHI(CategoryType.JAPANESE, "스시");

    private CategoryType category;
    private String menu;

    MenuType(CategoryType category, String menu) {
        this.category = category;
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public CategoryType getCategory() {
        return category;
    }
}
