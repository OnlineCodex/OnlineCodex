package oc.wh40k.units.am;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class AMManticorePlatformBattery extends Eintrag {

    AnzahlPanel Buggies;
    OptionsEinzelUpgrade RotäFarbä;
    OptionsEinzelZaehler rockets;

    public AMManticorePlatformBattery() {

        kategorie = 4;
        grundkosten = 0;

        Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Manticore Platform", "Manticore Platforms", 1, 3, 100);
        add(Buggies);

        add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
        seperator();

        add(RotäFarbä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo-netting", 20));
        add(rockets = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "4 Sky eagle rockets", 1, 0));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {


        RotäFarbä.setPreis(Buggies.getModelle() * 20);
        rockets.setMaxAnzahl(Buggies.getModelle());
    }
}
