package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class AEStormGuardians extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2, o3, o4, o5;



    public AEStormGuardians() {

        name = "Storm Guardians";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Storm Guardians", 8, 24, getPts("Storm Guardians") + getPts("Shuriken pistol") + getPts("Sunburst grenade"));

        add(squad);



        ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));

        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 8));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Aeldari blade", getPts("Aeldari blade")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 8));



        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));

        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 8));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));

        ogE.addElement(new OptionsGruppeEintrag("Fusion gun", getPts("Fusion gun")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));



        seperator();



        complete();

    }



    //@OVERRIDE

    @Override
	public void refreshen() {



        o4.setMaxAnzahl(squad.getModelle() - o3.getAnzahl());

        o4.setAnzahl(0, squad.getModelle() - o3.getAnzahl());



        o1.setMaxAnzahl(squad.getModelle() - o5.getAnzahl() - o2.getAnzahl() - o3.getAnzahl());

        o1.setAnzahl(0, squad.getModelle() - o5.getAnzahl() - o2.getAnzahl() - o3.getAnzahl());



        o5.setMaxAnzahl(squad.getModelle() - o2.getAnzahl());



        if (squad.getModelle() > 16) {

            power = 9;

        } else if (squad.getModelle() > 8) {

            power = 6;

        } else {

            power = 3;

        }

    }

}

