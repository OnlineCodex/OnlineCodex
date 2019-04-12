package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;

public class ORSkorchas extends Eintrag {

	private final AnzahlPanel Buggies;

    public ORSkorchas() {

        category = 4;
        grundkosten = 0;

        Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Skorcha", "Skorchas", 1, 5, getPts("Skorchas") + getPts("Skorcha"));
        add(Buggies);

        add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
        seperator();

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        if (Buggies.getModelle() > 3) {
            power = 16;
        } else if (Buggies.getModelle() > 1) {
            power = 10;
        } else {
            power = 4;
        }
    }
}
