package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMScarabOccultTerminators extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole,sorcerer;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe sor;
	OptionsZaehlerGruppe o7;
    RuestkammerStarter chaosTransport;
	OptionsZaehlerGruppe schwereWaffe, rak;
    
	public CMScarabOccultTerminators() {
		//name = "Thousand Sons\n";
		grundkosten = 90;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Scarab Occult Terminators", 4, 9, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Seelenschnitterkanone", 30));
		add(schwereWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 20));
		add(rak = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		add(sorcerer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Scarab Occult Sorcerer", 0));
		sorcerer.setSelected(true);
		ogE.addElement(new OptionsGruppeEintrag("Inferno Kombi-Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 5));
		add(sor = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		sor.setSelected(0, true);
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gabe der Mutation", 10));
		
		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		chaosTransport.initKammer(false, true);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		complete();
	}

	@Override
	public void refreshen() {
		
		sorcerer.setSelected(true);
		
        int modelle = squad.getModelle() + 1;
        
        if(modelle >= 5)
        {
        	schwereWaffe.setMaxAnzahl(modelle/5);
        	rak.setMaxAnzahl(modelle/5);
        }
	}
}
