package com.example.embroideryBusiness_LifetimeInfotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EngineerDetail extends AppCompatActivity implements View.OnClickListener {

    private CheckBox idCB_EngineerData_Malti,idCB_EngineerData_Coding,idCB_EngineerData_Chain,idCB_EngineerData_SQ,idCB_EngineerData_DSq;
    private EditText idET_EngineerData_year,idET_EngineerData_month;
    private AppCompatButton idBtn_engineerData_submit;
    private String getEngineerExpYear,getEngineerExpMonth;
    private String get_engineerSkill_malti,get_engineerSkill_Coding,get_engineerSkill_chain,get_engineerSkill_sq,get_engineerSkill_dualSq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer_detail);

        idCB_EngineerData_Malti = findViewById(R.id.idCB_EngineerData_Malti);
        idCB_EngineerData_Coding = findViewById(R.id.idCB_EngineerData_Coding);
        idCB_EngineerData_Chain = findViewById(R.id.idCB_EngineerData_Chain);
        idCB_EngineerData_SQ = findViewById(R.id.idCB_EngineerData_SQ);
        idCB_EngineerData_DSq = findViewById(R.id.idCB_EngineerData_DSq);
        idET_EngineerData_year = findViewById(R.id.idET_EngineerData_year);
        idET_EngineerData_month = findViewById(R.id.idET_EngineerData_month);

        idBtn_engineerData_submit = findViewById(R.id.idBtn_engineerData_submit);

       idCB_EngineerData_Malti.setOnClickListener(this);
       idCB_EngineerData_Coding.setOnClickListener(this);
       idCB_EngineerData_Chain.setOnClickListener(this);
       idCB_EngineerData_SQ.setOnClickListener(this);
       idCB_EngineerData_DSq.setOnClickListener(this);


        idBtn_engineerData_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getEngineerExpYear = idET_EngineerData_year.getText().toString();
                idET_EngineerData_year.getText().clear();
                getEngineerExpMonth = idET_EngineerData_month.getText().toString();
                idET_EngineerData_month.getText().clear();

                idCB_EngineerData_Malti.setChecked(false);
                idCB_EngineerData_Coding.setChecked(false);
                idCB_EngineerData_Chain.setChecked(false);
                idCB_EngineerData_SQ.setChecked(false);
                idCB_EngineerData_DSq.setChecked(false);

                Toast.makeText(EngineerDetail.this, "Data Successfull Install", Toast.LENGTH_SHORT).show();
                Log.e("getEngdata", "onClick: \n"+get_engineerSkill_malti+"\n"+get_engineerSkill_Coding+"\n"+get_engineerSkill_chain+"\n"+get_engineerSkill_sq+"\n"+get_engineerSkill_dualSq+"\n"+getEngineerExpYear+"\n"+getEngineerExpMonth );

            }
        });




    }//end oncreate------------------------

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCB_EngineerData_Malti:
                if (idCB_EngineerData_Malti.isChecked()) {
                    get_engineerSkill_malti =idCB_EngineerData_Malti.getText().toString();



                }
                break;
            case R.id.idCB_EngineerData_Coding:
                if (idCB_EngineerData_Coding.isChecked()) {
                    get_engineerSkill_Coding = idCB_EngineerData_Coding.getText().toString();

                }
                break;
            case R.id.idCB_EngineerData_Chain:
                if (idCB_EngineerData_Chain.isChecked()) {
                    get_engineerSkill_chain = idCB_EngineerData_Chain.getText().toString();

                }
                break;
            case R.id.idCB_EngineerData_SQ:
                if (idCB_EngineerData_SQ.isChecked()) {
                    get_engineerSkill_sq = idCB_EngineerData_SQ.getText().toString();

                }
                break;
            case R.id.idCB_EngineerData_DSq:
                if (idCB_EngineerData_DSq.isChecked()) {
                    get_engineerSkill_dualSq = idCB_EngineerData_DSq.getText().toString();

                }
                break;


        }



    }


}//end Class-----------------------------