package main.com.supplier.service;

import java.util.List;
import main.com.supplier.domain.Supplier;
import main.com.supplier.repository.SupplierDAO;

public interface SupplierService {
	
	public void setSup(SupplierDAO supplierDao);
	public List<Supplier> supplierFindAll(Supplier supplier);
	int insert(Supplier supllier);
    void update(Supplier supllier);
    int delete(long id);
}
