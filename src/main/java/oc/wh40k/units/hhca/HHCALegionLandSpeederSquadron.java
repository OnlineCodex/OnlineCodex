package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class HHCALegionLandSpeederSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2, o3, o4, o5;

	public HHCALegionLandSpeederSquadron() {
		name = "Legion Land Speeder Squadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Land Speeder", 1, 5, 50);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 30));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
        
		o2.setMaxAnzahl(squad.getModelle());
		
		o1.setMaxAnzahl(squad.getModelle()-o2.getAnzahl());
		o1.setAnzahl(0, o2.getMaxAnzahl()-o2.getAnzahl());
		
		o3.setMaxAnzahl(squad.getModelle());
		o4.setMaxAnzahl(squad.getModelle()*2);
	}

}
