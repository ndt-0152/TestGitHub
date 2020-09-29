package ndt.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Intent_Implic extends AppCompatActivity {
    ImageView imgFireFox;
    ImageView imgMessage,imgPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent__implic);
        mapping();
    }
    public void doAction(View view){
        switch (view.getId()){
            case R.id.imgFireFox:
                openBrowser();
                break;
            case R.id.imgMessage:
                openMessage();
                break;
            case R.id.imgPhone:
                openPhone();
                break;
        }
    }
    public void openBrowser(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(intent);
    }
    public void openMessage(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.putExtra("sms_body","HELLO EVERYBODY TODAY I FEEL SO GOOD");
        intent.setData(Uri.parse("sms:0988888888"));
        startActivity(intent);
    }
     public void openPhone(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0924784228"));

        startActivity(intent);
    }
    public void mapping(){
        imgFireFox= findViewById(R.id.imgFireFox);
        imgMessage = findViewById(R.id.imgMessage);
        imgPhone = findViewById(R.id.imgPhone);
    }
}