package lk.ijse.kingsland.view.tm;

public class CustomTM {

    private String curCode;
    private String stdName;

    public CustomTM() {
    }

    public CustomTM(String curCode, String stdName) {
        this.curCode = curCode;
        this.stdName = stdName;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }
}
