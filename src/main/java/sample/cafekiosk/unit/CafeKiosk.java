package sample.cafekiosk.unit;

import lombok.Getter;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CafeKiosk {

    public static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10,0);
    public static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22,0);

    private final List<Beverage> beverageList = new ArrayList<>();

    public void add(Beverage beverage, int count) {
        if(count == 0){
            throw new IllegalArgumentException("no zero");
        }
        for(int i = 0 ; i < count ; i++){
            beverageList.add(beverage);
        }
    }

    public void remove(Beverage beverage){
        beverageList.remove(beverage);
    }

    public void clear(){
        beverageList.clear();
    }

    public int calculate() {
        int totalPrice = 0;
        for(Beverage beverage : beverageList){
            totalPrice += beverage.getPrice();
        }
        return totalPrice;
    }

    public Order createOrder(LocalDateTime currentDateTime){
        LocalTime currentTime =  currentDateTime.toLocalTime();

        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
            throw new IllegalArgumentException("no");
        }

        return new Order(LocalDateTime.now(), beverageList);
    }
}
