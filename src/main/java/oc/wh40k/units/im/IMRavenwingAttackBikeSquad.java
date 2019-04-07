package oc.wh40k.units.im;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRavenwingAttackBikeSquad extends Eintrag {



	private final OptionsZaehlerGruppe o1;



	private final AnzahlPanel squad;



    public IMRavenwingAttackBikeSquad() {

        name = "Ravenwing Attack Bike Squad";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Ravenwing Attack Bike Squad", 1, 3, getPts("Ravenwing Attack Bike Squad") + getPts("Twin boltgun") + 2 * getPts("Bolt pistol (SM)") + 2 * getPts("Frag grenade") + 2 * getPts("Krak grenade"));

        add(squad);



        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (SM)")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        o1.setAktiv(0, true);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        power = squad.getModelle() * 3;



        o1.setMaxAnzahl(squad.getModelle());

    }

}

