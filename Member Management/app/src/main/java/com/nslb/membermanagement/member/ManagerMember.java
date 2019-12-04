package com.nslb.membermanagement.member;

import com.nslb.membermanagement.Management;

public class ManagerMember extends Management {
    public void decide(){
        super.writing=true;
        super.reading=true;
        super.delete=true;
        super.manage=true;
        super.decide();
    }
}
