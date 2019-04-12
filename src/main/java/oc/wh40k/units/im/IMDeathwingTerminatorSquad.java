package oc.wh40k.units.im;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;



public class IMDeathwingTerminatorSquad extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o3, stormbolter, fist;

	private final OptionsUpgradeGruppe oe1;

	private final OptionsEinzelUpgrade sergeant;



    public IMDeathwingTerminatorSquad() {

        name = "Deathwing Terminator Squad";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathwing Terminator Squad", 5, 10, getPts("Deathwing Terminator Squad"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));

        add(stormbolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        stormbolter.setAnzahl(0, 4);



        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));

        ogE.addElement(new OptionsGruppeEintrag("Chainfist fist", getPts("Chainfist fist (SM)")));

        add(fist = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        fist.setAnzahl(0, 4);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));

        ogE.addElement(new OptionsGruppeEintrag("Hammer and Shield", getPts("Thunder hammer (others)") + getPts("Storm shield (others)")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", getPts("Plasma cannon (SM)")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));

        ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Cyclone ML", getPts("Cyclone Missile launcher")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sergeant", getPts("Sergeant")));



        ogE.addElement(new OptionsGruppeEintrag("Power sword and storm bolter", getPts("Power sword (SM)") + getPts("Storm bolter (SM)")));

        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));

        ogE.addElement(new OptionsGruppeEintrag("Hammer and Shield", getPts("Thunder hammer (others)") + getPts("Storm shield (others)")));

        add(oe1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        oe1.setSelected(0, true);



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Watcher in the Dark", getPts("Watcher in the Dark")));



        complete();

    }



    @Override

    public void refreshen() {

        sergeant.setSelected(true);



        if (squad.getModelle() > 5) {

            power = 26;

        } else {

            power = 13;

        }



        int replaceStormbolter = 0;

        if (o3.isSelected() && !o3.isSelected("Cyclone ML")) replaceStormbolter = 1;



        fist.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl());

        stormbolter.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl() - replaceStormbolter);



        if (squad.getModelle() == 10) {

            o3.setMaxAnzahl(2);

        } else {

            o3.setMaxAnzahl(1);

        }

    }

}

