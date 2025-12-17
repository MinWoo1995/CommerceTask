import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //함수에서 Product 클래스를 생성하여 상품 목록을 추가합니다.
        //Product 객체 생성을 통해 상품명, 가격, 설명, 재고수량을 세팅합니다. [키워드: new]
        //Product클래스 생성자 (String productName, double productPrice, String productInformation, int productQuantity)
        Product GalaxyS25 = new Product("Galaxy S25",1200000,"최신 안드로이드 스마트폰",50);
        Product iPhone16 = new Product("iPhone 16",1350000,"Apple의 최신 스마트폰",10);
        Product MacBookPro = new Product("MacBook Pro",2400000,"M3 칩셋이 탑재된 노트북",20);
        Product AirPodsPro = new Product("AirPods Pro",350000,"노이즈 캔슬링 무선 이어폰",80);

        //List를 선언하여 여러 Product을 추가합니다. [List<Product> products = new ArrayList<>();]
        List<Product> products = new ArrayList<>();
        products.add(GalaxyS25);
        products.add(iPhone16);
        products.add(MacBookPro);
        products.add(AirPodsPro);

        //반복문을 활용해 products를 탐색하면서 하나씩 접근합니다.
        //출력예시
        //        [ 실시간 커머스 플랫폼 - 전자제품 ]
//        1. Galaxy S25     | 1,200,000원 | 최신 안드로이드 스마트폰
//        2. iPhone 16      | 1,350,000원 | Apple의 최신 스마트폰
//        3. MacBook Pro    | 2,400,000원 | M3 칩셋이 탑재된 노트북
//        4. AirPods Pro    |   350,000원 | 노이즈 캔슬링 무선 이어폰
//        0. 종료           | 프로그램 종료
//        0 <- // 0을 입력
//
//                커머스 플랫폼을 종료합니다.
        //Product클래스 생성자 (String productName, double productPrice, String productInformation, int productQuantity)
        while(true){
            System.out.println("        [ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (int index=0; index<products.size(); index++) {
                int i = index+1;
                System.out.println(i+"."+products.get(index));
            }
            System.out.println("0. 종료           | 프로그램 종료");//7칸 띄움
            break;
        }

        Scanner scanner = new Scanner(System.in);//입력을 받기위한 스캐너생성
        String inputNum;//입력값 받는 변수
        int passInputNum;
        while (true) {
            System.out.print("메뉴 번호를 입력 해주세요 :  ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
            inputNum = scanner.nextLine();//입력 받기//첫번재 양의 정수를 입력받는다.
            boolean condition = true;//입력값 검증상태를 저장하기 위해서

            for (int i = 0; i < inputNum.length(); i++) {
                char a = inputNum.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                if (a >= '0' && a <= '9') {
                    continue;//입력값이 0부터 9사이 숫자면 통과
                }else {
                    condition = false;
                    break;
                }
            }

            if (condition == true) {
                passInputNum = Integer.parseInt(inputNum);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                if(0< passInputNum && passInputNum <= products.size()) {
                    Product product = products.get(passInputNum-1);
                    System.out.println(product);
                }else if(passInputNum == 0){
                    System.out.println("         커머스 플랫폼을 종료합니다.");
                    System.exit(0);
                }else {//숫자이기는 하나 메뉴범위를 벗어난 번호인 경우
                    System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~"+products.size()+")");
                }
            }else{//숫자가 아닌경우
                System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~"+products.size()+")");
            }
        }
        //scanner.close();//스캐너 닫기
    }
}