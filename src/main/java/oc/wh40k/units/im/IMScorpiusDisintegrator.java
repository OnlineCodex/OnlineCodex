package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMScorpiusDisintegrator extends Eintrag {

	private final OptionsUpgradeGruppe o1, o3, o4;
	private final OptionsEinzelUpgrade o2;
	public IMScorpiusDisintegrator() {
        name = "Scorpius Disintegrator";
        grundkosten = getPts("Scorpius Disintegrator");
        power = 6;


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Disruptor missile launcher", getPts("Disruptor missile launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "3 Cognis heavy stubber", getPts("Cognis heavy stubber")*3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Data-tether", "Broad spectrum data-tehter", getPts("Broad spectrum data-tether")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Ferrumite cannon", getPts("Ferrumite cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Belleros energy cannon", getPts("Belleros energy cannon")));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.setSelected(true);
        o3.alwaysSelected();
        o4.alwaysSelected();
    }
}
