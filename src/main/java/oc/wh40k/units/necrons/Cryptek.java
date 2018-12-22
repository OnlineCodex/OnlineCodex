package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Infantry;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class Cryptek extends Eintrag<Necrons, Hq> implements CharacterModel, Infantry, Necrons.Cryptek {

    private final OptionsUpgradeGruppe o1;

    public Cryptek() {

        name = "Cryptek";
        grundkosten = getPts("Cryptek");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/NEHochlord.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chronometron", getPts("Chronometron")));
        ogE.addElement(new OptionsGruppeEintrag("Canoptek cloak", getPts("Canoptek cloak")));
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