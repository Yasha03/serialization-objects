import java.io.IOException;
import java.io.OutputStream;

public class ProductOutputStream extends OutputStream {
    private OutputStream out;

    public ProductOutputStream(OutputStream out){
        this.out = out;
    }

    public void writeProduct(Product obj) throws IOException {
        writeString(obj.getName());
        writeBoolean(obj.getInStock());
        writeInt(obj.getId());

        out.flush();
        out.close();
    }

    private void writeString(String str) throws IOException {
        writeInt(str.length());
        for (int i = 0; i < str.length(); i++) {
            writeChar(str.charAt(i));
        }
    }

    private void writeChar(char ch) throws IOException {
        out.write(ch >> 8);
        out.write(ch >> 0);
    }

    private void writeInt(int num) throws IOException {
        for (int i = 24; i >= 0; i -= 8) {
            out.write(num >> i);
        }
    }

    private void writeBoolean(boolean value) throws IOException {
        out.write(value ? 1 : 0);
    }



    @Override
    public void write(int b) throws IOException {

    }
}
