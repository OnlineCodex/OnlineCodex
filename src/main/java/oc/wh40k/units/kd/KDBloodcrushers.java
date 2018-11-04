package oc.wh40k.units.kd;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class KDBloodcrushers extends Eintrag {

    AnzahlPanel CDZerschmettererdesKhorne;
    OptionsEinzelUpgrade Blutjaeger, Chaosikone;

    public KDBloodcrushers() {

        name = "Bloodcrushers";

        grundkosten = 0;

        CDZerschmettererdesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Bloodcrushers", 3, 9, 45);

        add(CDZerschmettererdesKhorne);

        add(ico = new oc.Picture("oc/wh40k/images/CDZerschmettererdesKhorne.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 10));
        add(Chaosikone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blutbanner", 20));

        seperator();

        add(Blutjaeger = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blutjäger", 5));

        seperator();

        complete();

    }

    @Override
    public void refreshen() {
    }
}
