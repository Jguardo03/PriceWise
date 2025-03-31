package com.example.pricewisev2;

import android.os.Bundle;

public class MainFragmentDirections {
    public static Bundle actionMainFragmentToDashboardFragment(String textArg){
        Bundle bundle = new Bundle();
        bundle.putString("addressArg", textArg);
        return bundle;
    }
}
