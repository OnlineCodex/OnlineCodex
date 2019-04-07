package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMInfiltratorSquad extends Eintrag {
	private final OptionsEinzelUpgrade sergeant, helixAdept;
	private final OptionsUpgradeGruppe o1, o2, o3;
	private final AnzahlPanel squad;

    public IMInfiltratorSquad() {
        name = "Infiltrator Squad";

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Infiltrator", 5, 9, getPts("Infiltrator Squad") + getPts("Bolt pistol (SM)") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)") + getPts("Shock grenades"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt carbines", getPts("Bolt carbine")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(helixAdept = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Infiltrator Helix Adept", getPts("Infiltrator Helix Adept")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt carbine & Bolt pistol", getPts("Bolt carbine") + getPts("Bolt pistol (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Infiltrator Sergeant", getPts("Infiltrator Sergeant")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt carbine & Bolt pistol", getPts("Bolt carbine") + getPts("Bolt pistol (SM)")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
    }

    @Override
    public void refreshen() {
        o1.setPreis(0, (squad.getModelle() - 1) * (getPts("Bolt carbine")));
        o1.alwaysSelected();
        o2.setSelected(0, helixAdept.isSelected());
        o3.alwaysSelected();
        sergeant.setSelected(true);

        if (squad.getModelle() <= 5)
            power = 5;
        else
            power = 10;
    }
}
