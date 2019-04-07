package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMInceptorSquad extends Eintrag {
	private final AnzahlPanel squad;
	private final OptionsUpgradeGruppe o1;

    public IMInceptorSquad() {
        name = "Inceptor Squad";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Inceptor", 3, 6, getPts("Inceptor Squad") + getPts("Heavy bolt pistol") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)") + getPts("Shock grenades"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Assault bolters", getPts("Assault bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma exterminator", getPts("Plasma exterminator")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o1.setPreis(0, squad.getModelle() * getPts("Assault bolter") * 2);
        o1.setPreis(1, squad.getModelle() * getPts("Plasma exterminator") * 2);

        if (squad.getModelle() <= 3)
            power = 10;
        else
            power = 20;
    }
}
