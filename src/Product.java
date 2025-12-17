public class Product {
    //개별 상품 정보를 가지는 클래스
    //상품명, 가격, 설명, 재고수량
    //예시: Galaxy S24, 1200000, 최신 스마트폰, 50
    //new Product("Galaxy S24", 1200000, "최신 스마트폰", 50)

    //속성
    private String productName;
    private double productPrice;
    private String productInformation;
    private int productQuantity;

    //생성자
    public Product(String productName, double productPrice, String productInformation, int productQuantity) {
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
    public void setproductPrice(double productPrice) {
        this.productPrice=productPrice;
    }
    public void setproductInformation(String productInformation) {
        this.productInformation=productInformation;
    }
    public void setproductQuantity(int productQuantity) {
        this.productQuantity=productQuantity;
    }
    //상품 정보 출력(게터)
    public String getProductName() {
        return productName;
    }
    public double getproductPrice() {
        return productPrice;
    }
    public String getproductInformation() {
        return productInformation;
    }
    public int getproductQuantity() {
        return productQuantity;
    }

    @Override
    public String toString() {//출력시 원하는 출력값을 위해서 출력 양식 설정
        // %,.0f: 천 단위 콤마 추가, 소수점은 표시 안 함
        // %-15s: 15자리를 확보하고 왼쪽 정렬 (글자 길이에 상관없이 줄 맞춤)
        return String.format("%-15s | %,10.0f원 | %s",productName, productPrice, productInformation);
    }
}
