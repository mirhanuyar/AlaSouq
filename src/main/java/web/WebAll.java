package web;


import mobile.message.Control;
import web.favorite.advert.*;
import web.favorite.search.ControlSearch;
import web.favorite.search.CreateSearch;
import web.favorite.search.DeleteSearch;
import web.favorite.search.RenameSearch;
import web.favorite.seller.ControlSeller;
import web.favorite.seller.CreateSeller;
import web.favorite.seller.DeleteSeller;
import web.message.*;
import web.user.information.*;

public class WebAll {
    public static void main(String[] args) throws InterruptedException {
        /*UpdatePersonelInformation.main(args);
        EmailUpdate.main(args);
        AddPhoneNumber.main(args);
        //UpdatePassword.main(args);
        //UpdateProfilePhoto.main(args);
        ChatWithAdvertOwner.main(args);
        Send.main(args);
        //SwearMessage.main(args);
        DeletedMessage.main(args);
        //Called.main(args);
        Blocked.main(args);
        AddList.main(args);
        NewList.main(args);
        //Transport.main(args);
        Rename.main(args);
        //DeleteAdvert.main(args);
        CreateSearch.main(args);
        ControlSearch.main(args);
        RenameSearch.main(args);
        DeleteSearch.main(args);*/
        CreateSeller.main(args);
        ControlSeller.main(args);
        DeleteSeller.main(args);
    }
}
