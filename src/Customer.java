import java.util.ArrayList;
import java.util.List;

public class  Customer {
    //고객 정보를 관리하는 클래스
    //속성
    private String customerName;
    private String customerEmail;
    private List<Product> product =  new ArrayList<Product>();

    private Rating customerRating;//브론즈,실버,플레티넘,VIP 순서
    private double customerDiscount;

    public enum Rating{
        //enum 정의(속성)
        BRONZE(0.0),
        SILVER(0.05),
        GOLD(0.1),
        PLATINUM(0.15);

        private final double rate;


        //생성자
        Rating(double rate) {
            this.rate = rate;
        }

        //기능
        public double getRate() {
            return rate;
        }

    }




    //생성자
    public Customer(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerRating = Rating.BRONZE;//초기 등급은 브론즈
    }

    //기능
    public String getCustomerName() {
        return customerName;
    }
    public String getcustomerEmail() {
        return customerEmail;
    }
    public Rating getcustomerRating() {
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
    public Rating getCustomerRating() {
        return customerRating;
    }
    public void setCustomerRating(Rating rating) {
        this.customerRating = rating;
    }
}
