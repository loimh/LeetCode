package 乾隆下江南责任链模式;

public class Emperor {
    public static Emperor emperor=new Emperor("乾隆");

    private  String name;

    private Emperor(String  name){
        this.name=name;
    }

    public static Emperor getEmperor(){
        return  emperor;
    }

    public void play(Official official, String place){
        System.out.println(official.getTitle() + " 安排 " + name + "皇帝游览了: " + place);
    }
}
