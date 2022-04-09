import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ProductInputStream extends InputStream {
    private InputStream in;

    public ProductInputStream(InputStream in){
        this.in = in;
    }

    public Product readProduct() throws IOException{
        String name = readString();
        boolean inStock = readBoolean();
        int id = readInt();
        return new Product(name, inStock, id);
    }

    private String readString() throws IOException {
        String result = "";
        int lengthString = readInt();
        for (int i = 0; i < lengthString; i++) {
            result += (char) readChar();
        }
        return result;
    }

    private int readInt() throws IOException {
        int result = 0;
        for (int i = 24; i >= 0; i -= 8) {
            result |= in.read() << i;
        }
        return result;
    }

    private char readChar() throws IOException {
        char result = 0;
        result |= in.read() << 8;
        result |= in.read() << 0;
        return result;
    }

    private boolean readBoolean() throws IOException {
        return in.read() == 1;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }
}
