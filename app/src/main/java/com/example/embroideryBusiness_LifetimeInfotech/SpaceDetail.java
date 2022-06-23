package com.example.embroideryBusiness_LifetimeInfotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SpaceDetail extends AppCompatActivity {

    private EditText idET_spaceData_buildingNos,idET_spaceData_buildinFloor,idET_spaceData_industries,
    idET_spaceData_area,idET_spaceData_near,idET_spaceData_city,idET_spaceData_state,idET_spaceData_areaWidth,
    idET_spaceData_areaLength,idET_spaceData_rentPrice;
    private AppCompatButton idBtn_spaceData_submit;
    private String get_spaceData_buildingNos,get_spaceData_buildinFloor,get_spaceData_industries,
    get_spaceData_area,get_spaceData_near,get_spaceData_city,get_spaceData_state,get_spaceData_areaLength,
    get_spaceData_areaWidth,get_spaceData_rentPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_detail);


        idET_spaceData_buildingNos=findViewById(R.id.idET_spaceData_buildingNos);
        idET_spaceData_buildinFloor=findViewById(R.id.idET_spaceData_buildinFloor);
        idET_spaceData_industries=findViewById(R.id.idET_spaceData_industries);
        idET_spaceData_area=findViewById(R.id.idET_spaceData_area);
        idET_spaceData_near=findViewById(R.id.idET_spaceData_near);
        idET_spaceData_city=findViewById(R.id.idET_spaceData_city);
        idET_spaceData_state=findViewById(R.id.idET_spaceData_state);
        idET_spaceData_areaWidth=findViewById(R.id.idET_spaceData_areaWidth);
        idET_spaceData_areaLength=findViewById(R.id.idET_spaceData_areaLength);
        idET_spaceData_rentPrice=findViewById(R.id.idET_spaceData_rentPrice);

        idBtn_spaceData_submit=findViewById(R.id.idBtn_spaceData_submit);


        idBtn_spaceData_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_spaceData_buildingNos=idET_spaceData_buildingNos.getText().toString();
                get_spaceData_buildinFloor=idET_spaceData_buildinFloor.getText().toString();
                get_spaceData_industries=idET_spaceData_industries.getText().toString();
                get_spaceData_area=idET_spaceData_area.getText().toString();
                get_spaceData_near=idET_spaceData_near.getText().toString();
                get_spaceData_city=idET_spaceData_city.getText().toString();
                get_spaceData_state=idET_spaceData_state.getText().toString();
                get_spaceData_areaWidth=idET_spaceData_areaWidth.getText().toString();
                get_spaceData_areaLength=idET_spaceData_areaLength.getText().toString();
                get_spaceData_rentPrice=idET_spaceData_rentPrice.getText().toString();

               idET_spaceData_buildingNos.getText().clear();
               idET_spaceData_buildinFloor.getText().clear();
               idET_spaceData_industries.getText().clear();
                idET_spaceData_area.getText().clear();
                idET_spaceData_near.getText().clear();
                idET_spaceData_city.getText().clear();
                idET_spaceData_state.getText().clear();
                idET_spaceData_areaWidth.getText().clear();
                idET_spaceData_areaLength.getText().clear();
                idET_spaceData_rentPrice.getText().clear();

                Log.e("spaceData---", "onClick:\n "+get_spaceData_buildingNos+"\n"+get_spaceData_area+"\n"+get_spaceData_city+"\n"+get_spaceData_areaLength+"\n"+get_spaceData_buildinFloor+"\n"+get_spaceData_industries+"\n"+get_spaceData_near+"\n"+get_spaceData_rentPrice+"\n"+get_spaceData_state+"\n"+get_spaceData_areaWidth );

            }
        });



    }//end oncreate



}//end class