package store;

import entity.AbstractCoffe;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class CollectCoffe {
   private  ArrayList<AbstractCoffe> coffeList = new ArrayList<AbstractCoffe>();

    public ArrayList<AbstractCoffe> getCoffeList() {
        return coffeList;
    }

    public void setCoffeList(ArrayList<AbstractCoffe> coffeList) {
        this.coffeList = coffeList;
    }

    public void addCofee(AbstractCoffe abstractCoffe){
        coffeList.add(abstractCoffe);
    }

}
