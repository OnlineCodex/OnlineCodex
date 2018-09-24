package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKLibrarian extends Eintrag {
	//TODO Ausrüstung in eine Kammer verlegen. Artefakte richtig handhaben

	OptionsUpgradeGruppe o1, o1x;
	OptionsUpgradeGruppe o2, reliquien;

	public GKLibrarian() {
		name = "Scriptor";
		grundkosten = 110;

		add(ico = new oc.Picture("oc/wh40k/images/GKGrossmeisterderGGKScriptorreyKnights.jpg"));
		addToInformationVector("GKHQ", 1);
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 3", 25));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 0));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 0));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 5));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 10));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe Meisterhaft", 10));
        ogE.addElement(new OptionsGruppeEintrag("Fernkampfwaffe Meisterhaft", 10));
        add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Deimos Wut", 15));
		ogE.addElement(new OptionsGruppeEintrag("Knochensplitter", "Knochensplitter des Solor", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kürass der Märtyer", "Kürass der Märtyer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Seelengleve", 20));
		ogE.addElement(new OptionsGruppeEintrag("Domina Liber Daemonica", "Domina Liber Daemonica", 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
		add(reliquien = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {


		boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics")>0;
		
		reliquien.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics);
		reliquien.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics);
		reliquien.setAktiv("Castigator (GS)", EcclesiarchyRelics);
		reliquien.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics);
		reliquien.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics);
		reliquien.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics);
		
        if(!o2.isSelected()) o2.setSelected(0, true);
        
        if(reliquien.isSelected("Deimos Wut"))
        {
        	o1.setAktiv(false);
        	o1x.setAktiv(1, false);
        }
        else
        {
        	o1.setAktiv(true);
        	o1x.setAktiv(1, true);
        }
        
        if(reliquien.isSelected("Seelengleve") || reliquien.isSelected("Blade of the Worthy (GS)"))
        {
        	o2.setAktiv(false);
        }
        else
        {
        	o2.setAktiv(true);
        }
	}
	
    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("GKHQ", -1);
    }

}
