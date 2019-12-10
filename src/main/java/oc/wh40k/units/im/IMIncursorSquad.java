package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMIncursorSquad extends Eintrag {
	private final OptionsEinzelUpgrade sergeant;
	private final AnzahlPanel squad;

    public IMIncursorSquad() {
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Incursor", 5, 10, getPts("Incursor Squad") + getPts("Heavy bolt pistol") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)") + getPts("Shock grenades"));
        add(squad);

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire mine", getPts("Haywire mine")));

        seperator();

        add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reiver Sergeant", getPts("Incursor Sergeant")));
    }

    @Override
    public void refreshen() {
    	sergeant.setSelected(true);
    	
        if (squad.getModelle() <= 5)
            power = 5;
        else
            power = 10;
    }
}
