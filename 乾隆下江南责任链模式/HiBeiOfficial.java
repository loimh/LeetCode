package 乾隆下江南责任链模式;

public class HiBeiOfficial extends Official {

    public  HiBeiOfficial(){
        this.title="河北直属总督";
    }

    @Override
    protected void server(Emperor emperor) {
        emperor.play(this,"避暑山庄");
    }
}
