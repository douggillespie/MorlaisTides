package morlaistidedata;

import PamView.symbol.StandardSymbolManager;
import PamguardMVC.PamDataBlock;
import PamguardMVC.PamProcess;

public class MorlaisTideDataBlock extends PamDataBlock<MorlaisTideDataUnit> {

	public MorlaisTideDataBlock(PamProcess parentProcess) {
		super(MorlaisTideDataUnit.class, "Flow data", parentProcess, 2^15-1);
		setPamSymbolManager(new StandardSymbolManager(this, MorlaisTideOverlayDraw.defaultSymbol.getSymbolData()));
	}

}
