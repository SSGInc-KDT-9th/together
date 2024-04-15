package main.com.client.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;
import main.com.supplier.domain.Supplier;

public interface ClientService {


    public void setDao(ClientDAO dao);
    public List<ClientDTO> findAll();
    public int removeByid(int id);
    int insert(ClientDTO ClientDTO);
    void update(ClientDTO ClientDTO);
    public ClientDTO findById(int id);
    public List<ClientDTO> findByCompanyName(String companyName);
    
}