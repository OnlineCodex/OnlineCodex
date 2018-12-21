package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.UnitType.Infantry;

public class Lychguard extends Eintrag<Necrons, Elite, Infantry> {

    private final AnzahlPanel squad;
    private final OptionsUpgradeGruppe o1;

    public Lychguard() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Lychguards", 5, 10, getPts("Lychguard"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
        ogE.addElement(new OptionsGruppeEintrag("Sword & Shield", "Hyperphase sword and dispersion shields", getPts("Hyperphase sword") + getPts("Dispersion shield")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

        o1.setPreis("Warscythe", squad.getModelle() * getPts("Warscythe"));
        o1.setPreis("Hyperphase sword and dispersion shields", squad.getModelle() * (getPts("Hyperphase sword") + getPts("Dispersion shield")));

        power = 8 + ((squad.getModelle() > 5) ? 8 : 0);
    }
}
