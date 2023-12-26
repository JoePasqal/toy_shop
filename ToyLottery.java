import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyLottery {
    private List<Toy> toys = new ArrayList<>();
    private List<Toy> prizeToys = new ArrayList<>(); // Список призовых игрушек

    // ... (остальные методы остаются без изменений)

    public void drawAndAddToPrizeList() {
        Toy prizeToy = drawToy();
        if (prizeToy != null) {
            prizeToys.add(prizeToy);
            System.out.println("Призовая игрушка добавлена: " + prizeToy);
        } else {
            System.out.println("Игрушки для розыгрыша не найдены!");
        }
    }

    public void giveOutPrize() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            System.out.println("Призовая игрушка выдана: " + prizeToy);
            saveToyToFile(prizeToy);
        } else {
            System.out.println("Нет призовых игрушек для выдачи!");
        }
    }

    private void saveToyToFile(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(toy.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyLottery lottery = new ToyLottery();
        // ... (добавление игрушек)

        lottery.drawAndAddToPrizeList(); // Розыгрыш и добавление в список призов
        lottery.giveOutPrize(); // Выдача призовой игрушки
    }
}
