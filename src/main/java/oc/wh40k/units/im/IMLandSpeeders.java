package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMLandSpeeders extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o1x;
    private final OptionsZaehlerGruppe o2;
    private boolean spacewolves = false;

    public IMLandSpeeders() {
    	spacewolves = BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves");
        name = "Land Speeders";

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Land Speeder", "Land Speeders", 1, 3, getPts("Land Speeders"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        if(!spacewolves) {
        	ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer (SM)")));
        }
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        seperator();

        if(!spacewolves) {
	        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter (SM)")));
	        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));
        }
        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle());

        power = squad.getModelle() * 6;
    }

}
