package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.*;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.UnitType.Vehicle;

public class CatacombCommandBarge extends Eintrag<Necrons, Hq, Vehicle>
        implements CharacterModel, Necrons.Overlord, Fly, Unique {

    private final OptionsUpgradeGruppe o1;
    private final OptionsUpgradeGruppe o2;

    public CatacombCommandBarge() {
        name = "Catacomb Command Barge";
        grundkosten = getPts("Catacomb Command Barge");
        power = 9;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        ogE.addElement(new OptionsGruppeEintrag("Hyperphase sword", getPts("Hyperphase sword")));
        ogE.addElement(new OptionsGruppeEintrag("Voidblade", getPts("Voidblade")));
        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Resurrection orb", getPts("Resurrection orb")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gauss cannon", getPts("Gauss cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Tesla cannon", getPts("Tesla cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);
    }
}
