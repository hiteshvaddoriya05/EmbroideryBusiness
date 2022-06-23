package com.example.embroideryBusiness_LifetimeInfotech.Fragment;

import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.embroideryBusiness_LifetimeInfotech.R;

import java.io.File;
import java.io.FileNotFoundException;


public class Profile extends Fragment {


    private static final int REQUEST_GET_SINGLE_FILE = 101;
    private static final int RESULT_OK = 200;
    private EditText idET_Profile_Name, idET_Profile_mono, idET_Profile_DOB, idET_Profile_Address, idET_Profile_City, idET_Profile_State, idET_Profile_email;
    private String name, mono, dob, address, city, state, email, sex;
    private RadioButton idRB_profile_male, idRB_profile_female;
    private AppCompatButton idBtn_profile_submit;
    private int mYear, mMonth, mDay;
    private ImageView idEdit_profileImg, id_ivProfile;
    private int getImgID=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        idET_Profile_Name = view.findViewById(R.id.idET_Profile_Name);
        idET_Profile_mono = view.findViewById(R.id.idET_Profile_mono);
        idET_Profile_DOB = view.findViewById(R.id.idET_Profile_DOB);
        idET_Profile_Address = view.findViewById(R.id.idET_Profile_Address);
        idET_Profile_City = view.findViewById(R.id.idET_Profile_City);
        idET_Profile_State = view.findViewById(R.id.idET_Profile_State);
        idET_Profile_email = view.findViewById(R.id.idET_Profile_email);
        idRB_profile_male = view.findViewById(R.id.idRB_profile_male);
        idRB_profile_female = view.findViewById(R.id.idRB_profile_female);
        idBtn_profile_submit = view.findViewById(R.id.idBtn_profile_submit);

        idEdit_profileImg = view.findViewById(R.id.idEdit_profileImg);
        id_ivProfile = view.findViewById(R.id.id_ivProfile);


        idET_Profile_DOB.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                datepick();

            }
        });


        idBtn_profile_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkemptyText();
                getprofileData();
            }
        });

        idEdit_profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_GET_SINGLE_FILE);
            }
        });


        return view;
    }//end oncreate------------------------------------------------------------------


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
                if (requestCode == REQUEST_GET_SINGLE_FILE) {
                    Uri selectedImageUri = data.getData();
                    // Get the path from the Uri
                    final String path = getPathFromURI(selectedImageUri);
                    if (path != null) {
                        File f = new File(path);
                        selectedImageUri = Uri.fromFile(f);
                    }
                    // Set the image in ImageView
                    id_ivProfile.setImageURI(selectedImageUri);
                }

        } catch (Exception e) {
            Log.e("FileSelectorActivity", "File select error", e);
        }
    }


    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


    private void checkemptyText() {
        if (idET_Profile_Name.length() == 0) {
            idET_Profile_Name.setError("Enter Your Name");
        } else if (idET_Profile_mono.length() == 0) {
            idET_Profile_mono.setError("Enter Your Mono");
        } else if (idET_Profile_DOB.length() == 0) {
            idET_Profile_DOB.setError("Enter Your DOB");
        } else if (idET_Profile_Address.length() == 0) {
            idET_Profile_Address.setError("Enter Your Address");
        } else if (idET_Profile_City.length() == 0) {
            idET_Profile_City.setError("Enter Your City");
        } else if (idET_Profile_State.length() == 0) {
            idET_Profile_State.setError("Enter Your State");
        } else if ((idRB_profile_male.length() == 0) || (idRB_profile_female.length() == 0)) {
            idRB_profile_male.setError("Enter Your Male/Female");
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void datepick() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        idET_Profile_DOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();


    }


    private void getprofileData() {

        name = idET_Profile_Name.getText().toString();
        mono = idET_Profile_mono.getText().toString();
        dob = idET_Profile_DOB.getText().toString();
        address = idET_Profile_Address.getText().toString();
        city = idET_Profile_City.getText().toString();
        state = idET_Profile_State.getText().toString();
        email = idET_Profile_email.getText().toString();

        if (idRB_profile_female.isChecked()) {

            sex = idRB_profile_female.getText().toString();
        } else if (idRB_profile_male.isChecked()) {
            sex = idRB_profile_male.getText().toString();
        }

        Toast.makeText(getContext(), "Result" + name + "\n" + mono + "\n" + dob + "\n" + address + "\n" + city + "\n" + state + "\n" + email + "\n" + sex, Toast.LENGTH_SHORT).show();
        Log.e("Result", "getprofileData:================ " + name + "\n" + mono + "\n" + dob + "\n" + address + "\n" + city + "\n" + state + "\n" + email + "\n" + sex);

    }


}//end class---------------------------------------------------------------------------