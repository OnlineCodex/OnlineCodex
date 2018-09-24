package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMDeathCompany extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe boltpistole;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe kettenschwert;
	OptionsZaehlerGruppe nk;
	OptionsZaehlerGruppe hammer;
	OptionsEinzelUpgrade jet;

	boolean added = false;

	public IMDeathCompany() {
		name = "Death Company\n";
		grundkosten = 0;
		überschriftSetzen = true;
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Death Company Marines", 5, 15, getPts("Death Company")));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
		add(boltpistole = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer (BA)")));
		ogE.addElement(new OptionsGruppeEintrag("Inferno pistol", getPts("Inferno pistol (BA)")));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
		add(kettenschwert = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
		add(nk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (others)")));
		add(hammer = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		add(jet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump packs", getPts("Death Company with Jump Packs") - getPts("Death Company")));
        
		complete();
	}

	@Override
	public void refreshen() {
		boltpistole.setMaxAnzahl(squad.getModelle()-o1.getAnzahl() - hammer.getAnzahl());
		boltpistole.setAnzahl(0, boltpistole.getMaxAnzahl());
		o1.setMaxAnzahl(squad.getModelle() - hammer.getAnzahl());

		kettenschwert.setMaxAnzahl(squad.getModelle()-nk.getAnzahl() - hammer.getAnzahl());
		kettenschwert.setAnzahl(0,kettenschwert.getMaxAnzahl());
		nk.setMaxAnzahl(squad.getModelle() - hammer.getAnzahl());
		
		hammer.setMaxAnzahl(squad.getModelle() - (o1.getAnzahl()>nk.getAnzahl()?o1.getAnzahl():nk.getAnzahl()));
		
		jet.setPreis(squad.getModelle() * (getPts("Death Company with Jump Packs") - getPts("Death Company")));
		
		
		power = 9;
		if(squad.getModelle()>5){
			power +=9;
		}
		if(squad.getModelle()>10){
			power +=9;
		}
		if(jet.isSelected()){
			power +=squad.getModelle()/5;
		}
	}

	@Override
	public void deleteYourself() {
	}

}
