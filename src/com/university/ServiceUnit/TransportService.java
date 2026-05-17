package com.university.ServiceUnit;

import com.university.Interfaces.Schedulable;

public class TransportService implements Schedulable {

        private String route;
        private String alternativeRoute;
        private String timing;
        private int busNo;

        public TransportService(String route, String alternativeRoute,
                                String timing, int busNo) {

            this.route = route;
            this.alternativeRoute = alternativeRoute;
            this.timing = timing;
            this.busNo = busNo;
        }

        public String getRoute() {
            return route;
        }

        public String getAlternativeRoute() {
            return alternativeRoute;
        }

        public String getTiming() {
            return timing;
        }

        public int getBusNo() {
            return busNo;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public void setAlternativeRoute(String alternativeRoute) {
            this.alternativeRoute = alternativeRoute;
        }

        public void setTiming(String timing) {
            this.timing = timing;
        }

        public void setBusNo(int busNo) {
            this.busNo = busNo;
        }

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
