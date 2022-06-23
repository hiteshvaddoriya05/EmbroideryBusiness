package com.example.embroideryBusiness_LifetimeInfotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class HiringDetail extends AppCompatActivity implements View.OnClickListener {

    private CheckBox idCB_hiringData_Malti, idCB_hiringData_Coding, idCB_hiringData_Chain, idCB_hiringData_SQ, idCB_hiringData_DSq;
    private EditText idET_hiringData_expYear, idET_hiringData_hrs, idET_hiringData_amount, idET_hiringData_others;
    private AppCompatButton idBtn_hiringData_submit;
    private String get_hiringData_malti,get_hiringData_coding,get_hiringData_chain,get_hiringData_sq,get_hiringData_dsq;
    private String get_hiringData_expYear,get_hiringData_amount,get_hiringData_hrs,get_hiringData_others,ges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring_detail);

        idCB_hiringData_Malti = findViewById(R.id.idCB_hiringData_Malti);
        idCB_hiringData_Coding = findViewById(R.id.idCB_hiringData_Coding);
        idCB_hiringData_Chain = findViewById(R.id.idCB_hiringData_Chain);
        idCB_hiringData_SQ = findViewById(R.id.idCB_hiringData_SQ);
        idCB_hiringData_DSq = findViewById(R.id.idCB_hiringData_DSq);

        idET_hiringData_expYear = findViewById(R.id.idET_hiringData_expYear);
        idET_hiringData_amount = findViewById(R.id.idET_hiringData_amount);
        idET_hiringData_hrs = findViewById(R.id.idET_hiringData_hrs);
        idET_hiringData_others = findViewById(R.id.idET_hiringData_others);
        idBtn_hiringData_submit = findViewById(R.id.idBtn_hiringData_submit);


        idCB_hiringData_Malti.setOnClickListener(this);
        idCB_hiringData_Coding.setOnClickListener(this);
        idCB_hiringData_Chain.setOnClickListener(this);
        idCB_hiringData_SQ.setOnClickListener(this);
        idCB_hiringData_DSq.setOnClickListener(this);


        idBtn_hiringData_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_hiringData_expYear=idET_hiringData_expYear.getText().toString();
                get_hiringData_amount=idET_hiringData_amount.getText().toString();
                get_hiringData_hrs= idET_hiringData_hrs.getText().toString();
                get_hiringData_others=idET_hiringData_others.getText().toString();


                idET_hiringData_expYear.getText().clear();
                idET_hiringData_amount.getText().clear();
                idET_hiringData_hrs.getText().clear();
                idET_hiringData_others.getText().clear();
                idCB_hiringData_Malti.setChecked(false);
                idCB_hiringData_Coding.setChecked(false);
                idCB_hiringData_Chain.setChecked(false);
                idCB_hiringData_SQ.setChecked(false);
                idCB_hiringData_DSq.setChecked(false);

                Log.e("HiringData", "onClick:\n "+get_hiringData_malti+"\n"+get_hiringData_coding+"\n"+get_hiringData_chain+"\n"+get_hiringData_sq+"\n"+get_hiringData_dsq+"\n"+get_hiringData_expYear+"\n"+get_hiringData_hrs+"\n"+get_hiringData_amount+"\n"+get_hiringData_others );
                Toast.makeText(HiringDetail.this, "Successfull Install", Toast.LENGTH_SHORT).show();
                
                
            }
        });

    }//----------end oncreate


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCB_hiringData_Malti:
                if (idCB_hiringData_Malti.isChecked()) {
                    get_hiringData_malti = idCB_hiringData_Malti.getText().toString();
                }
            case R.id.idCB_hiringData_Coding:
                if (idCB_hiringData_Coding.isChecked()) {
                    get_hiringData_coding = idCB_hiringData_Coding.getText().toString();
                }
            case R.id.idCB_hiringData_Chain:
                if (idCB_hiringData_Malti.isChecked()) {
                    get_hiringData_chain = idCB_hiringData_Chain.getText().toString();
                }
            case R.id.idCB_hiringData_SQ:
                if (idCB_hiringData_Malti.isChecked()) {
                    get_hiringData_sq = idCB_hiringData_SQ.getText().toString();
                }
            case R.id.idCB_hiringData_DSq:
                if (idCB_hiringData_Malti.isChecked()) {
                    get_hiringData_dsq = idCB_hiringData_DSq.getText().toString();
                }


        }


    }
}//--------end class