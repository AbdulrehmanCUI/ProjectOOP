package com.university.ServiceUnit;

import com.university.Interfaces.Notifiable;

import java.io.Serializable;

public class HealthCentre implements Notifiable, Serializable {
        @Override
    public void sendNotification() {
        System.out.println("Health Centre Alert: Medical assistance team notified.");
    }
}
