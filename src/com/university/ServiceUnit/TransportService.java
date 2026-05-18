package com.university.ServiceUnit;

import com.university.Interfaces.Schedulable;
import com.university.core.ServiceUnit;

import java.io.Serializable;

public class TransportService extends ServiceUnit implements Schedulable, Serializable {

    private static final long serialVersionUID = 1L;

    private String route;
    private String alternateRoute;
    private String timing;
    private int vehicleCount;

    public TransportService(
            int entityID,
            String name,
            String location,
            int serviceHours,
            int staffCount,
            String route,
            String alternateRoute,
            String timing,
            int vehicleCount) {

        super(entityID, name, location, serviceHours, staffCount);

        this.route = route;
        this.alternateRoute = alternateRoute;
        this.timing = timing;
        this.vehicleCount = vehicleCount;
    }

    @Override
    public String generateSchedule() {

        if (timing.contains("8:00")) {
            route = alternateRoute;
        }

        return "Transport Route: " + route +
                " | Vehicles: " + vehicleCount;
    }

    @Override
    public double calculateOperationalCost() {
        return (serviceHours * 250) +
                (staffCount * 1000) +
                (vehicleCount * 500);
    }

    @Override
    public String toString() {
        return name + " - " + route;
    }
}
