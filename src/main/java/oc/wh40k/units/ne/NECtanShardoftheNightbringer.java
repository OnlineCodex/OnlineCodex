package oc.wh40k.units.ne;


import oc.Eintrag;

public class NECtanShardoftheNightbringer extends Eintrag {


	public NECtanShardoftheNightbringer() {
		name = "C'tan Shard of the Nightbringer";
		grundkosten = getPts("C'tan Shard of the Nightbringer");

		add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));
		
		seperator();

        
		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);
		power = 12;
	}
}
