package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMOnagerDunecrawler extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	public IMOnagerDunecrawler() {
        name = "Onager Dunecrawlers";
        grundkosten = getPts("Onager Dunecrawler");
        power = 6;


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Eradication beamer", getPts("Eradication beamer")));
        ogE.addElement(new OptionsGruppeEintrag("Laser + Cognis stubber", "Neutron laser + Cognis heavy stubber", getPts("Neutron laser") + getPts("Cognis heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Twin h. ph. blaster", "Twin heavy phosphor blaster", getPts("Twin heavy phosphor blaster")));
        ogE.addElement(new OptionsGruppeEintrag("Icarus array", getPts("Icarus array")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cognis heavy stubber", getPts("Cognis heavy stubber")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Data-tether", "Broad spectrum data-tehter", getPts("Broad spectrum data-tether")));
        ogE.addElement(new OptionsGruppeEintrag("Smoke launchers", getPts("Smoke launcher")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}
