package com.example.embroideryBusiness_LifetimeInfotech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.audiofx.DynamicsProcessing;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.embroideryBusiness_LifetimeInfotech.Adaptors.Adaptor_MachineImg;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SellMachineDetail extends AppCompatActivity {

    private RadioButton idRB_MachineData_malti, idRB_MachineData_coding, idRB_MachineData_chain, idRB_MachineData_sq, idRB_MachineData_dualSQ;
    private EditText idET_MachineData_companyname, idET_MachineData_heads, idET_MachinData_Price, idET_MachinData_areaWidth;
    private AppCompatButton idBtn_machineData_submit, idBtn_MachineData_AddImg;
    private String get_machine_type, get_machineName, get_machineWidth, get_machineSellPrice, get_machineHead;
    private ArrayList<Uri> uriList = new ArrayList<>();

//SOURCES https://stackoverflow.com/questions/35221690/setting-the-maximum-number-of-items-to-be-returned-by-an-intent

    private RecyclerView id_recylcerMachineImg;
    private Adaptor_MachineImg adaptor;
    private String imgUrl;
    private ArrayList<Bitmap> bitmaps;
    //private List<Bitmap> bitmaps=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_machine_detail);


        idRB_MachineData_malti = findViewById(R.id.idRB_MachineData_malti);
        idRB_MachineData_coding = findViewById(R.id.idRB_MachineData_coding);
        idRB_MachineData_chain = findViewById(R.id.idRB_MachineData_chain);
        idRB_MachineData_sq = findViewById(R.id.idRB_MachineData_sq);
        idRB_MachineData_dualSQ = findViewById(R.id.idRB_MachineData_dualSQ);

        idET_MachineData_companyname = findViewById(R.id.idET_MachineData_companyname);
        idET_MachineData_heads = findViewById(R.id.idET_MachineData_heads);
        idET_MachinData_areaWidth = findViewById(R.id.idET_MachinData_areaWidth);
        idET_MachinData_Price = findViewById(R.id.idET_MachinData_Price);
        idBtn_machineData_submit = findViewById(R.id.idBtn_machineData_submit);

        idBtn_MachineData_AddImg = findViewById(R.id.idBtn_MachineData_AddImg);
        id_recylcerMachineImg = findViewById(R.id.id_recylcerMachineImg);


        idBtn_machineData_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (idRB_MachineData_malti.isChecked()) {
                    get_machine_type = idRB_MachineData_malti.getText().toString();
                } else if (idRB_MachineData_coding.isChecked()) {
                    get_machine_type = idRB_MachineData_coding.getText().toString();
                }
                if (idRB_MachineData_chain.isChecked()) {
                    get_machine_type = idRB_MachineData_chain.getText().toString();
                }
                if (idRB_MachineData_sq.isChecked()) {
                    get_machine_type = idRB_MachineData_sq.getText().toString();
                }
                if (idRB_MachineData_dualSQ.isChecked()) {
                    get_machine_type = idRB_MachineData_dualSQ.getText().toString();
                }

                get_machineName = idET_MachineData_companyname.getText().toString();
                get_machineHead = idET_MachineData_heads.getText().toString();
                get_machineWidth = idET_MachinData_areaWidth.getText().toString();
                get_machineSellPrice = idET_MachinData_Price.getText().toString();

                idET_MachineData_companyname.getText().clear();
                idET_MachinData_areaWidth.getText().clear();
                idET_MachinData_Price.getText().clear();
                idET_MachineData_heads.getText().clear();

                Toast.makeText(SellMachineDetail.this, "Data Successfull Install", Toast.LENGTH_SHORT).show();
                Log.e("Machine Data", "onClick: \n" + get_machine_type + "\n" + get_machineName + "\n" + get_machineWidth + "\n" + get_machineSellPrice + "\n" + get_machineHead);


            }
        });//-------end-------------------------------

        idBtn_MachineData_AddImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(intent.EXTRA_ALLOW_MULTIPLE, true);

                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });


        adaptor = new Adaptor_MachineImg(this,uriList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        id_recylcerMachineImg.setLayoutManager(manager);
        id_recylcerMachineImg.setAdapter(adaptor);


/*
        adaptor = new Adaptor_MachineImg(this,bitmaps);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        id_recylcerMachineImg.setLayoutManager(manager);
        id_recylcerMachineImg.setAdapter(adaptor);

 */


    }//-----------end OnCreate-----------------

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) ;


        if (data.getClipData() != null) {
            int x = data.getClipData().getItemCount();
            for (int i = 0; i <x; i++) {
                Uri geturi=data.getClipData().getItemAt(i).getUri();
                uri.add(geturi);
                Log.e("List------", "onActivityResult: "+ data.getClipData().getItemAt(i).getUri()  );

            }

            adaptor.notifyDataSetChanged(); //for adaptor this is complesery
        }

         if (data.getData()!=null){

            imgUrl=data.getData().getPath();
            Log.e("path--------", "onActivityResult: "+imgUrl );
            uri.add(Uri.parse(imgUrl));
        }

    }//-----------end
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) ;

        ImageView  imageView=findViewById(R.id.idIV_sellmachine);
         bitmaps=new ArrayList<>();
        ClipData clipData=data.getClipData();
        if(clipData!=null){
            for(int i=0;i<clipData.getItemCount();i++){
                Uri getImguri=clipData.getItemAt(i).getUri();
                uriList.add(getImguri);

                try {
                    InputStream is =getContentResolver().openInputStream(getImguri);
                    Bitmap bitmap= BitmapFactory.decodeStream(is);
                    bitmaps.add(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            adaptor.notifyDataSetChanged(); //for adaptor this is complesery
        }else {
            Uri getImguri = data.getData();
            try {
                //convert uri into bitmap
                InputStream is =getContentResolver().openInputStream(getImguri);
                Bitmap bitmap= BitmapFactory.decodeStream(is);
                bitmaps.add(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Bitmap b:bitmaps){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(b);
                        }
                    });
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Log.e("bitmaps list-----", "onActivityResult: " +bitmaps.get(0)+"\n"+bitmaps.get(1) );

    }




}//-------------End class