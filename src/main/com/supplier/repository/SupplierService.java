package main.com.supplier.repository;

import java.util.List;
import main.com.supplier.domain.Supplier;
import main.com.supplier.domain.SupplierDAO;

public interface SupplierService {
	
	public void setSup(SupplierDAO sup);
	public List<Supplier> findAll();
	int insert(Supplier supllier);
    void update(Supplier supllier);
    int delete(long id);
}
