package main.com.product.service;

import main.com.product.domain.Product;
import main.com.product.domain.ProductEdit;
import main.com.product.repository.ProductRepository;
import main.com.product.request.ProductCreate;
import main.com.product.request.ProductSearch;
import main.com.product.response.ProductInfo;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public void save(ProductCreate productCreate) {
        Product product = Product.builder()
                .categoryId(productCreate.getCategoryId())
                .supplierId(productCreate.getSupplierId())
                .supplierName(productCreate.getSupplierName())
                .productName(productCreate.getProductName())
                .build();

        productRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        Product product = productRepository.findById(id);
        return product;
    }

    @Override
    public List<ProductInfo> search(ProductSearch productSearch) {
        return productRepository.findProduct(productSearch);
    }

    @Override
    public void edit(Long id, ProductEdit productEdit) {
        Product product = productRepository.findById(id);
        ProductEdit.ProductEditBuilder editBuilder = product.toEditor();
        ProductEdit productEditor = editBuilder.categoryId(productEdit.getCategoryId())
                .supplierId(productEdit.getSupplierId())
                .supplierName(productEdit.getSupplierName())
                .productName(productEdit.getProductName())
                .build();
        product.edit(productEditor);
        productRepository.update(product);
    }

    @Override
    public void delete(ProductInfo productInfo) {
        productRepository.delete(productInfo.getId());
    }

    @Override
    public void delete(List<ProductInfo> productInfos) {
        List<Long> productIds = productInfos.stream().map(ProductInfo::getId).collect(Collectors.toList());
        productRepository.delete(productIds);
    }
}
