package com.university.ServiceUnit;

import com.university.Interfaces.Notifiable;

import java.io.Serializable;

public class SecurityService implements Notifiable, Serializable {
    @Override
    public void sendNotification(){
        System.out.println("Security Service Alert: Emergency situation detected on campus. Security personnel have been dispatched.");

    }
}
