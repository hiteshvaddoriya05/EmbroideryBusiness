package com.example.embroideryBusiness_LifetimeInfotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DesignerDetail extends AppCompatActivity implements View.OnClickListener {

    private CheckBox idCB_DesignerData_Malti, idCB_DesignerData_Coding, idCB_DesignerData_Chain,
            idCB_DesignerData_sQ, idCB_DesignerData_dsq;
    private EditText idET_DesignerData_year, idET_DesignerData_month, idET_DesignerData_salaryReuired;
    private String get_designerSkill_malti, get_designerSkill_Coding, get_designerSkill_chain, get_designerSkill_sq,
            get_designerSkill_dualSq, getDesignerExpYear, getDesignerExpMonth, getDesignerSalaryRequired;
    private AppCompatButton idBtn_DesignerData_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_detail);

        idCB_DesignerData_Malti = findViewById(R.id.idCB_DesignerData_Malti);
        idCB_DesignerData_Coding = findViewById(R.id.idCB_DesignerData_Coding);
        idCB_DesignerData_Chain = findViewById(R.id.idCB_DesignerData_Chain);
        idCB_DesignerData_sQ = findViewById(R.id.idCB_DesignerData_sQ);
        idCB_DesignerData_dsq = findViewById(R.id.idCB_DesignerData_dsq);
        idET_DesignerData_year = findViewById(R.id.idET_DesignerData_year);
        idET_DesignerData_month = findViewById(R.id.idET_DesignerData_month);
        idET_DesignerData_salaryReuired = findViewById(R.id.idET_DesignerData_salaryReuired);
        idBtn_DesignerData_submit = findViewById(R.id.idBtn_DesignerData_submit);

        idCB_DesignerData_Malti.setOnClickListener(this);
        idCB_DesignerData_Coding.setOnClickListener(this);
        idCB_DesignerData_Chain.setOnClickListener(this);
        idCB_DesignerData_sQ.setOnClickListener(this);
        idCB_DesignerData_dsq.setOnClickListener(this);


        idBtn_DesignerData_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getDesignerExpYear = idET_DesignerData_year.getText().toString();
                idET_DesignerData_year.getText().clear();
                
                getDesignerExpMonth = idET_DesignerData_month.getText().toString();
                getDesignerSalaryRequired = idET_DesignerData_salaryReuired.getText().toString();
                idET_DesignerData_month.getText().clear();
                
                idCB_DesignerData_Malti.setChecked(false);
                idCB_DesignerData_Coding.setChecked(false);
                idCB_DesignerData_Chain.setChecked(false);
                idCB_DesignerData_sQ.setChecked(false);
                idCB_DesignerData_dsq.setChecked(false);


                Toast.makeText(DesignerDetail.this, "Data Successfull Install", Toast.LENGTH_SHORT).show();
                Log.e("Data", "onClick: \n"+ get_designerSkill_malti+"\n"+get_designerSkill_Coding+"\n"+get_designerSkill_chain+"\n"+get_designerSkill_sq+"\n"+get_designerSkill_dualSq+"\n"+getDesignerExpYear+"\n"+getDesignerExpMonth+"\n"+getDesignerSalaryRequired);

            }
        });


    }//-----------end oncreate------------


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCB_DesignerData_Malti:
                if (idCB_DesignerData_Malti.isChecked()) {
                    get_designerSkill_malti = idCB_DesignerData_Malti.getText().toString();
                }
                break;
            case R.id.idCB_DesignerData_Coding:
                if (idCB_DesignerData_Coding.isChecked()) {
                    get_designerSkill_Coding = idCB_DesignerData_Coding.getText().toString();
                }
                break;
            case R.id.idCB_DesignerData_Chain:
                if (idCB_DesignerData_Chain.isChecked()) {
                    get_designerSkill_chain = idCB_DesignerData_Chain.getText().toString();
                }
                break;
            case R.id.idCB_DesignerData_sQ:
                if (idCB_DesignerData_Malti.isChecked()) {
                    get_designerSkill_sq = idCB_DesignerData_sQ.getText().toString();
                }
                break;
            case R.id.idCB_DesignerData_dsq:
                if (idCB_DesignerData_dsq.isChecked()) {
                    get_designerSkill_dualSq = idCB_DesignerData_dsq.getText().toString();
                }
                break;


        }



    }
}//-----------end class