package web.user.information;

import web.user.information.statistic.favorite.StatisticFavorite;
import web.user.information.statistic.message.StatisticMessage;
import web.user.information.statistic.view.StatisticView;

public class UserInformationAll {
    public static void main(String[] args) {
        UpdatePersonelInformation.main(args);
        EmailUpdate.main(args);
        AddPhoneNumber.main(args);
        //UpdateProfilePhoto.main(args);
        //UpdatePassword.main(args);
        //StatisticFavorite.main(args);
        //StatisticMessage.main(args);
        //StatisticView.main(args);
    }
}
