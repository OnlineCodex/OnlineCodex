package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class ORTankbustas extends Eintrag {

	private final AnzahlPanel Panzaknakkaz;
	private final OptionsEinzelZaehler Sprengsquiks;
	private final OptionsEinzelZaehler Panzakloppa;
	private final OptionsEinzelZaehler Pistolen;

    public ORTankbustas() {

        kategorie = 2;
        grundkosten = 0;
        add(Panzaknakkaz = new AnzahlPanel(ID, randAbstand, cnt, "Tankbustas", 5, 15, getPts("Tankbustas") + getPts("Rokkit launcha") + getPts("Stikkbombs") + getPts("Tankbusta bombs")));
        add(ico = new oc.Picture("oc/wh40k/images/Panzaknakkaz.gif"));

        seperator();

        add(Sprengsquiks = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Bomb Squigs", 2, getPts("Bomb Squig")));
        add(Panzakloppa = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Tankhammer", 2, getPts("Tankhammer") - getPts("Rokkit launcha")));
        add(Pistolen = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Pair of rokkit pistols", 1, getPts("Pair of rokkit pistols") - getPts("Rokkit launcha")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss Nob", getPts("Boss Nob")));

        seperator();

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        Sprengsquiks.setMaxAnzahl(Panzaknakkaz.getModelle() / 5 * 2);
        Pistolen.setMaxAnzahl(Panzaknakkaz.getModelle() / 5);
        if (Panzaknakkaz.getModelle() > 10) {
            power = 13;
        } else if (Panzaknakkaz.getModelle() > 5) {
            power = 8;
        } else {
            power = 4;
        }
    }
}
