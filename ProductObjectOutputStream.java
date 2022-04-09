import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ProductObjectOutputStream extends ObjectOutputStream {
    private ObjectOutputStream out;

    public ProductObjectOutputStream(ObjectOutputStream out) throws IOException {
        super();
        this.out = out;
    }

    public void writeProduct(Product obj) throws IOException {
        out.writeObject(obj.getName());
        out.writeBoolean(obj.getInStock());
        out.writeInt(obj.getId());

        out.flush();
        out.close();
    }
}
