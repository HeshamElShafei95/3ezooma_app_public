package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvDaysAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvRegisterServicesAdapter;
import com.ezooma.caterer.models.ServicesModel;
import com.ezooma.caterer.utilities.AppConstants;
import com.ezooma.caterer.utilities.GlobalBundleKeys;
import com.ezooma.caterer.utilities.Validations;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class RegisterActivity extends BaseActivity {
    AppCompatTextView mTxtLogin, mTxtToolBarTitle, mTxtOpenTimings, mTxtCloseTimings;
    CardView mCvRegister, mCvOpenTimings, mCvCloseTimings;
    AppCompatImageView mImgToolbarBack;
    Bundle mBundle;
    String mRoute;
    RecyclerView mRvServices, mRvDays;
    RvRegisterServicesAdapter mRvRegisterServicesAdapter;
    RvDaysAdapter mRvDaysAdapter;
    ArrayList<ServicesModel> mList = new ArrayList<>();
    ArrayList<String> mDaysList = new ArrayList<>();
    ArrayList<String> mSelectedServices = new ArrayList<>();
    ArrayList<String> mSelectedDays = new ArrayList<>();

    AppCompatEditText mEdtOwnerName, mEdtBusinessName, mEdtEmail, mEdtAddress, mEdtContactNumber, mEdtMinimumPersons, mEdtDeliverDays, mEdtPassword, mEdtConfirmPassword;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String mOwnerName, mBusinessName, mEmail, mAddress, mContactNumber,
            mMinimumPersons, mDeliveryDays, mPassword, mConfirmPassword, mOpeningTimings, mClosingTimings;
    Validations mValidations;
    int hour = 0, minutes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mRoute = (String) mBundle.getSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE);
        }
        initVariables();
        setViewsTexts();
        setViewsClicks();
        setUpRv();
        setUpDaysRv();
    }

    private void setUpDaysRv() {
        mDaysList.add("Monday");
        mDaysList.add("Tuesday");
        mDaysList.add("Wednesday");
        mDaysList.add("Thursday");
        mDaysList.add("Friday");
        mDaysList.add("Saturday");
        mDaysList.add("Sunday");

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvDays.setLayoutManager(layoutManager);
        mRvDays.setItemAnimator(new DefaultItemAnimator());
        mRvDaysAdapter = new RvDaysAdapter(this, mDaysList);
        mRvDays.setAdapter(mRvDaysAdapter);
    }

    private void setUpRv() {
        ServicesModel lServicesModel = new ServicesModel();
        lServicesModel.setServiceName("Food");
        mList.add(lServicesModel);
        ServicesModel lServicesModel2 = new ServicesModel();
        lServicesModel2.setServiceName("Beverages");
        mList.add(lServicesModel2);
        ServicesModel lServicesModel3 = new ServicesModel();
        lServicesModel3.setServiceName("Snacks");
        mList.add(lServicesModel3);
        ServicesModel lServicesModel4 = new ServicesModel();
        lServicesModel4.setServiceName("Desert");
        mList.add(lServicesModel4);
        ServicesModel lServicesModel5 = new ServicesModel();
        lServicesModel5.setServiceName("Breakfast");
        mList.add(lServicesModel5);
        ServicesModel lServicesModel7 = new ServicesModel();
        lServicesModel7.setServiceName("Dinner");
        mList.add(lServicesModel7);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvServices.setLayoutManager(layoutManager);
        mRvServices.setItemAnimator(new DefaultItemAnimator());
        mRvRegisterServicesAdapter = new RvRegisterServicesAdapter(this, mList);
        mRvServices.setAdapter(mRvRegisterServicesAdapter);
    }

    private void setViewsTexts() {
        mTxtToolBarTitle.setText(getString(R.string.register));
    }

    private void setViewsClicks() {
        mTxtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRoute == null) {
                    mBundle = new Bundle();
                    mBundle.putSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE, AppConstants.REGISTER);
                    changeActivity(RegisterActivity.this, LoginActivity.class, false, mBundle);
                } else {
                    finish();
                }
            }
        });
        mCvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOwnerName = mEdtOwnerName.getText().toString().trim();
                mBusinessName = mEdtBusinessName.getText().toString().trim();
                mEmail = mEdtEmail.getText().toString().trim();
                mAddress = mEdtAddress.getText().toString().trim();
                mContactNumber = mEdtContactNumber.getText().toString().trim();
                mMinimumPersons = mEdtMinimumPersons.getText().toString().trim();
                mDeliveryDays = mEdtDeliverDays.getText().toString().trim();
                mPassword = mEdtPassword.getText().toString().trim();
                mConfirmPassword = mEdtConfirmPassword.getText().toString().trim();
                mOpeningTimings = mTxtOpenTimings.getText().toString().trim();
                mClosingTimings = mTxtCloseTimings.getText().toString().trim();

                String result = mValidations.signUpValidation(RegisterActivity.this, mOwnerName, mBusinessName, mEmail
                        , mAddress, mContactNumber, mSelectedServices, mMinimumPersons, mDeliveryDays,
                        mSelectedDays, mOpeningTimings, mClosingTimings, mPassword, mConfirmPassword);

                if (result.equalsIgnoreCase("")) {
                    //void callRegisterApi();
                    changeActivity(RegisterActivity.this, ChooseLocationActivity.class, false, null);
                } else {
                    showErrorAlerter("", result);
                }


            }
        });
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCvOpenTimings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(RegisterActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                mTxtOpenTimings.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
            }
        });
        mCvCloseTimings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(RegisterActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                mTxtCloseTimings.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
            }
        });
    }

    private void initVariables() {
        mValidations = new Validations();
        mTxtLogin = findViewById(R.id.txtAlreadyAccount);
        mTxtToolBarTitle = findViewById(R.id.txtToolbarTitle);
        mCvRegister = findViewById(R.id.cvRegister);
        mRvServices = findViewById(R.id.rvServices);
        mRvDays = findViewById(R.id.rvDays);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mEdtOwnerName = findViewById(R.id.edtOwnerName);
        mEdtEmail = findViewById(R.id.edtEmail);
        mEdtBusinessName = findViewById(R.id.edtBusinessName);
        mEdtAddress = findViewById(R.id.edtAddress);
        mEdtContactNumber = findViewById(R.id.edtContactNumber);
        mEdtMinimumPersons = findViewById(R.id.edtMinPersons);
        mEdtDeliverDays = findViewById(R.id.edtDeliveryDays);
        mEdtPassword = findViewById(R.id.edtPassword);
        mEdtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        mCvOpenTimings = findViewById(R.id.cvOpenTimings);
        mCvCloseTimings = findViewById(R.id.cvCloseTimings);
        mTxtOpenTimings = findViewById(R.id.txtOpenTimings);
        mTxtCloseTimings = findViewById(R.id.txtCloseTimings);
    }
}
