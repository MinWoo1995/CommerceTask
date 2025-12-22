프로젝트명 : 커머스 과제 : Java를 활용하여 커머스의 역할을 수행하는 콘솔 기반 커머스 구현 프로젝트입니다. 

주요기능 : 상품목록 출력, 상품추가, 상품삭제, 장바구니 시스템, 관리자 시스템,프로그램을 종료할지 선택 

구현목표 : 
STEP1 객체 지향 설계를 적용해 상품 관리 시스템을 프로그래밍해보자
1. 상품 목록 출력
2. 상품의 정보를 가지고 있는 Product 클래스 생성하기
3. main 함수에서 Product 클래스를 생성하여 상품 목록을 추가합니다.
STEP2 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
4. CommerceSystem 클래스 생성하기
STEP3 객체 지향 설계를 적용해 상품 카테고리와 고객 관리를 클래스 기반으로 관리하기
5. Category 클래스 생성하기
6. Customer 클래스 생성하기
STEP4 캡슐화 적용하기
7. Product, Category, Customer 그리고 CommerceSystem 클래스의 필드에 직접 접근하지 못하도록 설정합니다.
8. Getter와 Setter 메서드를 사용해 데이터를 관리합니다.
도전 기능
레벨1 장바구니 및 주문하기 기능을 추가하기
9. 장바구니 생성 및 관리 기능
10. 재고 관리 시스템
11. 장바구니 출력 및 금액 계산
12. 장바구니 담기 기능
13. 주문 기능
레벨2 관리자 모드 추가
14. 관리자 인증 기능
15. 상품 추가 기능
16. 상품 수정 기능
17. 상품 삭제 기능
레벨3 Enum, 람다 & 스트림을 활용한 고급 관리 기능
18. Enum을 활용한 고객 등급별 할인율 관리하기
19. 람다 & 스트림을 활용한 상품 검색 및 관리 기능
20. 장바구니에서 특정 상품 제거 기능

기술스택 : Java 17 실행방법 : 로컬에서 구동

classDiagram class Main {

main() } 

class CommerceSystem(List<Category> category,Customer  customer,String ADMIN_PASSWORD,List<Customer> customers) 
start()}

class Customer(String customerName, String customerEmail){
public boolean addToCartMethod(List<Product> products)}

class Category(String categoryName,List<Product> products){}

class Product(String productName, int productPrice, String productInformation, int productQuantity){}


Main-->CommerceSystem(Customer)-->Category-->Product