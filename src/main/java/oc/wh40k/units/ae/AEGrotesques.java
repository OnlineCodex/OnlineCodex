package oc.wh40k.units.ae;



import oc.AnzahlPanel;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class AEGrotesques extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2, o3;



    public AEGrotesques() {

        name = "Grotesques";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Grotesques", 3, 10, getPts("Grotesque") + getPts("Flesh gauntlet"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Monstrous cleaver", getPts("Monstrous cleaver")));

        ogE.addElement(new OptionsGruppeEintrag("Liquifier gun", getPts("Liquifier gun")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        o1.setAnzahl(0, squad.getModelle());



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Flesh gauntlet", getPts("Flesh gauntlet")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        ogE.addElement(new OptionsGruppeEintrag("Monstrous cleaver (Index)", getPts("Monstrous cleaver")));

        ogE.addElement(new OptionsGruppeEintrag("Agoniser (Index)", getPts("Agoniser")));

        ogE.addElement(new OptionsGruppeEintrag("Electrocorrosive whip (Index)", getPts("Electrocorrosive whip")));

        ogE.addElement(new OptionsGruppeEintrag("Mindphase gauntlet (Index)", getPts("Mindphase gauntlet")));

        ogE.addElement(new OptionsGruppeEintrag("Scissorhand (Index)", getPts("Scissorhand")));

        ogE.addElement(new OptionsGruppeEintrag("Venom blade (Index)", getPts("Venom blade")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o3.setMaxAnzahl(squad.getModelle() - (o2.isSelected() ? 1 : 0));

        o3.setAnzahl(0, squad.getModelle() - (o2.isSelected() ? 1 : 0));



        power = squad.getModelle() * 2;

    }



}

