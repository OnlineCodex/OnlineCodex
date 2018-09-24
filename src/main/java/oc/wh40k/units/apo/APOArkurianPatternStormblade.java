//IA1 2nd Ed
package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class APOArkurianPatternStormblade extends Eintrag {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o2;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;
        OptionsZaehlerGruppe o5;
        OptionsZaehlerGruppe o5x;

	public APOArkurianPatternStormblade() {
		name = "Arkurian Pattern Stormblade";
		grundkosten = 455;


		add(ico = new oc.Picture("oc/wh40k/images/Stormblade.gif"));
		


        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 5));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Sturmbolter", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 50));
		ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

	    seperator();

	    ogE.addElement(new OptionsGruppeEintrag("LK + sync. schw. Bolter", "Laserkanone + synchronisierter schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("LK + sync. schw. Flamer", "Laserkanone + synchronisierter schwerer Flammenwerfer", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("ZE + sync. schw. Bolter", "Zielerfassung + synchronisierter schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("ZE + sync. schw. Flamer", "Zielerfassung + synchronisierter schwerer Flammenwerfer", 0));
		add(o5x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kommissar","Kommissariats-Besatzung", 45));
		ogE.addElement(new OptionsGruppeEintrag("Befehlspanzer",200));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
            o3.setAktiv(!o2.isSelected());
            o2.setAktiv(!o3.isSelected());
            
            o5x.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
            o5x.setMaxAnzahl(2);
            o5.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
            o5.setMaxAnzahl((o4.isSelected("zwei Seitenkuppeln") ? 2 : 4)-o5x.getAnzahl());
            o5.setLegal(o5.getAnzahl() == o5.getMaxAnzahl());
            o5x.setLegal(o5.getAnzahl() == o5.getMaxAnzahl() && (o5x.getAnzahl()==0 || o5x.getAnzahl()==2));
	}
}
