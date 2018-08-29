package oc.wh40k.units.in;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class INInquisitordesOrdoMalleus extends Eintrag {

	OptionsEinzelUpgrade bp, cs;
    OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade psi;
    RuestkammerStarter relikte;

	public INInquisitordesOrdoMalleus() {
		name = "Inquisitor des Ordo Malleus";
		grundkosten = 25;
		

		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitordesOrdoMalleus.jpg"));
		
		seperator();
		
		add(bp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
		add(cs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kettenschwert", 0));
		bp.setSelected(true);
		cs.setSelected(true);
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenklinge", 15));
		ogE.addElement(new OptionsGruppeEintrag("Höllengewehr", 15));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servo-Rüstung", 8));
		ogE.addElement(new OptionsGruppeEintrag("Terminatorrüstung", 40));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Psibolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 3));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Psiaktive Munition", 5));
		ogE.addElement(new OptionsGruppeEintrag("Empyreische Hirnminen", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

        seperator();

		add(psi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 1", 30));

		seperator();

		relikte = new RuestkammerStarter(ID, randAbstand, cnt, "INRelikte", "");
		relikte.initKammer(true, false, false, false, false);
		relikte.setButtonText(BuildaHQ.translate("Relikte"));
		add(relikte);
		
		complete();
	}

	@Override
	public void refreshen() {
		bp.setAktiv(!o2.isSelected("Terminatorrüstung"));
		cs.setAktiv(!o2.isSelected("Terminatorrüstung"));
        o1.setAktiv(!o2.isSelected("Terminatorrüstung"));
        o3.setAktiv(o2.isSelected("Terminatorrüstung"));
        o4.setAktiv(o2.isSelected("Terminatorrüstung"));

        o1.setAktiv("Psischwert", psi.isSelected() && !o2.isSelected("Terminatorrüstung"));
        o3.setAktiv("Psischwert", psi.isSelected() && o2.isSelected("Terminatorrüstung") && !o4.isSelected("Psischwert"));
        o4.setAktiv("Psischwert", psi.isSelected() && o2.isSelected("Terminatorrüstung") && !o3.isSelected("Psischwert"));

        if(o2.isSelected("Terminatorrüstung")) o3.alwaysSelected();
        if(o2.isSelected("Terminatorrüstung")) o4.alwaysSelected();

        o1.setMaxAnzahl(2-(cs.isSelected()?1:0)-(bp.isSelected()?1:0));
        
        boolean legal=(o1.getAnzahl()+(cs.isSelected()?1:0)+(bp.isSelected()?1:0))==2;
        o1.setLegal(legal);
        bp.setLegal(legal);
        cs.setLegal(legal);
        
        if(((INRelikte)relikte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
