package oc.wh40k.units.as;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;


public class ASKommandotrupp extends Eintrag {

	OptionsZaehlerGruppe o1, o2, o3a, o3b;
	OptionsUpgradeGruppe o5;
	RuestkammerStarter waffenUndRelikte;
	RuestkammerStarter rkTransport;
	OptionsUpgradeGruppe vdlk;
	OptionsEinzelUpgrade hospitalis;
	OptionsUpgradeGruppe si;

	boolean added = false;

	public ASKommandotrupp() {
		name = "Kommandotrupp";
		grundkosten = 65;
		this.setEintragsCNT(0);
		überschriftSetzen = true;

		addToInformationVector("ASKommandotrupp", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASCelestiatrupp.jpg"));

		seperator();
		
		add(hospitalis = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hospitalis", 10));
		
		seperator();
		
		waffenUndRelikte = new RuestkammerStarter(ID, randAbstand, cnt, "ASWaffenUndRelikte", "Dialogis");
		waffenUndRelikte.initKammer(false, false, true);
		waffenUndRelikte.setButtonText("Dialogis");
		waffenUndRelikte.setGrundkosten(5);
		add(waffenUndRelikte);
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 25));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		o1.setAnzahl(0, 5);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		o2.setAnzahl(0, 5);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		add(o3a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombiflamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Condemnor-Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o3b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heiliges Banner", 15));
		ogE.addElement(new OptionsGruppeEintrag("Banner des Ordo Militaris", 40));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Simulacrum Imperialis", 10));
		add(si = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ASTransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {

        int schwestern = 5 - (hospitalis.isSelected()?1:0) - (waffenUndRelikte.isSelected()?1:0) - (si.isSelected()?1:0) -(o5.isSelected()?1:0) ;
        
        int bp=o1.getAnzahl();
        int b=o2.getAnzahl();
        
        o1.setMaxAnzahl(schwestern);
        o2.setMaxAnzahl(schwestern);
        o3a.setMaxAnzahl(schwestern - (bp>b?b:bp));
        o3b.setMaxAnzahl(schwestern - (bp>b?b:bp));
        
        boolean legal = (o1.getAnzahl() + o2.getAnzahl() + o3a.getAnzahl() + o3b.getAnzahl()) == schwestern * 2;
        
        o1.setLegal(legal);
        o2.setLegal(legal);
        o3a.setLegal(legal);
        o3b.setLegal(legal);
        
		int selectedSquads = getCountFromInformationVector("ASKommandotrupp");
		int possibleSquads = getCountFromInformationVector("ASPrincipalis");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Gefolge > " + possibleSquads + "!");
		} else if(((ASWaffenUndRelikte)waffenUndRelikte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
		
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("ASKommandotrupp", -1);
	}

}
