import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Product product1 = new Product("potato", true, 23423);
        final String path = "C:\\Users\\User\\Desktop\\2\\text.txt";

        ProductObjectOutputStream objectOut = new ProductObjectOutputStream(
                new ObjectOutputStream(
                        new FileOutputStream(path)
                )
        );

        ProductObjectInputStream objectIn = new ProductObjectInputStream(
                new ObjectInputStream(
                        new FileInputStream(path)
                )
        );

        objectOut.writeProduct(product1);
        System.out.println(objectIn.readProduct());

        ProductOutputStream productOut = new ProductOutputStream(
                new FileOutputStream(path)
        );

        ProductInputStream productInt = new ProductInputStream(
                new FileInputStream(path)
        );

        productOut.writeProduct(product1);
        System.out.println(productInt.readProduct());
    }
}
