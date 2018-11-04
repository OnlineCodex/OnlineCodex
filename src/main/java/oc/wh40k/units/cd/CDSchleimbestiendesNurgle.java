package oc.wh40k.units.cd;


import oc.AnzahlPanel;
import oc.Eintrag;

public class CDSchleimbestiendesNurgle extends Eintrag {

    AnzahlPanel CDSchleimbestiendesNurgle;

    public CDSchleimbestiendesNurgle() {

        name = "Schleimbestien des Nurgle";

        grundkosten = 0;

        add(new AnzahlPanel(ID, randAbstand, cnt, "Schleimbestie des Nurgle", "Schleimbestien des Nurgle", 1, 9, 52));

        add(ico = new oc.Picture("oc/wh40k/images/CDSchleimbestiendesNurgle.gif"));

        seperator();

        complete();

    }

    @Override
    public void refreshen() {
    }
}
