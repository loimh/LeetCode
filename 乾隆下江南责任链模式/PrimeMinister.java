package 乾隆下江南责任链模式;

import java.util.ArrayList;
import java.util.List;

public class PrimeMinister {

    private  static  List<Official> list=new ArrayList<>();

    public static  void main(String[] args){

        list.add(new HiBeiOfficial());
        list.add(new ShanDongOffical());
        list.add(new SuZhouOffical());
        // 昭告天下：万岁爷起驾下江南！沿途各省依次伺候圣上
        System.out.println("乾隆下江南!");
        startPlay(list,Emperor.getEmperor());
    }

    private static  void startPlay(List<Official> list,Emperor emperor){
        for(Official official:list){
            official.server(emperor);
        }
    }
}
