package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMRubricMarines extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
	OptionsZaehlerGruppe schwereWaffe, bolter;
    
	public CMRubricMarines() {
		//name = "Thousand Sons\n";
		grundkosten = 58;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Rubric Marines", 4, 19, 23);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
			
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone der Flammen", 15));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Infernobolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Warpflammenwerfer", 7));
		add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		bolter.setAnzahl(0, squad.getModelle());
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Seelenschnitterkanone", 25));
		add(schwereWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Aufstrebender Hexer");
		champion.initKammer(false, true);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		champion.setGrundkosten(0);
		add(champion);
		champion.setAbwaehlbar(false);
		
		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		complete();
	}

	@Override
	public void refreshen() {
		
        if(!champion.isSelected()) champion.setSelected(true);
		
        int modelle = squad.getModelle() + 1;
        
        if(modelle >= 10)
        	schwereWaffe.setMaxAnzahl(modelle/10);
        
        bolter.setMaxAnzahl(squad.getModelle() - schwereWaffe.getAnzahl());
        
		chaosTransport.getPanel().setLocation(
				(int) chaosTransport.getPanel().getLocation().getX(),
				(int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
	    );
	}
}
