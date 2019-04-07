package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;

public class ORKustomBoostaBlastas extends Eintrag {

	private final AnzahlPanel buggies;

    public ORKustomBoostaBlastas() {

        kategorie = 4;
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Kustom Boosta-Blasta", "Kustom Boosta-Blastas", 1, 3, getPts("Kustom Boosta-Blastas"));
        add(buggies);

        add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
        seperator();

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {

        power = buggies.getModelle() * 5;
    }
}
