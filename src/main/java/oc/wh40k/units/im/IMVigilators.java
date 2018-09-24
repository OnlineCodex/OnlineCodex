package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMVigilators extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelUpgrade superior;

	public IMVigilators() {
		name = "Vigilators\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Vigilators", 5, 10, getPts("Vigilators"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Executioner greatblade", getPts("Executioner greatblade")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
        
        add(superior = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sister Superior", getPts("Sister Superior")));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1.setAnzahl(0, squad.getModelle());
		superior.setSelected(true);
	}

}
