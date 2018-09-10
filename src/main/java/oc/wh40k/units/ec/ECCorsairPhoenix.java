package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ECCorsairPhoenix extends Eintrag {

	OptionsZaehlerGruppe o1, o2, o1x, o2x;
	AnzahlPanel squad;
	OptionsEinzelUpgrade oe;
	
	public ECCorsairPhoenix() {
		name = "Corsair Phoenix Bomber";
		grundkosten = 225;

		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairPhoenixBomber.jpg"));
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsair Phoenix Bomber", 1, 2, 205);
        add(squad);
		
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Pulse Laser", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("TL Bright lances", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Starcannons", 0));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Phoenix Missiles", 0));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Nightfire Missiles", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair kinetic shroud", 15));
        
		complete();
	}

    @Override
	public void refreshen() {
    	o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
    	o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
    	o1.setMaxAnzahl(squad.getModelle());
    	o2x.setMaxAnzahl(squad.getModelle()-o2.getAnzahl());
    	o2x.setAnzahl(0,squad.getModelle()-o2.getAnzahl());
    	o2.setMaxAnzahl(squad.getModelle());
        oe.setModelle(squad.getModelle());
	}
    
}