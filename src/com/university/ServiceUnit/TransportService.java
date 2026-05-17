package com.university.ServiceUnit;
import com.university.Interfaces.Schedulable;

import java.io.Serializable;


public class TransportService implements Schedulable, Serializable {

        @Override
        public void generateSchedule() {

            if(timing.equals("8:00 AM")) {

                System.out.println("Peak hour detected...");
                route = alternativeRoute;

                System.out.println("Route updated dynamically");
            }else{
                route = route;
            }

            System.out.println("Transport Schedule");
            System.out.println("Bus Number: " + busNo);
            System.out.println("Route: " + route);
            System.out.println("Time: " + timing);
        }
    }
}
