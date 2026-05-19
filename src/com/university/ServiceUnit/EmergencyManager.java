package com.university.ServiceUnit;

public class EmergencyManager {

    private SecurityService securityService;
    private HealthCentre healthCentre;

    public EmergencyManager(SecurityService securityService, HealthCentre healthCentre) {
        this.securityService = securityService;
        this.healthCentre = healthCentre;
    }


    public void reportEmergency(String location) {

        System.out.println("Emergency reported at: " + location);

        securityService.sendNotification();
        healthCentre.sendNotification();

        System.out.println(
                "Emergency handled successfully."
        );
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    public HealthCentre getHealthCentre() {
        return healthCentre;
    }



    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public void setHealthCentre(HealthCentre healthCentre) {
        this.healthCentre = healthCentre;
    }

    @Override
    public String toString() {
        return "Emergency Manager Active";
    }
}




