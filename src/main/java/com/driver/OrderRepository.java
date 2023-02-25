package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    Map<String,Order> oid = new HashMap<>();
    Map<String,DeliveryPartner> pid = new HashMap<>();
    Map<String,String> poid =new HashMap<>();

    public void addo(Order order){
        oid.put(order.getId(),order);
    }

    public void addp(DeliveryPartner partner){
        pid.put(partner.getId(),partner);
    }

    public void assignpartner(String ido, String ids){
        poid.put( ids,ido);
    }

    public Order getOrder(String oids){
        return oid.get(oids);
    }

    public DeliveryPartner getPartner(String pids){
        return pid.get(pids);
    }

    public Order getOrderPartner(String pids){
        return oid.get(pid.get(pids));
    }
    public int nPartner(String pid){
        return poid.get(pid).length();
    }

//    public List<String> allpOrder(String pid){
//        List<String> arList = new ArrayList<String>(poid.get(pid));
//
//        return arList;
//    }

    public List<String> allOrder(){
        List<String> list = new ArrayList<>();
        for(String key: oid.keySet()){
            list.add(key);
        }
        return list;
    }

    public int notAssign(){
        return oid.size()-poid.size();
    }

    public void Dunassign(String pids){
        poid.remove(pid);
        pid.remove(pids);
    }

    public void DOrder(String oids){
        oid.remove(oids);

    }
}
