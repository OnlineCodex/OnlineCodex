package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMCenturionAssaultSquad extends Eintrag {

	AnzahlPanel squad;
	protected OptionsEinzelZaehler o1;
	protected OptionsEinzelZaehler o1x;
	protected OptionsZaehlerGruppe o2;
	protected OptionsZaehlerGruppe o2x;

	public IMCenturionAssaultSquad() {
		name = "Centurion Assault Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Centurions", 3, 6, getPts("Centurion Assault Squad"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMTerminatorSturmtrupp.jpg"));

		seperator();

		add(o1x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Centurion a. launcher", "Centurion assault launcher", -88, getPts("Centurion assault launcher")));
		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hurricane bolter", -88, getPts("Hurricane bolter")));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Flamers", getPts("Flamer (SM)") * 2));
		add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Meltaguns", getPts("Meltagun (SM)") * 2));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		complete();
	}

	@Override
	public void refreshen() {
		
		o1.setMaxAnzahl(squad.getModelle());
		o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
		o1x.setAnzahl(squad.getModelle()-o1.getAnzahl());

		o2.setMaxAnzahl(squad.getModelle());
		o2x.setMaxAnzahl(squad.getModelle()-o2.getAnzahl());
		o2x.setAnzahl(0,squad.getModelle()-o2.getAnzahl());
		
		power = 15;
		if(squad.getModelle() > 3){
			power = 30;
		}
		
    }
	
}
