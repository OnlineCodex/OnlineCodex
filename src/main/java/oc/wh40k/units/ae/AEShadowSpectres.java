package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Source;

import static oc.BuildaHQ.pts;
import static oc.wh40k.units.Publication.IMPERIAL_ARMOUR_XENOS;
import static oc.wh40k.units.ae.AEExarch.ExarchType.SHADOW_SPECTRES;

@Source(value = IMPERIAL_ARMOUR_XENOS, page = 62)
public class AEShadowSpectres extends Eintrag {

    private final AnzahlPanel squad;
    private final RuestkammerStarter exarch;

    public AEShadowSpectres() {
        super();
        name = "Shadow Spectres [FW]";
        power = 6;

        squad = add(new AnzahlPanel(ID, randAbstand, cnt, "Shadow Spectres", 3, 10,
                pts("Shadow Spectres")
                + pts("prism rifle")
                + pts("sunburst grenades")));
        seperator();

        final int exarchSurcharge = pts("Shadow Spectre Exarch") - pts("Shadow Spectres");
        exarch = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch(SHADOW_SPECTRES, pts("prism rifle"), exarchSurcharge));
        exarch.setGrundkosten(exarchSurcharge);
        exarch.initKammer();
        exarch.setUeberschriftTrotzNullKostenAusgeben(true);
        exarch.setAbwaehlbar(true);
        add(exarch);
    }

    @Override
    public void refreshen() {
        int models = squad.getModelle();
        if (models > 5) {
            power = 19;
        } else if (models > 3){
            power = 10;
        } else {
            power = 6;
        }
    }
}
