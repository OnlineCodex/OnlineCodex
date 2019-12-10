package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMScorpiusDunerider extends Eintrag {

	private final OptionsUpgradeGruppe o1, o3;
	private final OptionsEinzelUpgrade o2;
	public IMScorpiusDunerider() {
        name = "Scorpius Dunerider";
        grundkosten = getPts("Scorpius Dunerider");
        power = 6;


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin cognis heavy stubber", getPts("Twin cognis heavy stubber")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "2 Cognis heavy stubber", getPts("Cognis heavy stubber")*2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Data-tether", "Broad spectrum data-tehter", getPts("Broad spectrum data-tether")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.setSelected(true);
        o3.alwaysSelected();
    }
}
