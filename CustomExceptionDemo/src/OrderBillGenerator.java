import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderBillGenerator {
public  static void main(String[] args) {
    String quantityText = "5";
    String priceText = "250";

    try {
        try {
            int quantity = Integer.parseInt(quantityText);
            double price = Double.parseDouble(priceText);

            double total = quantity * price;
            File file=new File("bill.txt");
            System.out.println(" file path "+file.getAbsolutePath());
            FileWriter writer = new FileWriter(file);
            writer.write("Total Bill amount : " + total);
            writer.close();
            System.out.println(" Bill generated");
        } catch (NumberFormatException e) {
            System.out.println(" Invalid Quantity or Price entered");
        }
    } catch (IOException e) {
        System.out.println("Error while writing the file");

    }
}
}
