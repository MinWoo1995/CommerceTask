import java.util.*;

public class CommerceSystem {
    //프로그램 비즈니스 로직 클래스
    //설명: 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스입니다.[사용자 입력][상품 관리?]
    //Product를 관리하는 리스트가 필드로 존재합니다.[Product를 여기서 접근]
    //main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리합니다.[CommerceSystem.start()]
    //List<Product> products 는 CommerceSystem 클래스 생성자를 통해 값을 할당합니다.[main에서 생성한 List<Product> products를 CommerceSystem에 주입]
    //CommerceSystem 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.[main에서 CommerceSystem접근 하여 Product를관리]


    //속성
    //products를 저장할 배열 선언->카테고리가 상품을 관리로 변경
    private List<Category> category;
    private List<Product> products;
    Product product;//선택한 상품이 담긴 변수
    Customer  customer;//고객정보 및 장바구니 담기위해서

    //그외 필요한 클래스 변수 선언
    Scanner scanner = new Scanner(System.in);//입력을 받기위한 스캐너생성


    //생성자
    //3.main에서 주입받은 products 객체를 받아 배열에 저장
    public CommerceSystem(List<Category> category,Customer  customer){
        this.category = category;//받아온 리스트 배열을 통째로 List<Product>에 저장
        this.customer = customer;
    }

    //기능
    //1.Product 접근
    //2.입력과 로직을 반복하는 start
    public void start(){
        int categoryNumber = 0;
        while(true) {
            //어떤 카테고리를 선택할지? 정하는곳
            while (true) {
                if(!customer.getProductList().isEmpty()){//장바구니가 비어있는지 확인
                    System.out.println("아래 메뉴를 선택해주세요.");
                    System.out.println("");

                    System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
                    for (int i = 0; i < category.size(); i++) {
                        System.out.println((i + 1) + ". " + this.category.get(i).getCategoryName());
                    }
                    System.out.println("0. 종료      | 프로그램 종료");
                    System.out.println("");
                    System.out.println("[ 주문 관리 ]");
                    System.out.println("4. 장바구니 확인    | 장바구니를 확인 후 주문합니다.");
                    System.out.println("5. 주문 취소       | 진행중인 주문을 취소합니다.");

                }else{
                    System.out.println("");
                    System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
                    for (int i = 0; i < category.size(); i++) {
                        System.out.println((i + 1) + ". " + this.category.get(i).getCategoryName());
                    }
                    System.out.println("0. 종료      | 프로그램 종료");
                }

                String inputNum1;//입력값 받는 변수
                int passInputNum1;//검증이 끝난 입력값 저장 변수

                System.out.print("메뉴 번호를 입력 해주세요 :  ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
                inputNum1 = scanner.nextLine();//입력 받기//첫번재 양의 정수를 입력받는다.
                boolean condition = true;//입력값 검증상태를 저장하기 위해서
                System.out.println("");

                for (int i = 0; i < inputNum1.length(); i++) {
                    char a = inputNum1.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                    if (a >= '0' && a <= '9') {
                        continue;//입력값이 0부터 9사이 숫자면 통과
                    } else {
                        condition = false;
                        break;
                    }
                }

                if (condition == true) {
                    passInputNum1 = Integer.parseInt(inputNum1);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                    if (0 < passInputNum1 && passInputNum1 <= this.category.size()) {//카테고리 범위안에 숫자가 맞는지 검증
                        categoryNumber = passInputNum1;//통과한 입력값을 넘기기 위해 categoryNumber 저장
                        break;
                    } else if (passInputNum1 == 0) {
                        System.out.println("커머스 플랫폼을 종료합니다.");
                        System.exit(0);
                    }else if (passInputNum1 == 4) {
                        System.out.println("");
                        System.out.println("아래와 같이 주문 하시겠습니까?");
                        System.out.println("");
                        System.out.println("[ 장바구니 내역 ]");
                        Set<Product> distinctProducts = new HashSet<>(this.customer.getProductList());
                        for(Product p : distinctProducts){//장바구니 상품 출력
                            int productCount = Collections.frequency(this.customer.getProductList(), p);
                            System.out.printf("%s | %,.0f원 | %s | 수량: %d개%n", p.getProductName(), p.getproductPrice(), p.getproductInformation(), productCount);//출력하기
                        }
                        System.out.println("");
                        System.out.println("[ 총 주문 금액 ]");
                        System.out.printf("%,.0f원", this.customer.getProductTotalPrice());//총금액 출력하기
                        System.out.println("");
                        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");
                        System.out.print("메뉴 번호를 입력 해주세요 :  ");
                        while (true) {
                            String inputNum5 = scanner.nextLine();//입력 받기//첫번재 양의 정수를 입력받는다.
                            boolean condition5 = true;//입력값 검증상태를 저장하기 위해서
                            System.out.println("");
                            System.out.println("");

                            for (int i = 0; i < inputNum5.length(); i++) {
                                char a = inputNum5.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                                if (a >= '0' && a <= '9') {
                                    continue;//입력값이 0부터 9사이 숫자면 통과
                                } else {
                                    condition5 = false;
                                    break;
                                }
                            }
                            if (condition5 == true) {
                                int passInputNum5 = Integer.parseInt(inputNum5);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                                if (0 < passInputNum5 && passInputNum5 <= 2) {//카테고리 범위안에 숫자가 맞는지 검증
                                    if(passInputNum5 == 2){
                                        break;
                                    }else if(passInputNum5 == 1){
                                        System.out.print("주문이 완료되었습니다! 총 금액: ");
                                        System.out.printf("%,.0f원", this.customer.getProductTotalPrice());//총금액 출력하기
                                        System.out.println("");
                                        for(Product p : this.customer.getProductList()){
                                            int oldQuantity = p.getproductQuantity();
                                            int newQuantity = p.setProductQuantity(1);
                                            System.out.printf("%s의 재고가 %d개에서 -> %d개로 업데이트 되었습니다.%n",p.getProductName(),oldQuantity,newQuantity);//출력하기
                                        }
                                        this.customer.getProductList().clear();//장바구니 초기화
                                        break;
                                    }
                                }
                            }else{
                                System.out.println("1과 2 둘중 하나의 번호만 입력해주세요.");
                            }
                        }
                    }else if(passInputNum1 == 5){
                        System.out.println("장바구니를 비우고 주문을 취소하겠습니다");
                        this.customer.getProductList().clear();
                        System.out.println("장바구니가 초기화되었습니다.");
                    }else{//숫자이기는 하나 메뉴범위를 벗어난 번호인 경우
                        System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~" + this.category.size() + ")");
                        System.out.println("");
                    }
                } else {//숫자가 아닌경우
                    if(!this.customer.getProductList().isEmpty()){
                        System.out.println("0,4,5을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~" + this.category.size() +")");
                        System.out.println("");
                    }else{
                        System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~" + this.category.size() + ")");
                        System.out.println("");
                    }

                }
            }
            boolean isGoback= false;;
            //선택한 해당 카테고리의 상품목록을 불러오기
            while (true) {

                System.out.println("[ " + this.category.get(categoryNumber - 1).getCategoryName() + " 카테고리 ]");
                Category selectedCategory = this.category.get(categoryNumber - 1);//categoryNumber번째 카테고리 products 불러오기
                products = selectedCategory.getProducts();//불러온 해당 카테고리의 상품들을 products 객체에 담기
                for (int index = 0; index < products.size(); index++) {//해당 객체의 범위만큼만 돌도록 하기
                    int i = index + 1;
                    System.out.println(i + ". " + products.get(index));//반복문을 통해 리스트 출력
                }
                System.out.println("0. 뒤로가기");

                String inputNum2;//입력값 받는 변수
                int passInputNum;//검증이 끝난 입력값 저장 변수

                System.out.print("상품 또는 메뉴 번호를 입력 해주세요 :  ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
                inputNum2 = scanner.nextLine();//입력 받기//첫번재 양의 정수를 입력받는다.
                boolean condition = true;//입력값 검증상태를 저장하기 위해서

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
                        System.out.printf("%s | %,.0f원 | %s | 재고: %d개%n", product.getProductName(), product.getproductPrice(), product.getproductInformation(), product.getproductQuantity());//출력하기
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
                continue;
            }
            while (true) {
                String inputNum3;//입력값 받는 변수
                int passInputNum3;//검증이 끝난 입력값 저장 변수
                System.out.printf("\"%s | %,.0f원 | %s\"", product.getProductName(), product.getproductPrice(), product.getproductInformation());//출력하기
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
                        customer.addToCart(product);//주문상품을 고객클래스에 저장
                        System.out.printf("%s",product.getProductName());
                        System.out.print("가 장바구니에 추가되었습니다.");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        break;
                    }else if(passInputNum3 == 2){//2이면 뒤로가기
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
        }
    }
}
