package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class NEOverlord extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public NEOverlord() {
        name = "Overlord";
        grundkosten = getPts("Overlord");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/NEHochlord.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        ogE.addElement(new OptionsGruppeEintrag("Hyperphase sword", getPts("Hyperphase sword")));
        ogE.addElement(new OptionsGruppeEintrag("Voidblade", getPts("Voidblade")));
        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
        ogE.addElement(new OptionsGruppeEintrag("Voidcythe", getPts("Voidscythe")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Resurrection orb", getPts("Resurrection orb")));
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }

}
