package main.com.sales.service;

import main.com.client.dao.ClientDAO;
import main.com.config.MySqlSessionFactory;
import main.com.product.domain.Product;
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

    public SalesServiceImpl(ProductRepository productRepository, ClientDAO clientDAO, SalesRepository salesRepository) {
        this.productRepository = productRepository;
        this.clientDAO = clientDAO;
        this.salesRepository = salesRepository;
    }

    @Override
    public List<ProductSalesInfo> getProductSales(SalesSearch salesSearch) {
        List<ProductSales> productSales = salesRepository.findByProduct(salesSearch);
        String productName = salesSearch.getProductName();
        Product product = productRepository.findByName(productName);

        List<ProductSalesInfo> salesInfos = productSales.stream()
                .map(sales -> new ProductSalesInfo(sales.getProductId(), productRepository.findById(sales.getProductId()).getProductName()
                        , null, sales.getTotalPrice()))
                .collect(Collectors.toList());
        return salesInfos;
    }

    @Override
    public List<ClientSalesInfo> getClientSales(SalesSearch salesSearch) {
        List<ClientSales> productSales = salesRepository.findByClient(salesSearch);
        SqlSession sqlSession = MySqlSessionFactory.openSession();
        List<ClientSalesInfo> salesInfos = productSales.stream()
                .map(sales -> new ClientSalesInfo(sales.getClientId(), ClientDAO.findById(sales.getClientId()).getCompany_name()
                        , null, sales.getTotalPrice()))
                .collect(Collectors.toList());
        return salesInfos;
    }
}
