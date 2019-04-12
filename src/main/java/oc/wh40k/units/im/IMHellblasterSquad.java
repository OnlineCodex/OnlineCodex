package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMHellblasterSquad extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;
	private final OptionsEinzelUpgrade sergeant;
	private final AnzahlPanel squad;

    public IMHellblasterSquad() {
        name = "Hellblaster Squad";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Hellblaster", 5, 10, getPts("Hellblaster Squad") + getPts("Bolt pistol") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)") + getPts("Shock grenades"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Plasma incinerator", getPts("Plasma incinerator")));
        ogE.addElement(new OptionsGruppeEintrag("Assault plasma incinerator", getPts("Assault plasma incinerator")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy plasma incinerator", getPts("Heavy plasma incinerator")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hellblaster Sergeant", getPts("Hellblaster Sergeant")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
    }

    @Override
    public void refreshen() {
        sergeant.setSelected(true);
        o1.setPreis(0, (squad.getModelle() * getPts("Plasma incinerator")));
        o1.setPreis(1, (squad.getModelle() * getPts("Assault plasma incinerator")));
        o1.setPreis(2, (squad.getModelle() * getPts("Heavy plasma incinerator")));
        o1.alwaysSelected();
        o2.alwaysSelected();

        if (squad.getModelle() < 10)
            power = 8;
        else
            power = 16;
    }
}
