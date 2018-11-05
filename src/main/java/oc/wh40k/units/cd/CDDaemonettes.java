package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDDaemonettes extends Eintrag {

    AnzahlPanel daemonettes;
    OptionsEinzelUpgrade alluress;

    public CDDaemonettes() {

        name = "Daemonettes";
        grundkosten = 0;
        power = 5;

        add(daemonettes = new AnzahlPanel(ID, randAbstand, cnt, "Daemonettes", 10, 30, getPts("Daemonettes")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        add(alluress = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Alluress", getPts("Alluress")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = daemonettes.getModelle();

        if (!alluress.isSelected()) alluress.setSelected(true);
    }
}
