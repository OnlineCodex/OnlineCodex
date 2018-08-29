package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMKataphronDestroyers extends Eintrag {

    AnzahlPanel Kampflaeuferschwadron;
    OptionsZaehlerGruppe o1, o2;
    OptionsZaehlerGruppe o1x, o2x;

    public IMKataphronDestroyers() {

        name = "Kataphron Destroyers";
        add(Kampflaeuferschwadron = new AnzahlPanel(ID, randAbstand, cnt, "Kataphron Destroyers", 3, 12, getPts("Kataphron Destroyers")));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Plasma culverin", getPts("Plasma culverin")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Kampflaeuferschwadron.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Heavy grav cannon", getPts("Heavy grav cannon")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Kampflaeuferschwadron.getModelle()));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Phosphor blaster", getPts("Phosphor blaster")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Kampflaeuferschwadron.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Cognis flamer", getPts("Cognis flamer")));
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
        
        power = 10;
		if(Kampflaeuferschwadron.getModelle() > 9){
			power = 40;
		} else if(Kampflaeuferschwadron.getModelle() > 6){
			power = 30;
		} else if(Kampflaeuferschwadron.getModelle() > 3){
			power = 20;
		}
    }
    
}
