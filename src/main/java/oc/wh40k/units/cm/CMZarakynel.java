package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OnlineCodex;

public class CMZarakynel extends Eintrag {

    public CMZarakynel() {
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
        } else if (OnlineCodex.getInstance().getKosten() < 2664 && OnlineCodex.getInstance().getCurrentArmy().equals("Renegades and Heretics")) {
            this.setFehlermeldung("Armee < 2664 Punkte");
        } else {
            this.setFehlermeldung("");
        }
    }

}
