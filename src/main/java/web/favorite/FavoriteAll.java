package web.favorite;

import web.favorite.advert.*;
import web.favorite.search.ControlSearch;
import web.favorite.search.CreateSearch;
import web.favorite.search.DeleteSearch;
import web.favorite.search.RenameSearch;
import web.favorite.seller.ControlSeller;
import web.favorite.seller.CreateSeller;
import web.favorite.seller.DeleteSeller;

public class FavoriteAll {
    public static void main(String[] args) {
        AddList.main(args);
        NewList.main(args);
        Rename.main(args);
        //Transport.main(args);
        //DeleteAdvert.main(args);
        CreateSeller.main(args);
        ControlSeller.main(args);
        DeleteSeller.main(args);
        CreateSearch.main(args);
        RenameSearch.main(args);
        ControlSearch.main(args);
        DeleteSearch.main(args);
    }
}
