package 乾隆下江南责任链模式;

public abstract class Official {

    protected String title;

    protected  abstract  void server(Emperor emperor);

    @Override
    public String toString() {
        return  title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
