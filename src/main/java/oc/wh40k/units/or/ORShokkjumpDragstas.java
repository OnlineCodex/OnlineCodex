package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;

public class ORShokkjumpDragstas extends Eintrag {

    private final AnzahlPanel buggies;

    public ORShokkjumpDragstas() {
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Shokkjump Dragsta", "Shokkjump Dragstas", 1, 3, getPts("Shokkjump Dragstas") + getPts("Rokkit launcha"));
        add(buggies);

        add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        power = buggies.getModelle() * 6;
    }
}
