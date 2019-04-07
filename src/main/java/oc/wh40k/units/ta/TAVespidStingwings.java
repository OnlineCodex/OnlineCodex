package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TAVespidStingwings extends Eintrag {

	private final AnzahlPanel squad;
	public TAVespidStingwings() {
        name = "Vespid Stingwings";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Vespid Stingwings", 4, 12, getPts("Vespid Stingwings") + getPts("Neutron blaster"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/VespidStachelfluegel.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vespid Strain Leader", getPts("Vespid Strain Leader")));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 8) {
            power = 8;
        } else if (squad.getModelle() > 4) {
            power = 6;
        } else {
            power = 3;
        }
    }
}
