package test.prodcut;
import main.com.product.domain.Product;
import main.com.product.domain.ProductEdit;
import main.com.product.repository.MySqlProductRepository;
import main.com.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MySqlProductRepositoryTest {
    private ProductRepository productRepository = new MySqlProductRepository();

    //@AfterEach
    void clean(){
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("상품 ID 조회 테스트")
    void test1() throws Exception {
        //given
        Product product = Product.builder()
                .productName("투게더")
                .supplierName("빙그레")
                .build();
        //when
        Long saveId = productRepository.save(product);
        Product expectProduct = productRepository.findById(saveId);
        //then
        Assertions.assertEquals(product.getId(),expectProduct.getId());
        Assertions.assertEquals(product.getProductName(),expectProduct.getProductName());
        productRepository.delete(saveId);
    }

    @Test
    @DisplayName("상품 이름 조회 테스트")
    void test2() throws Exception {
        //given
        List<Product> products = IntStream.range(1,31)
                .mapToObj(i-> Product.builder()
                        .productName("이름 " + i)
                        .build())
                .collect(Collectors.toList());

        //when
        List<Long> saveIds = productRepository.save(products);
        List<Product> expects = productRepository.findIncludeName("이름");
        productRepository.delete(saveIds);
        //then
        Assertions.assertEquals(expects.size(),30);
        Assertions.assertEquals(saveIds.get(0),expects.get(0).getId());

    }
    @Test
    @DisplayName("상품 저장 테스트")
    void test3() throws Exception {
        //given
        Product product = Product.builder()
                .productName("투게더")
                .supplierName("빙그레")
                .build();
        Long saveId = productRepository.save(product);
        //when
        Product expectProduct = productRepository.findById(saveId);
        //then
        Assertions.assertEquals(expectProduct.getId(),product.getId());
        Assertions.assertEquals(expectProduct.getProductName(),product.getProductName());
        productRepository.delete(saveId);
    }

    @Test
    @DisplayName("상품 여러개 저장 테스트")
    void test4() throws Exception {
        //given
        List<Product> products = IntStream.range(0,30)
                .mapToObj(i-> Product.builder()
                        .productName("이름 " + i)
                        .supplierName("빙그레")
                        .build())
                .collect(Collectors.toList());
        List<Long> saveIds = productRepository.save(products);
        //expect
        for(int i=0; i<products.size(); i++){
            Long id = saveIds.get(i);
            Product product = products.get(i);
            Product expectProduct = productRepository.findById(id);
            Assertions.assertEquals(expectProduct.getId(),product.getId());
            Assertions.assertEquals(expectProduct.getProductName(),product.getProductName());
            Assertions.assertEquals(expectProduct.getSupplierId(),product.getSupplierId());
        }
        productRepository.delete(saveIds);
    }

    @Test
    @DisplayName("상품 수정 테스트")
    void test5() throws Exception {
        //given
        Product product = Product.builder()
                .productName("투게더")
                .supplierName("빙그레")
                .build();
        Long saveId = productRepository.save(product);
        product = productRepository.findById(saveId);
        String change = "수정 테스트";
        //when
        ProductEdit.ProductEditBuilder editBuilder = product.toEditor();
        ProductEdit productEdit = editBuilder.productName(product.getProductName())
                .productName(change)
                .categoryId(null)
                .supplierName(product.getSupplierName())
                .build();
        product.edit(productEdit);
        Long updateId = productRepository.update(product);
        Product expect = productRepository.findById(updateId);
        productRepository.delete(updateId);
        //then
        Assertions.assertEquals(expect.getProductName(),change);
    }

    @Test
    @DisplayName("상품 저장 테스트 2")
    void test6() throws Exception {
        //given
        Product product = Product.builder()
                .supplierName("빙그레")
                .productName("테스터")
                .build();
        //when
        Long saveId = productRepository.save(product);
        Product expect = productRepository.findById(saveId);
        //then
        Assertions.assertEquals(expect.getProductName(),product.getProductName());
        Assertions.assertNotNull(expect.getSupplierId());
    }

    @Test
    @DisplayName("전체 조회 테스트")
    void test7() throws Exception {
        //given

        //when

        //then

    }
}