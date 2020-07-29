package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMDeathstrike extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	public IMDeathstrike() {
        name = "Deathstrike";
        grundkosten = getPts("Deathstrike") + getPts("Deathstrike missile");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AM other)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Augur array", getPts("Augur array")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", getPts("Dozer blade")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Track guards", getPts("Track guards")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}
