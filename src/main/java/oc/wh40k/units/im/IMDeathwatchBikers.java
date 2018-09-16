package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMDeathwatchBikers extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o3;
	RuestkammerStarter waffenUndReliquien;
	
	public IMDeathwatchBikers() {
		name = "Bike Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Bikers", 3, 6, getPts("Deathwatch Bikers"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/Bikeschwadron.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Deathwatch teleport homer", getPts("Deathwatch teleport homer")));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DeathWatchKammer", "Biker Sergeant");
		((DeathWatchKammer)waffenUndReliquien.getKammer()).setType("Biker");
		waffenUndReliquien.initKammer();
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Biker Sergeant"));
		waffenUndReliquien.setUeberschriftTrotzNullKostenAusgeben(true);
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o3.setMaxAnzahl(squad.getModelle());
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}

