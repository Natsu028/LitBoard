package com.lifeistich.android.litboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //implements は約束

    //for firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference("message");

    //view componet
    ListView mListView;
    Button mButton;

    //fields
    ArrayList<Post> items;

    //adapter
    PostAdapter postAdapter;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);

        mButton = (Button) findViewById(R.id.button2) ;

        mButton.setOnClickListener(this);

        items = new ArrayList<>();
        postAdapter = new PostAdapter(this, 0, items);

        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);

        refMsg.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //TODO:投稿が読み込む時の処理
                //onChildAdded : 投稿されたら

                //データを取得
                Post value = dataSnapshot.getValue(Post.class);

                //リストに追加
                items.add(value);

                //画面を更新
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //onChildChanged : 変更されたら
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //onChildRemoved : 削除されたら
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //onChildMoved : 移動されたら
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //onCancelled : キャンセルされたら

            }
        });
    }
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }
}
