package mobile.favorite;


import mobile.favorite.advert.*;
import mobile.favorite.search.ControlSearch;
import mobile.favorite.search.CreateSearch;
import mobile.favorite.search.DeleteSearch;
import mobile.favorite.search.RenameSearch;

public class FavoriteAll {
    public static void main(String[] args) {
        AddList.main(args);
        Rename.main(args);
        NewList.main(args);
        Transport.main(args);
        Delete.main(args);
        CreateSearch.main(args);
        ControlSearch.main(args);
        RenameSearch.main(args);
        DeleteSearch.main(args);

    }
}
