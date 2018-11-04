package oc.wh40k.units.dk;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DKEngineerSquad extends Eintrag {

	private static final Logger LOGGER = LoggerFactory.getLogger(DKEngineerSquad.class);

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	RuestkammerStarter rkTransport;
    AnzahlPanel squad;

	public DKEngineerSquad() {
		name = "Death Korps Engineer Squad";
		grundkosten = 10;
        überschriftSetzen = true;

        LOGGER.info(getKategorie());
        
		add(ico = new oc.Picture("oc/wh40k/images/IGVeteranSquad.jpg"));

		seperator();

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Engineers", 5, 10, 8));
        squad.setNichtDieErsteOption(true);

        seperator();

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox-caster", 1, 5));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Engineer with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Engineer with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Engineer with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Engineer with Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Demolition charge", "Engineer with Demolition charge", 20));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer-team", "Engineer Heavy Weapons Team with Heavy flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Mole launcher-team", "Engineer Heavy Weapons Team with Mole-launcher", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Upgrade to Watchmaster", 0));

        seperator(5);
        
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator(5);
		
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Melta bombs", 5));

        seperator();

    	add(o2 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Hades Breaching Drill", 60));
    
    	seperator();
    
		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer();
		add(rkTransport);
        
		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);
        
        if(kategorie==3){
        	rkTransport.setAktiv(squad.getModelle()==5);
        	o2.setAktiv(false);
        }else{
        	rkTransport.setAktiv(false);
        	o2.setAktiv(true);
        	o2.setSelected(true);
        }

	}

}
