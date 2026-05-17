package com.university.ServiceUnit;

import com.university.Interfaces.Notifiable;

public class HealthCentre implements Notifiable {
    @Override
    public void sendNotification() {
        System.out.println("Health Centre Alert: Medical assistance team notified.");
    }
}
