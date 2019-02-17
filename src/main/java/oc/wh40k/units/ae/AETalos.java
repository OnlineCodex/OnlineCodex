package oc.wh40k.units.ae;



import oc.AnzahlPanel;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class AETalos extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2, o3;



    public AETalos() {

        name = "Talos";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Talos", 1, 3, getPts("Talos"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Macro-scalpel", getPts("Macro-scalpel")));

        ogE.addElement(new OptionsGruppeEintrag("Ichor injector", getPts("Ichor injector")));

        ogE.addElement(new OptionsGruppeEintrag("Twin liquifier gun", getPts("Twin liquifier gun")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Macro-scalpel", getPts("Macro-scalpel")));

        ogE.addElement(new OptionsGruppeEintrag("Chain-flails", getPts("Chain-flails")));

        ogE.addElement(new OptionsGruppeEintrag("Talos gauntlet", getPts("Talos gauntlet")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 Splinter cannons", 2 * getPts("Splinter cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Stinger pod", getPts("Stinger pod")));

        ogE.addElement(new OptionsGruppeEintrag("2 Heat lances", 2 * getPts("Heat lance")));

        ogE.addElement(new OptionsGruppeEintrag("2 Haywire blasters", 2 * getPts("Haywire blaster")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o2.setMaxAnzahl(squad.getModelle());

        o3.setMaxAnzahl(squad.getModelle());



        power = squad.getModelle() * 7;

    }

}