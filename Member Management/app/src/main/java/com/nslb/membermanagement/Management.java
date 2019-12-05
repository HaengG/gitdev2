package com.nslb.membermanagement;

import com.nslb.membermanagement.ManagementListener;

public class Management {
    private ManagementListener managementListener = null;
    protected String strmember;
    protected boolean writing, reading, delete, manage;

    public void show(){managementListener.onManagement(strmember);}

    public void decide(){managementListener.onLogin(writing, reading, delete, manage);}

    public void onManagementListener(ManagementListener listener){
        this.managementListener = listener;
    }
}
