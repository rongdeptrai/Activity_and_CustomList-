package com.example.activiti_customlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[]={"Lê Hoàng Long","Đại học Sư Phạm Kỹ Thuật","Khoa Điện Điện Tử"};
    String mDescrip[]={"Msv 1811505310322","ĐC 48 Cao Thắng","Ngành Công nghệ thông tin"};
    int image[]={R.drawable.avata,R.drawable.logo,R.drawable.dt};
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView=findViewById(R.id.listView);

        MyAdapter adapter =new MyAdapter(this ,mTitle,mDescrip,image);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(c, "Lê Hoàng Long \n Mã sinh viên 1811505310322", Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    Toast.makeText(c, "Trường ĐH Sư Pham Kỹ Thuật", Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(c, "Khoa Điện Điện Tử", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDesciption[];
        int rImage[];
        MyAdapter(Context c,String title[],String description[],int image[]){
            super(c,R.layout.row,R.id.textView1,title);

            this.rTitle=title;
            this.rDesciption=description;
            this.rImage=image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =layoutInflater.inflate(R.layout.row,parent,false);
            ImageView image=row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.textView1);
            TextView myDescription=row.findViewById(R.id.textView2);

            image.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDesciption[position]);

            return row  ;
        }
    }
}