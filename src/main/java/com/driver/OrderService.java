package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    public void addOrder(Order order){
        repo.addOrder(order);
    }

    public void addPartner(String partnerid){
        repo.addPartner(partnerid);
    }

    public void addOrderPartnerPair(String order, String partner){
        repo.addOrderPartnerPair(order,partner);
    }

    public Order getOrderById(String oids){
        return repo.getOrderById(oids);
    }

    public DeliveryPartner getPartnerById(String pids){
        return repo.getPartnerById(pids);
    }

    public int getOrderCountByPartnerId(String pid){
        return repo.getOrderCountByPartnerId(pid);
    }

//    public List<String> allpOrder(String pid){
//        List<String> arList = new ArrayList<String>(poid.get(pid));
//
//        return arList;
//    }
public Order getOrderPartner(String pids){
    return repo.getOrderPartner(pids);
}

    public List<String> getOrdersByPartnerId(String pid){

        return repo.getOrdersByPartnerId(pid);
    }
    public List<String> getAllOrders(){
        return repo.getAllOrders();
    }

    public int getCountOfUnassignedOrders(){
        return repo.getCountOfUnassignedOrders();
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String times,String pid){
        String time[] = times.split(":");
        int ntime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);

        return repo.getOrdersLeftAfterGivenTimeByPartnerId(ntime,pid);
    }

    public String getLastDeliveryTimeByPartnerId(String pid){
        int time = repo.getLastDeliveryTimeByPartnerId(pid);
        String hh = String.valueOf(time/60);
        String mm = String.valueOf(time%60);

        if(hh.length()<2)
            hh = "0"+hh;

        if(mm.length()<2)
            mm = "0"+mm;

        return hh+":"+mm;
    }

    public void deletePartnerById(String pid){
         repo.deletePartnerById(pid);
    }

    public void deleteOrderById(String oid) {
        repo.deleteOrderById(oid);
    }
   }
