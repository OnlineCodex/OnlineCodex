package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class NETombBlades extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1x,o1,o2,o3;

	public NETombBlades() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Tomb Blades", 3, 9, getPts("Tomb blades"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NETombBlades.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("2 Gauss blasters", getPts("Gauss blaster")*2));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("2 Tesla carabine", getPts("Tesla carabine")*2));
		ogE.addElement(new OptionsGruppeEintrag("Particle beamer", getPts("Particle beamer")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shieldvanes", getPts("Shieldvanes")));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Nebuloscope", getPts("Nebuloscope")));
		ogE.addElement(new OptionsGruppeEintrag("Shadowloom", getPts("Shadowloom")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		complete();
	}

	@Override
	public void refreshen() {
        
		o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
		o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
		o1.setMaxAnzahl(squad.getModelle());
		
		o2.setMaxAnzahl(squad.getModelle());
		o3.setMaxAnzahl(squad.getModelle());
		
		power = 5 + ((squad.getModelle() > 3)?5:0) + ((squad.getModelle() > 6)?4:0);
	}
}
