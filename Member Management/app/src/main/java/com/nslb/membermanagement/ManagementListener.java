package com.nslb.membermanagement;

public interface ManagementListener {
     void onManagement(String member);
     void onLogin(boolean writing, boolean reading, boolean delete, boolean manage);
}
