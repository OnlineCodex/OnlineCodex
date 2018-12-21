package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.wh40k.units.AOPSlot.FastAttack;
import oc.wh40k.units.MemberOf;
import oc.wh40k.units.UnitType.Beasts;

public class CanoptekWraiths<D extends Necrons> extends Eintrag
        implements Necrons, Necrons.Canoptek, MemberOf<D>, FastAttack, Beasts, Necrons.CanoptekWraiths {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1;

    public CanoptekWraiths() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Wraith", "Canoptek Wraiths", 3, 6, getPts("Canoptek Wraiths") + getPts("Vicious claws"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechPhantome.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Particle caster", getPts("Particle caster")));
        ogE.addElement(new OptionsGruppeEintrag("Transdimensional beamer", getPts("Transdimensional beamer")));
        ogE.addElement(new OptionsGruppeEintrag("Whip coils", getPts("Whip coils")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());

        power = 9 + ((squad.getModelle() > 3) ? 9 : 0);
    }
}