package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMSuppressorSquad extends Eintrag {
	private final OptionsEinzelUpgrade sergeant;
	private final OptionsUpgradeGruppe o1, o2;
	private final AnzahlPanel squad;

    public IMSuppressorSquad() {
        name = "Suppressor Squad";

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Suppressors", 3, 3, getPts("Suppressor Squad") + getPts("Bolt pistol (SM)") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)") + getPts("Grav-chute"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Accelerator autocannons", getPts("Accelerator autocannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suppressor Sergeant", getPts("Suppressor Sergeant")));
        ogE.addElement(new OptionsGruppeEintrag("Accelerator autocannon", getPts("Accelerator autocannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
    }

    @Override
    public void refreshen() {
    	o1.setPreis("Accelerator autocannons", getPts("Accelerator autocannon")*(squad.getModelle()-1));
        o1.alwaysSelected();
        o2.alwaysSelected();
        sergeant.setSelected(true);

        power = 5;
    }
}
