package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMFenrisianWolves extends Eintrag {

    AnzahlPanel squad;
    OptionsEinzelUpgrade cyber;

    public IMFenrisianWolves() {
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Fenrisian Wolves", 5, 15, getPts("Fenrisian Wolves")));

        seperator();

        add(cyber = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cyberwolf", getPts("Cyberwolf")));

        complete();
    }

    @Override
    public void refreshen() {
        power = 2;
        if (cyber.isSelected()) {
            power += 1;
        }
        if (squad.getModelle() > 5) {
            power += 2;
        }
        if (squad.getModelle() > 10) {
            power += 2;
        }
    }

}
