package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DATaktischerTrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o2;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkBoss;
    OptionsZaehlerGruppe bolter;
    OptionsZaehlerGruppe flakk;

	public DATaktischerTrupp() {
		name = "Taktischer Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DATacticalSquad.gif"));

		seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 14);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", "Bolter", 0));
		add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Flugabwehrraketen", "Flugabwehrraketen", 10));
		add(flakk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, false, false);
		rkBoss.setGrundkosten(0);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true, false, false,false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        
        if(squad.getModelle() < 10){
        	if(o1.isSelected() && !o2.isSelected()){
        		o2.setAktiv(false);
        		flakk.setAktiv(false);
        	} else if(o2.isSelected() && !o1.isSelected()){
        		o1.setAktiv(false);
        	} else {
        		o1.deselectAll();
        		o2.deselectAll();
        		o1.setAktiv(true);
        		o2.setAktiv(true);
        		flakk.setAktiv(true);
        	}
        } else{
    		o1.setAktiv(true);
    		o2.setAktiv(true);
        }
        flakk.setMaxAnzahl(o2.isSelected("Raketenwerfer")?1:0);
        
        bolter.setMaxAnzahl(squad.getModelle() - 1 - (o1.isSelected()?1:0) - (o2.isSelected()?1:0));
        bolter.setAnzahl(0, squad.getModelle() - 1 - (o1.isSelected()?1:0) - (o2.isSelected()?1:0));
	}

}
