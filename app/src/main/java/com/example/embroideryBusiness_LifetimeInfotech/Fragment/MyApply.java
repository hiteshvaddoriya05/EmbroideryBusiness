package com.example.embroideryBusiness_LifetimeInfotech.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.embroideryBusiness_LifetimeInfotech.DesignerDetail;
import com.example.embroideryBusiness_LifetimeInfotech.EngineerDetail;
import com.example.embroideryBusiness_LifetimeInfotech.HiringDetail;
import com.example.embroideryBusiness_LifetimeInfotech.R;
import com.example.embroideryBusiness_LifetimeInfotech.SellMachineDetail;
import com.example.embroideryBusiness_LifetimeInfotech.SpaceDetail;


public class MyApply extends Fragment {

    private RadioButton idRB_Apply_DesignerJob, idRB_Apply_sellMachine, idRB_Apply_machineSpace, idRB_Apply_hiringJob, idRB_Apply_engineer;
    private AppCompatButton idBtn_gotoDetail;
    private String getPageto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_apply, container, false);

        idRB_Apply_DesignerJob = view.findViewById(R.id.idRB_Apply_DesignerJob);
        idRB_Apply_sellMachine = view.findViewById(R.id.idRB_Apply_sellMachine);
        idRB_Apply_machineSpace = view.findViewById(R.id.idRB_Apply_machineSpace);
        idRB_Apply_hiringJob = view.findViewById(R.id.idRB_Apply_hiringJob);
        idRB_Apply_engineer = view.findViewById(R.id.idRB_Apply_engineer);
        idBtn_gotoDetail = view.findViewById(R.id.idBtn_gotoDetail);


        idBtn_gotoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (idRB_Apply_DesignerJob.isChecked()) {
                    getPageto = idRB_Apply_DesignerJob.getText().toString();
                } else if (idRB_Apply_sellMachine.isChecked()) {
                    getPageto = idRB_Apply_sellMachine.getText().toString();
                } else if (idRB_Apply_machineSpace.isChecked()) {
                    getPageto = idRB_Apply_machineSpace.getText().toString();
                } else if (idRB_Apply_hiringJob.isChecked()) {
                    getPageto = idRB_Apply_hiringJob.getText().toString();
                } else if (idRB_Apply_engineer.isChecked()) {
                    getPageto = idRB_Apply_engineer.getText().toString();
                }

                goOnPage();

            }
        });


        return view;
    }//end oncreate-------------------------------------------------------------------------------

    private void goOnPage() {
        if (getPageto == idRB_Apply_DesignerJob.getText().toString()) {
            Intent intent = new Intent(getActivity(), DesignerDetail.class);
            startActivity(intent);

        }
        else if (getPageto == idRB_Apply_sellMachine.getText().toString()) {
            Intent intent = new Intent(getActivity(), SellMachineDetail.class);
            startActivity(intent);
        }
        else if (getPageto == idRB_Apply_machineSpace.getText().toString()) {
            Intent intent = new Intent(getActivity(), SpaceDetail.class);
            startActivity(intent);
        }
        else if (getPageto == idRB_Apply_hiringJob.getText().toString()) {
            Intent intent = new Intent(getActivity(), HiringDetail.class);
            startActivity(intent);
        }
        else if (getPageto == idRB_Apply_engineer.getText().toString()) {
            Intent intent = new Intent(getActivity(), EngineerDetail.class);
            startActivity(intent);
        }




    }
}//end clas--------------------------------------