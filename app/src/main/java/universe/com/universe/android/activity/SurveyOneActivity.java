package universe.com.universe.android.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsStates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import universe.com.universe.android.R;
import universe.com.universe.android.adapter.StateAdapter;
import universe.com.universe.android.dao.State;
import universe.com.universe.android.locationutils.PermissionUtils;
import universe.com.universe.android.utils.RecyclerTouchListener;


/**
 * Created by gaurav.pandey on 09-01-2018.
 */

public class SurveyOneActivity extends BaseActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ActivityCompat.OnRequestPermissionsResultCallback,
        PermissionUtils.PermissionResultCallback {

    private static final String TAG = SurveyOneActivity.class.getSimpleName();
    ArrayList<State> stateLists;
    LinearLayoutManager linearLayoutManager;
    StateAdapter stateAdapter;
    Dialog dialog;
    DatePickerDialog datePickerDialog;

    private final static int PLAY_SERVICES_REQUEST = 1000;
    private final static int REQUEST_CHECK_SETTINGS = 2000;
    private Location mLastLocation;

    EditText editTextDate;
    EditText editTextState, editTextLocation;
    RecyclerView recyclerViewSearchList;
    EditText editTextSearch;
    ImageView imageViewLocation;

    // Google client to interact with Google API

    private GoogleApiClient mGoogleApiClient;

    double latitude;
    double longitude;

    // list of permissions
    ArrayList<String> permissions = new ArrayList<>();
    PermissionUtils permissionUtils;
    boolean isPermissionGranted;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);
        initialization();
        setUpElements();
    }


    private void setUpElements() {
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog = new DatePickerDialog(SurveyOneActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                editTextDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        editTextState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create custom dialog object
                dialog = new Dialog(SurveyOneActivity.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_state_fragment);
                // Set dialog title
                dialog.setTitle("Custom Dialog");
                stateLists = new ArrayList<>();

                // set values for custom dialog components - text, image and button
                editTextSearch = dialog.findViewById(R.id.dateEditText);
                recyclerViewSearchList = dialog.findViewById(R.id.recyclerviewStateList);
                stateLists = new ArrayList<>();
                linearLayoutManager = new LinearLayoutManager(SurveyOneActivity.this);
                stateAdapter = new StateAdapter(mContext, stateLists);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SurveyOneActivity.this);
                recyclerViewSearchList.setLayoutManager(mLayoutManager);
                recyclerViewSearchList.setItemAnimator(new DefaultItemAnimator());
                recyclerViewSearchList.setAdapter(stateAdapter);
                setUpData();
                setUpDialogListeners();
                dialog.show();
            }
        });


       imageViewLocation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getLocation();
               if (mLastLocation != null) {
                   latitude = mLastLocation.getLatitude();
                   longitude = mLastLocation.getLongitude();
                   getAddress();
               }
           }
       });


    }

    private void setUpDialogListeners() {
        recyclerViewSearchList.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerViewSearchList, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                State state = stateLists.get(position);
                editTextState.setText(state.getTitle());
                dialog.dismiss();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void setUpData() {
        State state = new State("Andhra Pradesh");
        stateLists.add(state);

        state = new State("Arunachal Pradesh");
        stateLists.add(state);

        state = new State("Assam");
        stateLists.add(state);

        state = new State("Bihar");
        stateLists.add(state);

        state = new State("Chhattisgarh");
        stateLists.add(state);

        state = new State("Goa");
        stateLists.add(state);

        state = new State("Gujarat");
        stateLists.add(state);

        state = new State("Haryana");
        stateLists.add(state);

        state = new State("Himachal Pradesh");
        stateLists.add(state);

        state = new State("Jammu and Kashmir");
        stateLists.add(state);

        state = new State("Jharkhand");
        stateLists.add(state);

        state = new State("Kerala");
        stateLists.add(state);

        state = new State("Madhya Pradesh");
        stateLists.add(state);

        state = new State("Maharashtra");
        stateLists.add(state);

        state = new State("Mizoram");
        stateLists.add(state);

        state = new State("Nagaland");
        stateLists.add(state);

        state = new State("Odisha");
        stateLists.add(state);

        state = new State("Punjab");
        stateLists.add(state);

        state = new State("Rajasthan");
        stateLists.add(state);

        state = new State("Sikkim");
        stateLists.add(state);

        state = new State("Tamil Nadu");
        stateLists.add(state);

        state = new State("Uttar Pradesh");
        stateLists.add(state);

        state = new State("Uttarakhand");
        stateLists.add(state);

        state = new State("West Bengal");
        stateLists.add(state);

        stateAdapter.notifyDataSetChanged();
    }


    private void setUpAdapter() {

    }


    private void initialization() {
        editTextDate = findViewById(R.id.dateEditText);
        editTextState = findViewById(R.id.stateList);
        editTextLocation = findViewById(R.id.editTextLocation);
        imageViewLocation = findViewById(R.id.imageViewLocation);

        permissionUtils = new PermissionUtils(SurveyOneActivity.this);

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        permissionUtils.check_permission(permissions, "Need GPS permission for getting your location", 1);


    }

    /**
     * Method to display the location on UI
     */

    private void getLocation() {

        if (isPermissionGranted) {

            try {
                mLastLocation = LocationServices.FusedLocationApi
                        .getLastLocation(mGoogleApiClient);
            } catch (SecurityException e) {
                e.printStackTrace();
            }

        }

    }

    public void getAddress() {

        Address locationAddress = getAddress(latitude, longitude);
        if (locationAddress != null) {
            String address = locationAddress.getAddressLine(0);
            String address1 = locationAddress.getAddressLine(1);
            String city = locationAddress.getLocality();
            String state = locationAddress.getAdminArea();
            String country = locationAddress.getCountryName();
            String postalCode = locationAddress.getPostalCode();

            String currentLocation;

            if (!TextUtils.isEmpty(address)) {
                currentLocation = address;

                if (!TextUtils.isEmpty(address1))
                    currentLocation += "\n" + address1;

                if (!TextUtils.isEmpty(city)) {
                    currentLocation += "\n" + city;

                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation += " - " + postalCode;
                } else {
                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation += "\n" + postalCode;
                }

                if (!TextUtils.isEmpty(state))
                    currentLocation += "\n" + state;

                if (!TextUtils.isEmpty(country))
                    currentLocation += "\n" + country;

                editTextLocation.setText(currentLocation);

            }
        }
    }

    public Address getAddress(double latitude, double longitude) {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            return addresses.get(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }

    /**
     * Method to verify google play services on the device
     */

    private boolean checkPlayServices() {

        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();

        int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(this);

        if (resultCode != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(resultCode)) {
                googleApiAvailability.getErrorDialog(this, resultCode,
                        PLAY_SERVICES_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        getLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void PermissionGranted(int request_code) {
        isPermissionGranted = true;
    }

    @Override
    public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {


    }

    @Override
    public void PermissionDenied(int request_code) {

    }

    @Override
    public void NeverAskAgain(int request_code) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // redirects to utils
        permissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final LocationSettingsStates states = LocationSettingsStates.fromIntent(data);
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        // All required changes were successfully made
                        getLocation();
                        break;
                    case Activity.RESULT_CANCELED:
                        // The user was asked to change settings, but chose not to
                        break;
                    default:
                        break;
                }
                break;
        }
    }


}
