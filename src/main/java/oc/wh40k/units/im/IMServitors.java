package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMServitors extends Eintrag {

	private final OptionsZaehlerGruppe o3, o3x;


    public IMServitors() {
        name = "Servitors";
        grundkosten = (getPts("Servitors") * 4 + getPts("Servo-arm (AME)") * 2);
        power = 3;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Servo-arm", getPts("Servo-arm (AME)")));
        add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AME)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", getPts("Plasma cannon (AME)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (AME)")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    @Override
    public void refreshen() {
        o3x.setMaxAnzahl(2 - o3.getAnzahl());
        o3x.setAnzahl(0, 2 - o3.getAnzahl());
    }
}
