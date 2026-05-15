package com.university;

import com.university.Facility.*;
import com.university.ServiceUnit.*;

public class CampusZone {
        Library library;
        Cafeteria cafeteria;

        TransportService transport;
        SecurityService security;

        CampusZone(){
            library = null;
            cafeteria = null;
            transport = null;
            security = null;

        }

        CampusZone(Library library, Cafeteria cafeteria,TransportService transport,SecurityService security)
        {
            this.library = library;
            this.cafeteria = cafeteria;
            this.transport = transport;
            this.security = security;
        }
        
}
