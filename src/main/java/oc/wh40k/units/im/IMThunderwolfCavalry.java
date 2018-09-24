package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMThunderwolfCavalry extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;

	public IMThunderwolfCavalry() {
		name = "Thunderwolf Cavalry\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Thunderwolf Cavalry", 3, 6, getPts("Thunderwolf Cavalry"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		o1.setAnzahl(0, 3);

		seperator();


		ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		o2.setAnzahl(0, 3);
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
		o1.setLegal(o1.getAnzahl() == squad.getModelle());
		o2.setLegal(o2.getAnzahl() == squad.getModelle());
		
		power = 8;
		if(squad.getModelle() > 3){
			power +=8;
		}
	}

}
