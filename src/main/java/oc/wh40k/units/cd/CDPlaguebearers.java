package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDPlaguebearers extends Eintrag {

    AnzahlPanel plaguebearers;
    OptionsEinzelUpgrade ridden;

    public CDPlaguebearers() {

        name = "Plaguebearers";
        grundkosten = 0;
        power = 5;

        add(plaguebearers = new AnzahlPanel(ID, randAbstand, cnt, "Plaguebearers", 10, 30, getPts("Plaguebearers")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        add(ridden = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plagueridden", getPts("Plagueridden")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = plaguebearers.getModelle();

        if (!ridden.isSelected()) ridden.setSelected(true);
    }
}
