package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TYHiveGuard extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	
	public TYHiveGuard() {
		name = "Hive Guard";
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/TYTyrantenwachen.jpg"));
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Hive Guards", 3, 6, getPts("Hive Guard"));
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Impaler Cannon", getPts("Impaler cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Shockcannon", getPts("Shockcannon")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (others)")));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tyrant Guard)")));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1.setLegal(squad.getModelle() == o1.getAnzahl());
		
		oe1.setPreis(squad.getModelle() * getPts("Adrenal glands (others)"));
		oe2.setPreis(squad.getModelle() * getPts("Toxin sacs (Tyrant Guard)"));
		
		if(squad.getModelle() > 3){
			power = 14;
		} else {
			power = 7;
		}
	}

}
