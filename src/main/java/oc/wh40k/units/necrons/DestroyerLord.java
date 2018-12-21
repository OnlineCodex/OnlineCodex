package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.*;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Dynasty;

public class DestroyerLord<D extends Dynasty> extends Eintrag
        implements Necrons, MemberOf<D>, Hq, CharacterModel, Infantry, Fly, Necrons.DestroyerLord {

    OptionsUpgradeGruppe o1;

    public DestroyerLord() {
        name = "Destroyer Lord";
        grundkosten = getPts("Destroyer Lord");
        power = 7;

        add(ico = new oc.Picture("oc/wh40k/images/NEHochlord.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        ogE.addElement(new OptionsGruppeEintrag("Hyperphase sword", getPts("Hyperphase sword")));
        ogE.addElement(new OptionsGruppeEintrag("Voidblade", getPts("Voidblade")));
        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Resurrection orb", getPts("Resurrection orb")));
        ogE.addElement(new OptionsGruppeEintrag("Phylactery", getPts("Phylactery")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }
}