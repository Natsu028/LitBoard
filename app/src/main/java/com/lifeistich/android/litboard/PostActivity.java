package com.lifeistich.android.litboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity
        implements View.OnClickListener{

    //firebase用
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference("message");
    //refMsgはfirebase独自の変数　→処理の簡略化可能！
    //'DatabaseReferance'とは何ぞや？
    //'Reference'は参照という意味！

    //Viewの構成要素
    EditText mUsernameText;
    EditText mPostText;
    Button mPostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mUsernameText = (EditText) findViewById(R.id.bookname);
        mPostText = (EditText) findViewById(R.id.message);
        mPostButton = (Button) findViewById(R.id.post);
    }
    @Override
    public void onClick(View v){
        int id = v.getId();

        switch (id){
            case R.id.post://コロン: と　セミコロン; の違いは？
                //TODO:投稿ボタンを押した時の処理

                //投稿を作る
                String message = mPostText.getText().toString();
                String userName = mUsernameText.getText().toString();
                Post post = new Post(userName, message);

                //投稿する
                refMsg.push().setValue(post);

                //アクティビティを閉じる
                finish();
                break;
        }
    }
}
