package universe.com.universe.android.dao;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gaurav.pandey on 28-12-2017.
 */

public class StateList {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
    public static final StateList[] stateLists = {
            new StateList("Andhra Pradesh"),
            new StateList("Arunachal Pradesh"),
            new StateList("Assam"),
            new StateList("Bihar"),
            new StateList("Chhattisgarh"),
            new StateList("Goa"),
            new StateList("Gujarat"),
            new StateList("Haryana"),
            new StateList("Himachal Pradesh"),
            new StateList("Jammu and Kashmir"),
            new StateList("Jharkhand"),
            new StateList("Karnataka"),
            new StateList("Kerala"),
            new StateList("Madhya Pradesh"),
            new StateList("Maharashtra"),
            new StateList("Manipur"),
            new StateList("Meghalaya"),
            new StateList("Mizoram"),
            new StateList("Nagaland"),
            new StateList("Odisha"),
            new StateList("Punjab"),
            new StateList("Rajasthan"),
            new StateList("Sikkim"),
            new StateList("Tamil Nadu"),
            new StateList("Telangana"),
            new StateList("Tripura"),
            new StateList("Uttar Pradesh"),
            new StateList("Uttarakhand"),
            new StateList("West Bengal"),
    };


    public StateList(String name) {
        this.name = name;
    }

        /*
     *      GENERIC STATIC FUNCTIONS
     */

    private static List<StateList> allCountriesList;

    public static List<StateList> getAllCountries() {
        if (allCountriesList == null) {
            allCountriesList = Arrays.asList(stateLists);
        }
        return allCountriesList;
    }


}
