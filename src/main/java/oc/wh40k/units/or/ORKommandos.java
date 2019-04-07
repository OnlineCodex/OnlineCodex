package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORKommandos extends Eintrag {

	private final AnzahlPanel kommandoz;
	private final OptionsEinzelUpgrade boss;

    public ORKommandos() {
        kategorie = 2;
        grundkosten = 0;

        kommandoz = new AnzahlPanel(ID, randAbstand, cnt, "Kommandos", 5, 15, getPts("Kommandos"));
        add(kommandoz);

        add(ico = new oc.Picture("oc/wh40k/images/Kommandoz.gif"));

        seperator();

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss Nob", getPts("Power klaw") + getPts("Slugga") + getPts("Stikkbombs")));

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        boss.setSelected(true);
        if (kommandoz.getModelle() > 10) {
            power = 6;
        } else if (kommandoz.getModelle() > 5) {
            power = 4;
        } else {
            power = 2;
        }
    }

}
