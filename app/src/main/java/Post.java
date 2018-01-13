/**
 * Created by kodakanatsumi on 2018/01/10.
 */

public class Post {

    String message;
    String userName;

    //Firebase用のコンストラクタ
    public Post(){

    }

    //コンストラクタ
    public Post(String userName, String message){
        this.userName = userName;
        this.message = message;
    }
    //アクセサメソッド：外部からアクセスする為に用意されたメソッド
    public String getMessage(){return message;}

    public void setMessage(String message){this.message = message;}

    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName = userName;}

    //JAVAでは基本的にクラスのフィールドの内容を書き換えたり、読んだりする時にはget~, set~ といったアクセサメソッドを使う
}