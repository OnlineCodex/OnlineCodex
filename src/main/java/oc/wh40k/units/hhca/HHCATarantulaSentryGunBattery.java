package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class HHCATarantulaSentryGunBattery extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2, o4;
	OptionsUpgradeGruppe o3, o5;

	public HHCATarantulaSentryGunBattery() {
		name = "Tarantula Sentry Gun Battery\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sentry Gun", "Sentry Guns", 1, 3, 30);
		add(squad);

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked rotor cannons", 5));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Hyperios missile launchers", "Hyperios air-defence missile launchers", 20));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Hyperios command platform", 10));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Concealment", 10));
		ogE.addElement(new OptionsGruppeEintrag("Forward Deployment", 5));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
        o1.setAktiv(!o3.isSelected());
        o2.setAktiv(!o3.isSelected());
        o4.setAktiv(o3.isSelected());
		
		o3.setPreis(0, squad.getModelle()*20);
		o5.setPreis(0, squad.getModelle()*10);
		o5.setPreis(1, squad.getModelle()*5);
				 
        o2.setMaxAnzahl(squad.getModelle());
        o4.setMaxAnzahl(squad.getModelle());
		
		o1.setMaxAnzahl(squad.getModelle()-o2.getAnzahl());
		o1.setAnzahl(0, o2.getMaxAnzahl()-o2.getAnzahl());
	}

}
