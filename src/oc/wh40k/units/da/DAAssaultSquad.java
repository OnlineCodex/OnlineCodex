package oc.wh40k.units.da;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DAAssaultSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade jump;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkBoss;

	public DAAssaultSquad() {
		name = "Sturmtrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DAAssaultSquad.gif"));

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 14);
		add(squad);

		seperator(8);
		
		add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 3));
		jump.setSelected(true);
		
		seperator(0);

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 25));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,2));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, true, false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true, false, false,true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        rkTransport.setAktiv(!jump.isSelected());
        
        o2.setMaxAnzahl(squad.getModelle()==10?2:1);
        
		//Detachments
		if(getCountFromInformationVector("Battle Company")>0){
			((DATransporterKammer)rkTransport.getKammer()).mod=0;
		}
		
		jump.setPreis(squad.getModelle()*3);
	}

}

