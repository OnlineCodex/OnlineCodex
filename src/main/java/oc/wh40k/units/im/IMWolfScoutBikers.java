package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMWolfScoutBikers extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1x;
	private final OptionsZaehlerGruppe o1;

    public IMWolfScoutBikers() {
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Scout Bikers", 3, 10, getPts("Wolf Scout Bikers") +
                getPts("bolt pistol (SM)") +
                getPts("Astartes shotgun") +
                getPts("combat knife") +
                getPts("frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Twin boltgun")));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

        seperator();
        
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Astartes grenade launcher", 3, getPts("Astartes grenade launcher") - getPts("twin boltgun")));


        complete();
    }

    @Override
    public void refreshen() {
    	o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
    	o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
    	o1.setMaxAnzahl(squad.getModelle());
    	
        power = 4;
        if (squad.getModelle() > 6) {
            power = 12;
        } else if (squad.getModelle() > 3) {
            power = 8;
        }
    }

}
