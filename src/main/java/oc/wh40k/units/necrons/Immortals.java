package oc.wh40k.units.necrons;

import oc.*;
import oc.wh40k.units.AOPSlot.Assault;
import oc.wh40k.units.MemberOf;
import oc.wh40k.units.UnitType.Infantry;

public class Immortals<D extends Necrons> extends Eintrag
        implements Necrons, MemberOf<D>, Assault, Infantry, Necrons.Immortals {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    boolean isPyrrhianer = false;

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
