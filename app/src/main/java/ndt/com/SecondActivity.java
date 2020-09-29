package ndt.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    Button btnBack;
    Student student;
    String hoTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnBack = findViewById(R.id.btnBack);
        Intent intent = getIntent();
//        String hoten = intent.getStringExtra("hoten");
//        int tuoi = intent.getIntExtra("tuoi",0);
//        float diem = intent.getFloatExtra("diem",0);
//        List<String> hobby = (List<String>) intent.getSerializableExtra("hobby");
//        Toast.makeText(this, "Name: "+hoten, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Age: "+tuoi, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "POINT: "+diem, Toast.LENGTH_SHORT).show();
//        for(String items:hobby){
//            Toast.makeText(this, "Hobby: "+items, Toast.LENGTH_SHORT).show();
//        }
//        Student student = (Student) intent.getSerializableExtra("student");
//        Toast.makeText(this, ""+student.toString(), Toast.LENGTH_SHORT).show();
        Bundle bundle = intent.getBundleExtra("thungHang");
        hoTen = bundle.getString("hoten");
        int age = bundle.getInt("tuoi");
        float diem = bundle.getFloat("diem");
        List<String> hobby = (List<String>) bundle.getSerializable("sothich");
        student = (Student) bundle.getSerializable("student");
        Toast.makeText(this, "Name: "+hoTen, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Age: "+age, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "POINT: "+diem, Toast.LENGTH_SHORT).show();
        for(String items:hobby){
            Toast.makeText(this, "Hobby: "+items, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, ""+student.toString(), Toast.LENGTH_SHORT).show();

    }
    public void back(View view){
//        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
//        startActivity(intent);
        //Ham nay ta biet dia chi man hinh gui roi nen ta se quay lai duoc man hinh gui du lieu
        if(student!=null){
            Intent i = new Intent();
            i.putExtra("hoten",hoTen);
            setResult(RESULT_OK,i);

        }
        else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}