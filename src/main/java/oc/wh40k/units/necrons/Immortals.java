package oc.wh40k.units.necrons;

import oc.*;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Infantry;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class Immortals extends Eintrag<Necrons, AOPSlot.Troops> implements Infantry {

    private final AnzahlPanel squad;
    private final OptionsUpgradeGruppe o1;

    public Immortals() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Immortals", 5, 10, getPts("Immortals"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/Immortals.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gauss blaster", getPts("Gauss blaster")));
        ogE.addElement(new OptionsGruppeEintrag("Tesla carabine", getPts("Gauss blaster")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ;


        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        o1.setPreis("Gauss blaster", getPts("Gauss blaster") * squad.getModelle());
        o1.setPreis("Tesla carabine", getPts("Tesla carabine") * squad.getModelle());

        power = 4 + ((squad.getModelle() > 5) ? 4 : 0);
    }
}
