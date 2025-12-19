import java.util.ArrayList;
import java.util.List;

public class Customer {
    //고객 정보를 관리하는 클래스
    //속성
    private String customerName;
    private String customerEmail;
    private String customerRating;//브론즈,실버,플레티넘,VIP 순서
    private List<Product> product =  new ArrayList<Product>();

    //생성자
    public Customer(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerRating = "브론즈";//초기 등급은 브론즈
    }

    //기능
    public String getCustomerName() {
        return customerName;
    }
    public String getcustomerEmail() {
        return customerEmail;
    }
    public String getcustomerRating() {
        return customerRating;
    }

    public void addToCart(Product product) {
        this.product.add(product);
    }
    public List<Product> getToCart() {
        return this.product;
    }
    public List<Product> getProductList() {
        return product;
    }
    public Product getProduct(int id) {
        return product.get(id);
    }
    public int getProductTotalPrice() {
        int totalPrice = 0;
        for (Product product : product) {
            product.getproductPrice();
            totalPrice += product.getproductPrice();
        }
        return totalPrice;
    }
}
