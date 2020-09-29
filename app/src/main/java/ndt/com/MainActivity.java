package ndt.com;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static  final int REQ_CODE = 123; //la ma xac nhan gui va nhan du lieu
    Button btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                String hoTen = "LOVE YOURSELF";
                int age = 20;
                float point = (float) 7.5;
                List<String> hobby = new ArrayList<String>();
                hobby.add("FOOTBALL");
                hobby.add("EATING");
                hobby.add("PLAYING GAMES");
                hobby.add("PIANO");
//                intent.putExtra("hoten",hoTen);
//                intent.putExtra("tuoi",age);
//                intent.putExtra("diem",point);
//                intent.putExtra("hobby", (Serializable) hobby);
                Student student = new Student(hoTen,age,point,hobby);
//               intent.putExtra("student",student);
                Bundle bundle = new Bundle();
                bundle.putString("hoten",hoTen);
                bundle.putInt("tuoi",age);
                bundle.putFloat("diem",point);
                bundle.putSerializable("sothich", (Serializable) hobby);
                bundle.putSerializable("student",(Student)student);
                intent.putExtra("thungHang",bundle);
             //   startActivity(intent); gui du lieu
                startActivityForResult(intent,REQ_CODE); // ham nay dung de gui va nhan lai du lieu
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //resultCode la thanh cong hay that bai  //data: gui tra lai du lieu neu thanh cong
        if(requestCode == REQ_CODE){
            //day roi, du lieu cua minh day
            if(resultCode == RESULT_CANCELED) Toast.makeText(this, "DU LIEU GUI SANG CO VAN DE", Toast.LENGTH_SHORT).show();
            else {
                String name = data.getStringExtra("hoten");
                Toast.makeText(this, "THANKS FOR SENDING MY "+name, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "KHONG PHAI DU LIEU CUA TOI", Toast.LENGTH_SHORT).show();
        }
    }
}