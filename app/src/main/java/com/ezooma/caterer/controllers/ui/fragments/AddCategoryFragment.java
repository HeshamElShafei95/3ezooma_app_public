<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ezooma.caterer.R;
import com.ezooma.caterer.app.MyApplication;
import com.ezooma.caterer.app.rest.ResponseCallBackHandler;
import com.ezooma.caterer.app.rest.ResponseHandler;
import com.ezooma.caterer.controllers.ui.adapters.spinnerAdapters.SpinnerStringAdapter;
import com.ezooma.caterer.interfaces.HomeInterface;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.interfacesImpl.HomeInterfacesImpl;
import com.ezooma.caterer.models.categoriesModels.CategoriesAndDaysModel;
import com.ezooma.caterer.models.categoriesModels.CategoryModel;
import com.ezooma.caterer.utilities.Validations;
import com.ezooma.caterer.utilities.abstracts.BaseFragment;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.nostra13.universalimageloader.core.ImageLoader;

import net.rajpals.common.pickers.ImagePickerHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddCategoryFragment extends BaseFragment {

    private OnFragmentInteraction mListener;
    private AppCompatSpinner mSpinnerParentCategory;
    public static String TAG = AddCategoryFragment.class.getSimpleName();
    private SpinnerStringAdapter mSpinnerAdapter;
    private ArrayList<CategoryModel> mParentCategoryList = new ArrayList<>();
    private HomeInterface mHomeInterface;
    private ImagePickerHelper pickerHelper;
    private File mCategoryImageFile = null;
    private ImageLoader mImageLoader;
    private AppCompatImageView mImgCameraIcon, mImgCategory;
    private RelativeLayout mRlCategoryImage;
    private CardView mCvSaveCategory;
    private Validations mValidations;
    private AppCompatEditText mEdtCategoryName;
    private String strSubCategory = "", strParentCategory = "";
    private CategoryModel lCategoryModel;

    public AddCategoryFragment() {
        // Required empty public constructor
    }


    public static AddCategoryFragment newInstance() {
        AddCategoryFragment fragment = new AddCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View lRootView = inflater.inflate(R.layout.fragment_add_category, container, false);
        mSpinnerParentCategory = lRootView.findViewById(R.id.spinnerParentCategory);
        mRlCategoryImage = lRootView.findViewById(R.id.rlCategoryImage);
        mImgCameraIcon = lRootView.findViewById(R.id.imgCameraIcon);
        mImgCategory = lRootView.findViewById(R.id.imgCategory);
        mCvSaveCategory = lRootView.findViewById(R.id.cvSaveCategory);
        mEdtCategoryName = lRootView.findViewById(R.id.edtCategoryName);
        return lRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initVariables();
        callGetParentCategoriesApi();
        setUpParentCategorySpinner();
    }

    private void initVariables() {

        mValidations = new Validations();
        mHomeInterface = new HomeInterfacesImpl();
        mImageLoader = MyApplication.getMyApplicationInstance().getImageLoader();
        mRlCategoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermission();
            }
        });
        mCvSaveCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() == null)
                    return;
                strSubCategory = mEdtCategoryName.getText().toString().trim();
                if (lCategoryModel == null)
                    strParentCategory = "";
                else
                    strParentCategory = lCategoryModel.getCategoryName().toString().trim();
                String result = mValidations.addSubCategoryValidation(getActivity(), mCategoryImageFile, strSubCategory, strParentCategory);
                if (result.equalsIgnoreCase("")) {
                    showSuccessAlerter("", "AllGood");
                } else {
                    showErrorAlerter("", result);
                }
            }
        });
    }

    private void callGetParentCategoriesApi() {
        showCircularDialog();
        mHomeInterface.getCategoriesApi(new ResponseCallBackHandler() {
            @Override
            public void returnResponse(ResponseHandler responseHandler) {
                hideCircularDialog();
                if (responseHandler.isExecuted()) {
                    CategoriesAndDaysModel lCategoriesAndDaysModel = (CategoriesAndDaysModel) responseHandler.getValue();
                    mParentCategoryList.addAll(lCategoriesAndDaysModel.getCategories());
                    CategoryModel lCategoryModel = new CategoryModel();
                    lCategoryModel.setCategoryName("Choose parent category");
                    mParentCategoryList.add(0, lCategoryModel);
                    mSpinnerAdapter.notifyDataSetChanged();
                }

            }
        });
    }

    private void setUpParentCategorySpinner() {
        if (getActivity() == null)
            return;
        mSpinnerAdapter = new SpinnerStringAdapter<>(getActivity(), mParentCategoryList);
        mSpinnerParentCategory.setAdapter(mSpinnerAdapter);
        mSpinnerParentCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {

                    lCategoryModel = (CategoryModel) parent.getItemAtPosition(position);
                    Log.e("SELECTED_CATEgory", lCategoryModel.getCategoryName());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void askPermission() {
        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // che* ck if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            if (getActivity() == null)
                                return;
                            pickerHelper = new ImagePickerHelper(getActivity());
                            pickerHelper.showChooserDialog(new ImagePickerHelper.OnImagePickerListener() {
                                @Override
                                public void onImagePicked(File file) {
                                    long kb = file.length() / 1024;
                                    long mb = kb / 1024;
                                    Log.e(" KB", String.valueOf(kb) + "");
                                    Log.e(" MB", String.valueOf(mb) + "");
                                    showCircularDialog();
                                    pickerHelper.compressImage(file, new ImagePickerHelper.OnImageCompressListener() {
                                        @Override
                                        public void onSuccess(File file, String error) {
                                            hideCircularDialog();
                                            mCategoryImageFile = file;

                                            /*mWorkInfoTastingData.setmWineImage(mWineImageFile);*/
                                            Uri fileUri = Uri.fromFile(mCategoryImageFile);
                                            /*mWorkInfoTastingData.setmFileUri(fileUri);*/
                                            Log.e("URI", fileUri.toString());
                                            mImageLoader.displayImage(Uri.decode(fileUri.toString()), mImgCategory);
                                            mImgCameraIcon.setVisibility(View.GONE);
                                            long fileSizeInBytes = file.length();
                                            // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
                                            long fileSizeInKB = fileSizeInBytes / 1024;
                                            //  Convert the KB to MegaBytes (1 MB = 1024 KBytes)
                                            long fileSizeInMB = fileSizeInKB / 1024;
                                            Log.e("FILE SIZE KB", String.valueOf(fileSizeInKB) + "");
                                            Log.e("FILE SIZE MB", String.valueOf(fileSizeInMB) + "");
                                        }
                                    });
                                }

                                @Override
                                public void onCancelled() {
                                }
                            });
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        if (getActivity() == null)
                            return;
                        Toast.makeText(getActivity(), getString(R.string.error_occured), Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    private void showSettingsDialog() {
        if (getActivity() == null)
            return;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
        builder.setTitle(getString(R.string.need_permission));
        builder.setMessage(getString(R.string.need_permission_detail));
        builder.setPositiveButton(getString(R.string.go_to_settings), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    private void openSettings() {
        if (getActivity() == null)
            return;
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteraction) {
            mListener = (OnFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
=======
package com.ezooma.caterer.controllers.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;

public class AddCategoryFragment extends Fragment {

    private OnFragmentInteraction mListener;
    public static String TAG = AddCategoryFragment.class.getSimpleName();
    public AddCategoryFragment() {
        // Required empty public constructor
    }


    public static AddCategoryFragment newInstance() {
        AddCategoryFragment fragment = new AddCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_category, container, false);
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteraction) {
            mListener = (OnFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
