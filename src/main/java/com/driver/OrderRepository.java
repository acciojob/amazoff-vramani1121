package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    Map<String, Order> oid = new HashMap<>();
    Map<String, DeliveryPartner> pid = new HashMap<>();
    Map<String, String> opid = new HashMap<>();
    Map<String, List<String>> polist = new HashMap<>();

    public void addOrder(Order order) {
        oid.put(order.getId(), order);
    }

    public void addPartner(String partnerid) {
        pid.put(partnerid, new DeliveryPartner(partnerid));//smjo
    }

    public void addOrderPartnerPair(String ido, String ids) {
        if (opid.containsKey(ido) && pid.containsKey(ids)) {
            opid.put(ids, ido);

            List<String> curro = new ArrayList<>();
            if (pid.containsKey(ids)) {
                curro = polist.get(ids);
            }
            curro.add(ido);
            polist.put(ids, curro);

            //incr order of partner
            DeliveryPartner deliveryPartner = pid.get(ids);
            deliveryPartner.getNumberOfOrders(curro.size());
        }
    }

    public Order getOrderById(String oids) {
        return oid.get(oids);
    }

    public DeliveryPartner getPartnerById(String pids) {
        return pid.get(pids);
    }

    public Order getOrderPartner(String pids) {
        return oid.get(pid.get(pids));
    }

    public int getOrderCountByPartnerId(String pid) {
        return polist.get(pid).size();
    }

//    public List<String> allpOrder(String pid){
//        List<String> arList = new ArrayList<String>(poid.get(pid));
//
//        return arList;
//    }

    public List<String> getOrdersByPartnerId(String pids) {
        return polist.get(pids);
    }

    public List<String> getAllOrders() {


        List<String> list = new ArrayList<>();
        for (String order : oid.keySet()) {
            list.add(order);
        }
        return list;
    }

    public int getCountOfUnassignedOrders(){
        return oid.size() - opid.size();
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(int time,String pid){
        int cnt = 0;

        List<String> list = polist.get(pid);
        for(String oids:list){
            int dtime = oid.get(oids).getDeliveryTime();
            if(dtime > time){
                cnt++;
            }
        }
        return cnt;

    }


  public int getLastDeliveryTimeByPartnerId(String pid){
        int maxtime = 0;
        List<String> list = polist.get(pid);
      for(String oids:list){
          int dtime = oid.get(oids).getDeliveryTime();
          maxtime = Math.max(maxtime,dtime);
      }
      return maxtime;
  }

  public void deletePartnerById(String pids){
        pid.remove(pids);
        List<String> list = polist.get(pids);
        polist.remove(pids);

        for(String order:list){
            polist.remove(order);
        }
  }

  public void deleteOrderById(String oids){
        oid.remove(oids);
        String partnerid = opid.get(oids);
        opid.remove(oids);

        polist.get(partnerid).remove(oids);
        pid.get(partnerid).setNumberOfOrders(polist.get(partnerid).size());


  }
}
