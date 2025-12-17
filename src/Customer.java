public class Customer {
    //고객 정보를 관리하는 클래스
    //속성
    private String customerName;
    private String customerEmail;
    private String customerRating;

    //생성자
    public Customer(String customerName, String customerEmail, String customerRating) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerRating = customerRating;
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
}
