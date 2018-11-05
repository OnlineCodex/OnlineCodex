package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NELychguard extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;

    public NELychguard() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Lychguards", 5, 10, getPts("Lychguard"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
        ogE.addElement(new OptionsGruppeEintrag("Sword & Shield", "Hyperphase sword and dispersion shields", getPts("Hyperphase sword") + getPts("Dispersion shield")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ;

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
