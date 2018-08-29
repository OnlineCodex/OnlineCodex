package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMSeuchenmarines extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    boolean spezial=false;
    
	public CMSeuchenmarines() {
		//name = "Seuchenmarines\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Seuchenmarines", 5, 20, 24);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
			
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone der Verzweiflung", 10));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
				
		ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 1));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Seuchenchampion",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		champion.initKammer(false,false,false, false, true, false);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		add(champion);
		champion.setAbwaehlbar(false);
		seperator();

		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
        addToInformationVector("CMPlague", 1);
        
		complete();
	}

	@Override
	public void refreshen() {
		if(spezial==false){
			buildaVater.getChooserGruppeForChange(4).addSpezialAuswahl("[IA Apo 2013] Blight Drones of Nurgle");
	        buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("[Forgeworld] Plague Ogryns");
	        buildaVater.getChooserGruppeForChange(5).addSpezialAuswahl("[IA Apo 2013] Plague Hulk of Nurgle");
		}
		
		if(getCountFromInformationVector("BlackLegion")==1){
			vdlk.setSelected(0, true);
		}
		
		int count = squad.getModelle();
		
		vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);
		
        if(!champion.isSelected()) champion.setSelected(true);

		chaosTransport.getPanel().setLocation(
			(int) chaosTransport.getPanel().getLocation().getX(),
			(int) chaosTransport.getPanel().getLocation().getY() + chaosTransport.getPanel().getSize().height + 5
		);
		
		chaosTransport.getPanel().setLocation(
				(int) chaosTransport.getPanel().getLocation().getX(),
				(int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
	    );
	}
	
	@Override
    public void deleteYourself() {
		addToInformationVector("CMPlague", -1);
    	
    	if(getCountFromInformationVector("CMDreadPlague")<1 && getCountFromInformationVector("CMPlague")<1){
	        buildaVater.getChooserGruppeForChange(4).removeSpezialAuswahl("[IA Apo 2013] Blight Drones of Nurgle");
	        buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("[Forgeworld] Plague Ogryns");
	        buildaVater.getChooserGruppeForChange(5).removeSpezialAuswahl("[IA Apo 2013] Plague Hulk of Nurgle");
    	}
        super.deleteYourself();
    }
}
