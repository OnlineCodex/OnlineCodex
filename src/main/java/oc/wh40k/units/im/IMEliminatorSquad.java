package oc.wh40k.units.im;

import oc.*;

public class IMEliminatorSquad extends Eintrag {
	private final OptionsEinzelUpgrade sergeant;
	private final OptionsUpgradeGruppe o1, o2;
	private final AnzahlPanel squad;

    public IMEliminatorSquad() {
        name = "Eliminator Squad";
        
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Eliminators", 3, 3, getPts("Eliminator Squad") + getPts("Bolt pistol (SM)") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)"));
        add(squad);
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Bolt sniper rifles", getPts("Bolt sniper rifle")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eliminator Sergeant", getPts("Suppressor Sergeant")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt sniper rifle", getPts("Bolt sniper rifle")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
    }

    @Override
    public void refreshen() {
    	o1.setPreis("Bolt sniper rifles", getPts("Bolt sniper rifle")*(squad.getModelle()-1));
        o1.alwaysSelected();
        o2.alwaysSelected();
        sergeant.setSelected(true);

        power = 3;
    }
}