import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private boolean inStock;
    private int id;

    public Product(String name, boolean inStock, int id) {
        this.name = name;
        this.inStock = inStock;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean getInStock() {
        return inStock;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", inStock=" + inStock +
                ", id=" + id +
                '}';
    }
}
