package main.com.sales.service;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;
import main.com.config.MySqlSessionFactory;
import main.com.product.domain.Category;
import main.com.product.domain.Product;
import main.com.product.repository.CategoryRepository;
import main.com.product.repository.ProductRepository;
import main.com.sales.dto.ClientSales;
import main.com.sales.dto.ProductSales;
import main.com.sales.repository.SalesRepository;
import main.com.sales.request.SalesSearch;
import main.com.sales.response.ClientSalesInfo;
import main.com.sales.response.ProductSalesInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

public class SalesServiceImpl implements SalesService{
    private final ProductRepository productRepository;
    private final ClientDAO clientDAO;
    private final SalesRepository salesRepository;
    private final CategoryRepository categoryRepository;

    public SalesServiceImpl(ProductRepository productRepository, ClientDAO clientDAO, SalesRepository salesRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.clientDAO = clientDAO;
        this.salesRepository = salesRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductSalesInfo> getProductSales(Long productId,String productName ,String start,String end) {
        SalesSearch salesSearch =SalesSearch.builder()
                .productId(productId)
                .productName(productName)
                .startDate(start)
                .endDate(end)
                .build();
        List<ProductSales> productSales = salesRepository.findByProduct(salesSearch);
        List<ProductSalesInfo> salesInfos = productSales.stream()
                .map(sales -> {
                    Product findProduct = productRepository.findById(sales.getProductId());
                    Category category = categoryRepository.findById(findProduct.getCategoryId());
                    return new ProductSalesInfo(sales.getProductId(), productRepository.findById(sales.getProductId()).getProductName()
                            , category.getCategoryName(), sales.getTotalPrice());
                })
                .collect(Collectors.toList());
        return salesInfos;
    }

    @Override
    public List<ClientSalesInfo> getClientSales(Long clientId,String clientName,String start,String end) {
        SqlSession sqlSession = MySqlSessionFactory.openSession();

        SalesSearch salesSearch = SalesSearch.builder()
                .clientName(clientName)
                .clientId(clientId)
                .startDate(start)
                .endDate(end)
                .build();
        List<ClientSales> clientSales = salesRepository.findByClient(salesSearch);

        return clientSales.stream()
                .map(sales -> {
                    ClientDTO client = clientDAO.findById(sqlSession, (int) (long) sales.getClientId());
                    return new ClientSalesInfo(sales.getClientId(), client.getCompany_name()
                            ,client.getCategory() , sales.getTotalPrice());
                })
                .collect(Collectors.toList());
    }
}
