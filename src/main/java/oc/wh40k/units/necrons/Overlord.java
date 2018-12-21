package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.MemberOf;
import oc.wh40k.units.UnitType;

public class Overlord<D extends Necrons.Dynasty> extends Eintrag
        implements Necrons, MemberOf<D>, Hq, CharacterModel, UnitType.Infantry, Necrons.Overlord {

    OptionsUpgradeGruppe o1;

    public Overlord() {
        name = "Overlord";
        grundkosten = getPts("Overlord");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/NEHochlord.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        ogE.addElement(new OptionsGruppeEintrag("Hyperphase sword", getPts("Hyperphase sword")));
        ogE.addElement(new OptionsGruppeEintrag("Voidblade", getPts("Voidblade")));
        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
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
