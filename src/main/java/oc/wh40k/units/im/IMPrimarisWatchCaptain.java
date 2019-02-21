package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisWatchCaptain extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;
	private final OptionsEinzelUpgrade fist;

    public IMPrimarisWatchCaptain() {
        name = "Primaris Watch Captain";
        grundkosten = getPts("Primaris Watch Captain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 6;

        ogE.addElement(new OptionsGruppeEintrag("MC Auto bolt rifle", getPts("Master crafted auto bolt rifle (DW)")));
        ogE.addElement(new OptionsGruppeEintrag("MC Stalker bolt rifle", getPts("Master crafted stalker bolt rifle (DW)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword (SM)")));

        seperator();

        add(fist = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist & plasma pistol", getPts("Power fist (SM)") + getPts("Plasma pistol (SM)")));

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o1.setAktiv(!fist.isSelected());
        o2.setAktiv(!fist.isSelected());
    }
}
