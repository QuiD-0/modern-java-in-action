package flowAPI;

public record TempInfo(
    String town,
    Integer temp
) {
    public static TempInfo fetch(String town) {
        return new TempInfo(town, (int) (Math.random() * 100));
    }
}
