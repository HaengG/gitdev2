package com.nslb.membermanagement.member;

import com.nslb.membermanagement.Management;

public class GeneralMember extends Management {
    public void decide(){
        super.writing=true;
        super.reading=true;
        super.delete=true;
        super.manage=false;
        super.decide();
    }
}
