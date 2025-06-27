package web;


import web.favorite.advert.*;
import web.message.*;
import web.user.information.*;

public class WebAll {
    public static void main(String[] args) throws InterruptedException {
        UpdatePersonelInformation.main(args);
        EmailUpdate.main(args);
        AddPhoneNumber.main(args);
        //UpdatePassword.main(args);
        //UpdateProfilePhoto.main(args);
        ChatWithAdvertOwner.main(args);
        Send.main(args);
        //SwearMessage.main(args);
        DeletedMessage.main(args);
        Called.main(args);
        Blocked.main(args);
        AddList.main(args);
        NewList.main(args);
        Transport.main(args);
        Rename.main(args);
        DeleteAdvert.main(args);
    }
}
