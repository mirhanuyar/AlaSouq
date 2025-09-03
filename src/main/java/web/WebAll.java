package web;


import web.advert.create.AdvertCreateAll;
import web.favorite.FavoriteAll;
import web.message.*;
import web.user.information.*;

public class WebAll {
    public static void main(String[] args) throws InterruptedException {
        UserInformationAll.main(args);
        MessageAll.main(args);
        FavoriteAll.main(args);
        AdvertCreateAll.main(args);
    }
}
