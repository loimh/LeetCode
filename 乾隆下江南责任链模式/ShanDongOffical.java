package 乾隆下江南责任链模式;

public class ShanDongOffical extends Official {

    public ShanDongOffical(){
        this.title="山东巡抚";
    }

    @Override
    protected void server(Emperor emperor) {
        emperor.play(this,"曲阜孔庙");
    }
}
