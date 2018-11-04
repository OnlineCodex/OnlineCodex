package oc.wh40k.units.cs;

import oc.Eintrag;
import oc.OnlineCodex;

public class CSZarakynel extends Eintrag {

    public CSZarakynel() {
        name = "Zarakynel";
        grundkosten = 666;

        add(ico = new oc.Picture("oc/wh40k/images/Zarakynel.gif"));


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        if (OnlineCodex.getInstance().getKosten() < 2000 && OnlineCodex.getInstance().getCurrentArmy().equals("Chaosdaemonen")) {
            this.setFehlermeldung("Armee < 2000 Punkte");
        } else {
            this.setFehlermeldung("");
        }
    }

}
