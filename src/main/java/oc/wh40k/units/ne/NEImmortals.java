package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NEImmortals extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsUpgradeGruppe o1;

    public NEImmortals() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Immortals", 5, 10, getPts("Immortals"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEImmortals.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gauss blaster", getPts("Gauss blaster")));
        ogE.addElement(new OptionsGruppeEintrag("Tesla carabine", getPts("Gauss blaster")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();
        


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
