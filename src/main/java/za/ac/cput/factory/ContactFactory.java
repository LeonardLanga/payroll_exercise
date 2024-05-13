package za.ac.cput.factory;

import za.ac.cput.domain.demography.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory
{
    public static Contact buildContact(String email, String mobile, String workTelephone){
        if (!Helper.isValidEmailAddress(email) || Helper.isDigitsOrIsTen(mobile) || Helper.isDigitsOrIsTen(workTelephone))
            return null;
        return new Contact.Builder().setEmail(email)
                .setMobile(mobile)
                .setWorkTelephone(workTelephone)
                .build();
    }

}
