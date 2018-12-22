package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.wh40k.units.AOPSlot.FastAttack;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Biker;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class TombBlades extends Eintrag<Necrons, FastAttack> implements Biker, Fly {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1x;
    private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o2;
    private final OptionsZaehlerGruppe o3;

    public TombBlades() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tomb Blades", 3, 9, getPts("Tomb blades"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/TombBlades.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Gauss blasters", getPts("Gauss blaster") * 2));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("2 Tesla carabine", getPts("Tesla carabine") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Particle beamer", getPts("Particle beamer")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shieldvanes", getPts("Shieldvanes")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nebuloscope", getPts("Nebuloscope")));
        ogE.addElement(new OptionsGruppeEintrag("Shadowloom", getPts("Shadowloom")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        complete();
    }

    @Override
    public void refreshen() {

        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle());

        o2.setMaxAnzahl(squad.getModelle());
        o3.setMaxAnzahl(squad.getModelle());

        power = 5 + ((squad.getModelle() > 3) ? 5 : 0) + ((squad.getModelle() > 6) ? 4 : 0);
    }
}