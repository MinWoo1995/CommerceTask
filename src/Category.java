import java.util.List;

public class Category {
    //Product 클래스를 관리하는 클래스
    //예시 : 전자제품, 의류, 식품 등 각 카테고리 내에 여러 Product를 포함합니다.

    //속성
    private List<Product> products;
    private String categoryName;

    //생성자
    public Category(String categoryName,List<Product> products) {
        this.products = products;
        this.categoryName = categoryName;
    }

    //기능
    public String getCategoryName() {
        return this.categoryName;
    }
    public Product getProductsItem(int i) {
        return this.products.get(i);
    }
    public List<Product> getProducts() {
        return this.products;
    }
}
