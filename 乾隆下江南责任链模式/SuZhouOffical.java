package 乾隆下江南责任链模式;

public class SuZhouOffical extends Official {
    public SuZhouOffical(){
        this.title="苏州织造";
    }

    @Override
    protected void server(Emperor emperor) {
        emperor.play(this,"苏州园林");
    }
}
