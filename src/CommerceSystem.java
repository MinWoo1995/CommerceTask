import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    //프로그램 비즈니스 로직 클래스
    //설명: 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스입니다.[사용자 입력][상품 관리?]
    //Product를 관리하는 리스트가 필드로 존재합니다.[Product를 여기서 접근]
    //main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리합니다.[CommerceSystem.start()]
    //List<Product> products 는 CommerceSystem 클래스 생성자를 통해 값을 할당합니다.[main에서 생성한 List<Product> products를 CommerceSystem에 주입]
    //CommerceSystem 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.[main에서 CommerceSystem접근 하여 Product를관리]


    //속성
    //products를 저장할 배열 선언
    private List<Product> products;
    //그외 필요한 클래스 변수 선언
    Scanner scanner = new Scanner(System.in);//입력을 받기위한 스캐너생성

    //생성자
    //3.main에서 주입받은 products 객체를 받아 배열에 저장
    public CommerceSystem(List<Product> products){
        this.products = products;//받아온 리스트 배열을 통째로 List<Product>에 저장
    }

    //기능
    //1.Product 접근
    //2.입력과 로직을 반복하는 start
    public void start(){
        System.out.println("        [ 실시간 커머스 플랫폼 - 전자제품 ]");
        for (int index=0; index<this.products.size(); index++) {
            int i = index+1;
            System.out.println(i+"."+this.products.get(index));
        }
        System.out.println("0. 종료           | 프로그램 종료");

        String inputNum;//입력값 받는 변수
        int passInputNum;//검증이 끝난 입력값 저장 변수
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
                    Product product = this.products.get(passInputNum-1);
                    System.out.println(product);
                }else if(passInputNum == 0){
                    System.out.println("         커머스 플랫폼을 종료합니다.");
                    System.exit(0);
                }else {//숫자이기는 하나 메뉴범위를 벗어난 번호인 경우
                    System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~"+this.products.size()+")");
                }
            }else{//숫자가 아닌경우
                System.out.println("0을 포함한 해당되는 메뉴의 번호만 입력하세요.(0~"+this.products.size()+")");
            }
        }
    }
}
