package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

//[IA3 2nd Ed]

public class TADX6RemoraStealthDroneSquadron extends Eintrag {

	private final OptionsZaehlerGruppe o1, o2;
	private final AnzahlPanel squad;
	
	public TADX6RemoraStealthDroneSquadron() {
        name = "DX-6 \'Remora\' Drone Fighter";
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "DX-6 \'Remora\' Drone Fighter", 1, 6, getPts("DX-6 Remora Stealth Drone")));

        add(ico = new oc.Picture("oc/wh40k/images/DX6RemoraDroneFighter.jpg"));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("2 long-barrelled burst cannon", getPts("Long-barrelled burst cannon") * 2));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Seeker missiles", getPts("Seeker missile")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        
        complete();
    }

    @Override
    public void refreshen() {
    	o1.setMaxAnzahl(squad.getModelle());
    	o1.setAnzahl(0, squad.getModelle());
    	o2.setMaxAnzahl(squad.getModelle() * 2);
    	
    	power = squad.getModelle() * 3;
    }

}
