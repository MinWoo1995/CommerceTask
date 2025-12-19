public class Product {
    //개별 상품 정보를 가지는 클래스
    //상품명, 가격, 설명, 재고수량
    //예시: Galaxy S24, 1200000, 최신 스마트폰, 50
    //new Product("Galaxy S24", 1200000, "최신 스마트폰", 50)

    //속성
    private String productName;
    private int productPrice;
    private String productInformation;
    private int productQuantity;

    //생성자
    public Product(String productName, int productPrice, String productInformation, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInformation = productInformation;
        this.productQuantity = productQuantity;
    }


    //기능
    //상품 수정(세터)
    public void setProductName(String productName) {
        this.productName=productName;
    }
    public void setproductPrice(int productPrice) {
        this.productPrice=productPrice;
    }
    public void setproductInformation(String productInformation) {
        this.productInformation=productInformation;
    }
    public int setproductQuantity() {
        this.productQuantity=this.productQuantity-1;
        return productQuantity;
    }
    public void setproductQuantity2(int productQuantity) {
        this.productQuantity=productQuantity;
    }
    //상품 정보 출력(게터)
    public String getProductName() {
        return productName;
    }
    public int getproductPrice() {
        return productPrice;
    }
    public String getproductInformation() {
        return productInformation;
    }
    public int setProductQuantity(int i) {
        this.productQuantity=productQuantity-i;
        return productQuantity;
    }
    public int getproductQuantity() {
        return productQuantity;
    }


    @Override
    public String toString() {//출력시 원하는 출력값을 위해서 출력 양식 설정
        return String.format("%s | %,10d원 | %s",productName, productPrice, productInformation);
    }
}
