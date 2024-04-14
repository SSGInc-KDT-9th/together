package test.prodcut;

import main.com.product.domain.Category;
import main.com.product.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {
    CategoryRepository categoryRepository = new CategoryRepository();

    @Test
    @DisplayName("카테고리 저장/ID 조회 테스트")
    void test1() throws Exception {
        //given
        Category category = Category.builder()
                .categoryName("빙과류")
                .parentCategoryId(1L)
                .build();
        Long saveId = categoryRepository.save(category);
        //when
        Category expect = categoryRepository.findById(saveId);
        categoryRepository.delete(category.getCategoryId());
        //then
        Assertions.assertEquals(expect.getCategoryName(),category.getCategoryName()
        );
    }

    @Test
    @DisplayName("카테고리 이름 자식 부모 조회 테스트")
    void test2() throws Exception {
        //given
        List<Category> parent = categoryRepository.findParent();
        List<Category> child = categoryRepository.findChild();
        //when
        Category parentCategory = parent.get(0);
        Category childCategory = child.get(0);
        //then
        Assertions.assertNull(parentCategory.getParentCategoryId());
        Assertions.assertNotNull(childCategory.getParentCategoryId());
    }

    @Test
    void test3() throws Exception {
        //given
        Category category = Category.builder()
                .categoryName("테스트 카테고리 1")
                .parentCategoryId(1L).build();
        Long save = categoryRepository.save(category);
        //when

        //categoryRepository.update()
        //then

    }
}