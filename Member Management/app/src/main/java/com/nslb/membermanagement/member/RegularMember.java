package com.nslb.membermanagement.member;

import com.nslb.membermanagement.Management;

public class RegularMember extends Management {
    public void decide(){
        super.writing=false;
        super.reading=true;
        super.delete=false;
        super.manage=false;
        super.decide();
    }
}
