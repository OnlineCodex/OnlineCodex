package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AEWarWalkers extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;

    public AEWarWalkers() {

        name = "War Walkers";

        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "War Walkers", 1, 3, getPts("War Walkers"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Aeldari missile launcher", getPts("Aeldari missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Bright lance", getPts("Bright lance")));
        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", getPts("Scatter laser")));
        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Starcannon", getPts("Starcannon")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2 * squad.getModelle()));
        o1.setAnzahl(3, 2);
        complete();

    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle() * 2);
        o1.setLegal((squad.getModelle() * 2) == o1.getAnzahl());
        power = squad.getModelle() * 5;
    }

}
