package web.favorite;

import web.favorite.advert.*;
import web.favorite.seller.Control;
import web.favorite.seller.Create;
import web.favorite.seller.DeleteSeller;

public class FavoriteAll {
    public static void main(String[] args) {
        AddList.main(args);
        NewList.main(args);
        Rename.main(args);
        Transport.main(args);
        DeleteAdvert.main(args);
        Create.main(args);
        Control.main(args);
        DeleteSeller.main(args);
    }
}
