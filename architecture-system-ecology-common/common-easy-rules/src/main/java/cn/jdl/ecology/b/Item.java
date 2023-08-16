package cn.jdl.ecology.b;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    private int price;

    private String expression;

    public Item(int price){
        this.price = price;
    }
}
