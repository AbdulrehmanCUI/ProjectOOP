package com.university.ServiceUnit;

public class EmergencyManager {

    /*
     * ATTRIBUTES
     */
    private SecurityService securityService;

    private HealthCentre healthCentre;

    /*
     * CONSTRUCTOR
     */
    public EmergencyManager(
            SecurityService securityService,
            HealthCentre healthCentre) {

        this.securityService = securityService;

        this.healthCentre = healthCentre;
    }

    /*
     * REPORT EMERGENCY
     */
    public void reportEmergency(String location) {

        System.out.println(
                "Emergency reported at: "
                        + location
        );

        /*
         * NOTIFY SECURITY
         */
        securityService.sendNotification();

        /*
         * NOTIFY HEALTH CENTRE
         */
        healthCentre.sendNotification();

        System.out.println(
                "Emergency handled successfully."
        );
    }

    /*
     * GETTERS
     */
    public SecurityService getSecurityService() {

        return securityService;
    }

    public HealthCentre getHealthCentre() {

        return healthCentre;
    }

    /*
     * SETTERS
     */
    public void setSecurityService(
            SecurityService securityService) {

        this.securityService = securityService;
    }

    public void setHealthCentre(
            HealthCentre healthCentre) {

        this.healthCentre = healthCentre;
    }

    /*
     * toString()
     */
    @Override
    public String toString() {

        return "Emergency Manager Active";
    }
}