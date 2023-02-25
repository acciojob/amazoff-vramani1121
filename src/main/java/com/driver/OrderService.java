package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    public void addo(Order order){
        repo.addo(order);
    }

    public void addp(DeliveryPartner partner){
        repo.addp(partner);
    }

    public void assignpartner(String order, String partner){
        repo.assignpartner(order,partner);
    }

    public Order getOrder(String oids){
        return repo.getOrder(oids);
    }

    public DeliveryPartner getPartner(String pids){
        return repo.getPartner(pids);
    }

    public int nPartner(String pid){
        return repo.nPartner(pid);
    }

//    public List<String> allpOrder(String pid){
//        List<String> arList = new ArrayList<String>(poid.get(pid));
//
//        return arList;
//    }
public Order getOrderPartner(String pids){
    return repo.getOrderPartner(pids);
}

    public List<String> allOrder(){

        return repo.allOrder();
    }

    public int notAssign(){
        return repo.notAssign();
    }

    public void Dunassign(String pids){
        repo.Dunassign(pids);
    }

    public void DOrder(String oids){
        repo.DOrder(oids);

    }
}
