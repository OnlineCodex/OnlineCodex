package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMWulfen extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2, o2x;
	OptionsEinzelUpgrade oe1;

	public IMWulfen() {
		name = "Wulfen";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Wulfen", 5, 10, getPts("Wulfen"));
		add(squad);
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWGefolgederWolfsgarde.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stormfrag auto-launcher", getPts("stormfrag auto-launcher")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Wulfen claws", getPts("Wulfen claws")));
		add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Frost claws", getPts("frost claws")));
		ogE.addElement(new OptionsGruppeEintrag("great frost axe", getPts("great frost axe")));
		ogE.addElement(new OptionsGruppeEintrag("Hammer and	shield", "thunder hammer and storm shield", getPts("thunder hammer (others)") + getPts("storm shield (others)")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wulfen Pack Leader", getPts("Wulfen Pack Leader") + getPts("Frost claws")));
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);
		
		int nahkampfwaffen = squad.getModelle() - 1;
		int fernkampfwaffen = squad.getModelle() - 1;
		
		o1.setMaxAnzahl(nahkampfwaffen);
		o2.setMaxAnzahl(fernkampfwaffen);
		o2x.setMaxAnzahl(fernkampfwaffen - o2.getAnzahl());
		o2x.setAnzahl(0, fernkampfwaffen - o2.getAnzahl());
		
		power = 13;
		if(squad.getModelle()>5){
			power += 13;
		}
		
	}
}
