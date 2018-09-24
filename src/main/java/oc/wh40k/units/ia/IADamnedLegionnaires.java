package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IADamnedLegionnaires extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	OptionsEinzelUpgrade flakk;
	OptionsUpgradeGruppe o1;

	public IADamnedLegionnaires() {
		name = "Legion of the Damned\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Legionäre", 5, 10, 25);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMLegionoftheDamnedSquad.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
		add(o1=new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		add(flakk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flugabwehrraketen", 10));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, false, false, true, false, false, false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		flakk.setAktiv(o1.isSelected("Raketenwerfer"));
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        ((IASergeant)rkBoss.getKammer()).LotDDetachment=getCountFromInformationVector("Legion of the Damned")>0;
        
        if(getCountFromInformationVector("The Legion Ascendant (LotD)")> 0){
        	squad.setModelle(10);
        }
        
        if(((IASergeant)rkBoss.getKammer()).uniqueError){
        	setFehlermeldung("Artefakt doppelt");
        }else{
        	setFehlermeldung("");
        }
        
	}

}

