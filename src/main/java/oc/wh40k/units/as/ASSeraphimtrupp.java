package oc.wh40k.units.as;

import oc.*;

public class ASSeraphimtrupp extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    RuestkammerStarter rkBoss;

    public ASSeraphimtrupp() {
        name = "Seraphimtrupp\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Seraphim", 5, 10, 15);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSeraphimtrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("zwei Flammen-Pistolen", 10));
        ogE.addElement(new OptionsGruppeEintrag("zwei Inferno-Pistolen", 30));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ASSeraphimPrioris", "Upgrade zur Prioris");
        rkBoss.initKammer(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
