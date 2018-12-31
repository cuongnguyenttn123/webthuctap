package thuctapcongnhan.ttn.domain;

public class UserReponse {
    private String userName;
    private String passWord;

    public UserReponse() {
    }

    public UserReponse(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
