package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public abstract class AEWalkers extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe weapons;
    private final int powerPerUnit;

    protected AEWalkers(String name, int powerPerUnit) {
        this.powerPerUnit = powerPerUnit;
        this.name = name;

        squad = new AnzahlPanel(ID, randAbstand, cnt, name, 1, 3, getPts(name));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Aeldari missile launcher", getPts("Aeldari missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Bright lance", getPts("Bright lance")));
        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", getPts("Scatter laser")));
        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Starcannon", getPts("Starcannon")));
        add(weapons = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2 * squad.getModelle()));
        weapons.setAnzahl(3, 2);
        complete();
    }

    @Override
    public void refreshen() {
        weapons.setMaxAnzahl(squad.getModelle() * 2);
        weapons.setLegal((squad.getModelle() * 2) == weapons.getAnzahl());
        power = squad.getModelle() * powerPerUnit;
    }
}