package oc.wh40k.units.ta;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;


public class TASniperDroneTeam extends Eintrag {

	private final OptionsEinzelZaehler drohnen;

    public TASniperDroneTeam() {

        name = "Sniper Drone Team";

        grundkosten = 0;
        add(ico = new oc.Picture("oc/wh40k/images/Jagddrohnenteam.gif"));

        seperator();

        add(new AnzahlPanel(ID, randAbstand, cnt, "Jagddrohnen", 3, 9, 15));
        seperator();

        add(drohnen = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Feuerleitschütze", 3, 13));
        drohnen.setAnzahl(1);

        complete();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        if (drohnen.getAnzahl() < 1) {
            drohnen.setAnzahl(1);
        }
    }
}
