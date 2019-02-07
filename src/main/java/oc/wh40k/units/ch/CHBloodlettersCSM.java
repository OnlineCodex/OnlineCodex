package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CHBloodlettersCSM extends Eintrag {

    AnzahlPanel bloodletters;
    OptionsEinzelUpgrade reaper;

    public CHBloodlettersCSM() {

        name = "Bloodletters";
        grundkosten = 0;
        power = 5;

        add(bloodletters = new AnzahlPanel(ID, randAbstand, cnt, "Bloodletters", 10, 30, getPts("Bloodletters CSM")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon CSM")));

        seperator();

        add(reaper = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bloodreaper", getPts("Bloodreaper")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        if (!reaper.isSelected()) reaper.setSelected(true);

        power = 5 +
                ((bloodletters.getModelle() == 20) ? 5 : 0) +
                ((bloodletters.getModelle() == 30) ? 10 : 0);
    }
}
