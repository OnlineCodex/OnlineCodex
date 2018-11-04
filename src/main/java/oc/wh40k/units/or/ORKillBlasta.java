package oc.wh40k.units.or;

import oc.*;

public class ORKillBlasta extends Eintrag {


    public ORKillBlasta() {
        name = "Kill Blasta";
        grundkosten = 330;


        add(ico = new oc.Picture("oc/wh40k/images/KillBlasta.gif"));


        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
        ogE.addElement(new OptionsGruppeEintrag("twin Big Shoota", "twin-linked Big Shoota", 15));
        ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", "twin-linked Rokkit Launcha", 20));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Bomm", 2, 20));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot sponsons", 2, 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Gunners", 25));

        complete();

    }

    public void refreshen() {
    }
}
