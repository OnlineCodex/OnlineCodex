package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMPrimarisLieutenants extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;

    public IMPrimarisLieutenants() {

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Primaris Lieutenant", "Primaris Lieutenants", 1, 2, getPts("Primaris Lieutenants") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)")));

        seperator();

        //Special Weapons
        ogE.addElement(new OptionsGruppeEintrag("MC auto bolt rifle", "Master-crafted auto bolt rifle", getPts("Master-crafted auto bolt rifle")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("MC stalker bolt rifle", "Master-crafted stalker bolt rifle", getPts("Master-crafted stalker bolt rifle")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Dark Angels"))
        	addWeapons(IMDarkAngelsRuestkammer.class, true);
        else
        	addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {

        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle());

        power = squad.getModelle() * 5;
    }

}
