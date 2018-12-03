package jdbc;

public final class SQLQuery {

    public static String GET_MEAT_TITLE = "SELECT title FROM menu.meat";
    public static String GET_SOUCE_TITLE = "SELECT title FROM menu.souce";
    public static String GET_VEGETABLES_TITLE = "SELECT title FROM menu.vegetables";
    public static String SHOW_TABLES = "show tables;";
    public static String SELECT_MEAT = "SELECT title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, animal, bodyPart FROM menu.meat;";
    public static String SELECT_SOUCE = "SELECT title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, sourness, sweetness, salty FROM menu.souce;";
    public static String SELECT_VEGETABLES = "SELECT title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, type, productionType FROM menu.vegetables;";
    public static String GET_SALAD_TITLE = "SELECT title FROM menu.salad";
    public static String SELECT_MEAT_ = "SELECT title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, animal, bodyPart FROM menu.meat WHERE id = ?;";
    public static String SELECT_SOUCE_ = "SELECT title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, sourness, sweetness, salty FROM menu.souce WHERE id = ?;";
    public static String SELECT_VEGETABLES_ = "SELECT title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, type, productionType FROM menu.vegetables WHERE id = ?;";
}
