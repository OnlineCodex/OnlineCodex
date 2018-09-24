package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ECCorsairFirePrism extends Eintrag {

	OptionsZaehlerGruppe o1, o1x;
	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1, oe2, oe3;

	public ECCorsairFirePrism() {
		name = "Corsair Fire Prism\n";
		überschriftSetzen=true;
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairWarpHunter.jpg"));
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsair Fire Prism", 1, 3, 125);
        add(squad);

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("TL Shuriken catapults", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair void burners", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair kinetic shroud", 15));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Star engines", 15));

		complete();
	}

    @Override
	public void refreshen() {
    	o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
        o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle());
        
        oe1.setModelle(squad.getModelle());
        oe2.setModelle(squad.getModelle());
        oe3.setModelle(squad.getModelle());
	}
    
}