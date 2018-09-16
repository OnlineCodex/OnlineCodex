package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMKataphronBreachers extends Eintrag {

    AnzahlPanel Kampflaeuferschwadron;
    OptionsZaehlerGruppe o1, o2;
    OptionsZaehlerGruppe o1x, o2x;

    public IMKataphronBreachers() {

        name = "Kataphron Breachers";
        add(Kampflaeuferschwadron = new AnzahlPanel(ID, randAbstand, cnt, "Kataphron Breachers", 3, 12, getPts("Kataphron Breachers")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy arc rifle", getPts("Heavy arc rifle")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Kampflaeuferschwadron.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Torsion cannon", getPts("Torsion cannon")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Kampflaeuferschwadron.getModelle()));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Arc claw", getPts("Arc claw")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Kampflaeuferschwadron.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Hydraulic claw", getPts("Hydraulic claw")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Kampflaeuferschwadron.getModelle()));

        complete();

    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(Kampflaeuferschwadron.getModelle());
        o1x.setMaxAnzahl(Kampflaeuferschwadron.getModelle());
        o1x.setAnzahl(0, o1x.getMaxAnzahl() - o1.getAnzahl());

        o2.setMaxAnzahl(Kampflaeuferschwadron.getModelle());
        o2x.setMaxAnzahl(Kampflaeuferschwadron.getModelle());
        o2x.setAnzahl(0, o2x.getMaxAnzahl() - o2.getAnzahl());  
        
        power = 9;
		if(Kampflaeuferschwadron.getModelle() > 9){
			power = 36;
		} else if(Kampflaeuferschwadron.getModelle() > 6){
			power = 27;
		} else if(Kampflaeuferschwadron.getModelle() > 3){
			power = 18;
		}
    }
    
}
