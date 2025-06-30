package web.user.information;

import web.advert.create.Vehicles;
import web.advert.create.real.estate.Building;
import web.user.information.ActiveAdvert.Actions.Edit;

public class AdvertAll {
    public static void main(String[] args) {
       Edit.main(args);
       Complaint.main(args);
       Building.main(args);
       Vehicles.main(args);
    }
}
