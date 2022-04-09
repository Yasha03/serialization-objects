import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ProductObjectInputStream extends ObjectInputStream {
    private ObjectInputStream in;

    public ProductObjectInputStream(ObjectInputStream in) throws IOException {
        super();
        this.in = in;
    }

    public Product readProduct() throws IOException, ClassNotFoundException {
        String name = (String) in.readObject();
        boolean inStock = in.readBoolean();
        int id = in.readInt();

        return new Product(name, inStock, id);
    }
}
