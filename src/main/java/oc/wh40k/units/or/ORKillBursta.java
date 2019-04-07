package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORKillBursta extends Eintrag {


    public ORKillBursta() {
        name = "Kill Bursta";
        grundkosten = 350;


        add(ico = new oc.Picture("oc/wh40k/images/KillBursta.gif"));


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

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bursta Kannon", 50));

        complete();

    }

}
