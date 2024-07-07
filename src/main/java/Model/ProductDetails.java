package Model;

public class ProductDetails {

    private String productName;
    private String productSize;
    private String productColour;
    private String productSubtotal;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }

    public String getProductSubtotal() {
        return productSubtotal;
    }

    public void setProductSubtotal(String productSubtotal) {
        this.productSubtotal = productSubtotal;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productName='" + productName + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productColour='" + productColour + '\'' +
                ", productSubtotal='" + productSubtotal + '\'' +
                '}';
    }
}
