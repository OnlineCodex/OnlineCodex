package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AETroupe extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o2;

    public AETroupe() {
        name = "Troupe";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Troupe", 5, 12, getPts("Troupe"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol (Harlequins)")));
        ogE.addElement(new OptionsGruppeEintrag("Neuro disruptor", getPts("Neuro disruptor")));
        ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol (Harlequins)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Harlequin's blade", getPts("Harlequin's blade")));
        ogE.addElement(new OptionsGruppeEintrag("Harlequin's embrace", getPts("Harlequin's embrace")));
        ogE.addElement(new OptionsGruppeEintrag("Harlequin's kiss", getPts("Harlequin's kiss")));
        ogE.addElement(new OptionsGruppeEintrag("Harlequin's caress", getPts("Harlequin's caress")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());

        power = 2 + squad.getModelle();
    }
}