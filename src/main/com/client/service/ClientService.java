package main.com.client.service;

import java.util.List;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;

public interface ClientService {


    public void setDao(ClientDAO dao);
    public List<ClientDTO> findAll();
    public int removeByid(int id);



}