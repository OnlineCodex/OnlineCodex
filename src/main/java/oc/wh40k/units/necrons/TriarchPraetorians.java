package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.Fly;
import oc.wh40k.units.UnitType;
import oc.wh40k.units.UnitType.Infantry;

public class TriarchPraetorians extends Eintrag
        implements Necrons, Elite, Infantry, Fly, Necrons.TriarchPraetorians {

    private final AnzahlPanel squad;
    private final OptionsUpgradeGruppe o1;

    public TriarchPraetorians() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Triarch Praetorians", 5, 10, getPts("Triarch Praetorians"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEPraetorianerdesTriarchats.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Rod of covenant", getPts("Rod of covenant")));
        ogE.addElement(new OptionsGruppeEintrag("Voidblade & caster", "Voidblade and Particle casters", getPts("Voidblade") + getPts("Particle caster")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

        o1.setPreis("Rod of covenant", squad.getModelle() * getPts("Rod of covenant"));
        o1.setPreis("Voidblade and Particle casters", squad.getModelle() * (getPts("Voidblade") + getPts("Particle caster")));

        power = 8 + ((squad.getModelle() > 5) ? 8 : 0);
    }
}