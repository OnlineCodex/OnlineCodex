package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMWolfGuardonBikes extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2, o2x;
    OptionsZaehlerGruppe o3, o3x;

    OptionsZaehlerGruppe wolfsklauen;


    public IMWolfGuardonBikes() {
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Guard on Bikes", 5, 10, getPts("Wolf Guard on Bikes")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        ogE.addAll(IMSpaceWolvesCombiWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
        ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
        ogE.remove(0);
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
        add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
        ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
        add(wolfsklauen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

        seperator();

        complete();
    }


    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());

        o2x.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - wolfsklauen.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - wolfsklauen.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - wolfsklauen.getAnzahl());

        o3x.setMaxAnzahl(squad.getModelle() - o3.getAnzahl() - wolfsklauen.getAnzahl());
        o3x.setAnzahl(0, squad.getModelle() - o3.getAnzahl() - wolfsklauen.getAnzahl());
        o3.setMaxAnzahl(squad.getModelle() - wolfsklauen.getAnzahl());

        wolfsklauen.setMaxAnzahl(squad.getModelle() - (o2.getAnzahl() > o3.getAnzahl() ? o2.getAnzahl() : o3.getAnzahl()));

        power = 14;
        if (squad.getModelle() > 5) {
            power += 14;
        }
    }
}
