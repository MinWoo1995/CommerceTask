import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public boolean addToCartMethod(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        Product product=null;
        //장바구니 추가 로직
        boolean isGoback = false;
        while(true) {
            String inputNum2;//입력값 받는 변수
            int passInputNum;//검증이 끝난 입력값 저장 변수

            System.out.print("상품 또는 메뉴 번호를 입력 해주세요 :  ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
            inputNum2 = scanner.nextLine();//입력 받기//첫번재 양의 정수를 입력받는다.
            boolean condition = true;//입력값 검증상태를 저장하기 위해서
            System.out.println("");

            for (int i = 0; i < inputNum2.length(); i++) {
                char a = inputNum2.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                if (a >= '0' && a <= '9') {
                    continue;//입력값이 0부터 9사이 숫자면 통과
                } else {
                    condition = false;
                    break;
                }
            }

            if (condition == true) {
                passInputNum = Integer.parseInt(inputNum2);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                if (0 < passInputNum && passInputNum <= products.size()) {//해당 products의 사이즈범위내 숫자를 입력받기
                    product = products.get(passInputNum - 1);//인덱스 값으로 접근하여 선택한 상품 꺼내기
                    System.out.print("선택한 상품: ");//출력하기
                    //[문제] toString 와 특정 상품의 별개로 원하는 정보를 출력하고 싶었으나, print나 println을 안됨
                    //[해결]printf를 사용하여 해결
                    System.out.printf("%s | %,10d원 | %s | 재고: %d개%n", product.getProductName(), product.getproductPrice(), product.getproductInformation(), product.getproductQuantity());//출력하기
                    System.out.println("");
                    System.out.println("");
                    break;
                } else if (passInputNum == 0) {//0이면 뒤로가기
                    isGoback = true;
                    break;
                } else {//숫자이기는 하나 메뉴범위를 벗어난 번호인 경우
                    System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~" + products.size() + ")");
                    System.out.println("");
                }
            } else {//숫자가 아닌경우
                System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~" + products.size() + ")");
                System.out.println("");
            }
        }
        if(isGoback == true){
            return true;
        }
        while(true){
            String inputNum3;//입력값 받는 변수
            int passInputNum3;//검증이 끝난 입력값 저장 변수
            System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");
            System.out.print("답변을 입력해주세요 :  ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
            inputNum3 = scanner.nextLine();//입력 받기//첫번재 양의 정수를 입력받는다.
            boolean condition3 = true;//입력값 검증상태를 저장하기 위해서
            System.out.println("");
            System.out.println("");

            for (int i = 0; i < inputNum3.length(); i++) {
                char a = inputNum3.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                if (a >= '0' && a <= '9') {
                    continue;//입력값이 0부터 9사이 숫자면 통과
                } else {
                    condition3 = false;
                    break;
                }
            }
            if (condition3 == true) {
                passInputNum3 = Integer.parseInt(inputNum3);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                if(passInputNum3 == 1) {//1번 입력시 장바구니에 추가 하였다고 출력
                    if(product.getproductQuantity() <= 0){
                        System.out.printf("%s의 재고가 부족합니다.",product.getProductName());
                        System.out.println("");
                        break;
                    }
                    this.addToCart(product);//주문상품을 고객클래스에 저장
                    System.out.printf("%s",product.getProductName());
                    System.out.print("가 장바구니에 추가되었습니다.");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    isGoback = true;
                    break;
                }else if(passInputNum3 == 2){//2이면 뒤로가기
                    isGoback = true;
                    break;
                }else {//숫자이기는 하나 메뉴범위를 벗어난 번호인 경우
                    System.out.println("1과 2 둘중 하나의 번호만 입력해주세요.");
                    System.out.println("");
                }
            }else{//숫자가 아닌경우
                System.out.println("1과 2 둘중 하나의 번호만 입력해주세요.");
                System.out.println("");
            }
        }
        if(isGoback == true){
            return true;
        }
        return  true;
    }
}
